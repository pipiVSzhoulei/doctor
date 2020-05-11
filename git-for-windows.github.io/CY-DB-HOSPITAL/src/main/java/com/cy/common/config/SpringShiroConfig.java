package com.cy.common.config;


import java.util.LinkedHashMap;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;


/**
 * @Configuration 此注解描述的是一个配置类
 * @author 18134
 *
 */
@Configuration//bean对象
public class SpringShiroConfig {
	
//	@Bean
//	public SecurityManager securityManager(
//			Realm realm,
//			CacheManager cacheManagetr,
//			RememberMeManager rememberManager,
//			SessionManager sessionManager) {
//
//		DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
//		sManager.setRealm(realm);
//		sManager.setCacheManager(cacheManagetr);
//		sManager.setRememberMeManager(rememberManager);
//		sManager.setSessionManager(sessionManager);
//		return sManager;
//	}

	@Bean
	public SecurityManager securityManager(Realm realm) {
		DefaultWebSecurityManager sManager= new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		return sManager;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactory (
			@Autowired SecurityManager securityManager) {
		ShiroFilterFactoryBean sfBean=
				new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		//指定访问登录权限访问路径	
		sfBean.setLoginUrl("/doLoginUI");
		//定义map指定请求过滤规则(哪些资源允许匿名访问,哪些必须认证访问)
		LinkedHashMap<String,String> map=
				new LinkedHashMap<>();
		//静态资源允许匿名访问:"anon"
		map.put("/bower_components/**","anon");
		map.put("/img/**","anon");
		map.put("/dist/**","anon");
		map.put("/plugins/**","anon");
		map.put("/sao/**","anon");
		map.put("/SignIn/**","anon");
		map.put("/img/**","anon");
		map.put("/images/**","anon");
		map.put("/scripts/**","anon");
		map.put("/account/login","anon");
		map.put("/doLogout","logout");
		//除了匿名访问的资源,其它都要认证("authc")后访问
		map.put("/**","authc");
		sfBean.setFilterChainDefinitionMap(map);
		return sfBean;
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor newAuthorizationAttributeSourceAdvisor(
			SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}

}
