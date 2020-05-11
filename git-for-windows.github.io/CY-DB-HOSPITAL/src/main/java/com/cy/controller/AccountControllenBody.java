package com.cy.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pojo.Doctor;
import com.cy.pojo.UserContent;
import com.cy.service.AccountService;
import com.cy.service.DoctorRootService;
import com.cy.service.PatientRootService;
import com.cy.util.Assert;
import com.cy.vo.JsonResult;

/**
 * 登录信息
 * @author 18134
 *
 */
@RestController
@RequestMapping("/account/")
public class AccountControllenBody {

	@Autowired
	private AccountService accountService;
	@Autowired
	private DoctorRootService adminDoctorService;
	@Autowired
	private PatientRootService patientService;
	
	@RequestMapping("login")
	public JsonResult Login(String username,String password) {
		   //1.获取Subject对象
		   Subject subject=SecurityUtils.getSubject();
		   //2.通过Subject提交用户信息,交给shiro框架进行认证操作
		   //2.1对用户进行封装
		   UsernamePasswordToken token=
		   new UsernamePasswordToken(
				   username,//身份信息
				   password);//凭证信息
		   //2.2对用户信息进行身份认证
		   subject.login(token);

		return new JsonResult("登录成功");
	}
	
	
	@RequestMapping("loginLn")
	public JsonResult loginLn(String username) {
		/*根据信息查询*/
		int rows=accountService.getGrade(username);
		/*判断乘客权限等级 进行分类判断是患者还是医师*/
		UserContent patient = null; //（1表示该用户是患者 2表示 该用户是医师 如果是医师就抛出一个错误  医师没有对应的医师信息）
		if(rows==1) {
			patient = patientService.doFindObjectByName(username);
		}else if(rows==2) {
			//Assert.isMessage("抱歉，医师不拥有咨询医师");
		}
		Doctor findObjectById = adminDoctorService.findObjectById(patient.getParentId());
		return new JsonResult(findObjectById);
	}
	
	
	
	/*显示个人信息（右上角）*/
	@RequestMapping("account")
	public JsonResult account(String username) {
		/*根据信息查询*/
		int rows=accountService.getGrade(username);
		/*判断乘客权限等级 进行分类判断是患者还是医师*/
		UserContent patient = null; //（1表示该用户是患者 2表示 该用户是医师 如果是医师就抛出一个错误  医师没有对应的医师信息）
		if(rows==1) {
			patient = patientService.doFindObjectByName(username);
		}else if(rows==2) {
//			Doctor findObjectByName = adminDoctorService.findObjectByName(username);
//			return new JsonResult(findObjectByName);
		}
		return new JsonResult(patient);
	}
}

















