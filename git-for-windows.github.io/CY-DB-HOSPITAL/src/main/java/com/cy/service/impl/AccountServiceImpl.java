package com.cy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.dao.AccountDao;
import com.cy.pojo.Account;
import com.cy.service.AccountService;
import com.cy.util.Assert;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired 
	private AccountDao accountDao;
	
	
	/*根据姓名查询用户信息  判断此用户是否存在 并返回期望值  权限等级*/
	@Override
	public int getRowsByName(String username,String password) {
		Assert.isArgumentValid(
				username==null||username.equals("")||username=="姓名",
				"请先登录");
		int rowsByName = accountDao.getRowsByName(username);
		Assert.isServiceValid(rowsByName==0, "此用户尚未注册");
		Account account = accountDao.getVerification(username);
		System.out.println(account.getGrade());
		Assert.isServiceValid(!account.getPassword().equals(password), "账户或密码错误1");
		if(account.getGrade()==1) {
			return 0;
		}else {
			Assert.isMessage("医师用户登录和管理员登录 还没做 不要急 有机会再说");
		}
		return rowsByName;
	}


	@Override
	public int getGrade(String username) {
		Assert.isArgumentValid(
				username==null||username.equals("")||username=="姓名",
				"请先登录");
		int rowsByName = accountDao.getGrade(username);
		Assert.isServiceValid(rowsByName==0, "此用户没有赋予任何权限");
		return rowsByName;
	}


	@Override
	public int root(String username, String url) {
		Account ver = accountDao.getVerification(username);
		Integer grade = ver.getGrade();
//		if(grade==1) {
//			Assert.isServiceValid(url=="doctorListRoot", "权限不足");
//			Assert.isServiceValid(url=="userListRoot", "权限不足");
//			Assert.isServiceValid(url=="goDocsPat", "权限不足");
//			Assert.isServiceValid(url=="goRepoList", "权限不足");
//		}else if(grade==2) {
//			Assert.isServiceValid(url=="list", "不必要访问项");
//			Assert.isServiceValid(url=="edit", "不必要访问项");
//			Assert.isServiceValid(url=="doctorListRoot", "权限不足");
//			Assert.isServiceValid(url=="userListRoot", "权限不足");
//		}else if(grade==3) {
//			String value="我都行";
//		}else {
//			Assert.isMessage("意料之外的错误");
//			
//		}
			
		
		return grade;
	}

	
	
}
