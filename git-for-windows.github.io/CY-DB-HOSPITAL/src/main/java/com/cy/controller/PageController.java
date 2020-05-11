package com.cy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.service.AccountService;
import com.cy.util.Assert;
@RequestMapping("/")
@Controller
public class PageController {
	/**登录路径*/
	@RequestMapping("doLoginUI")
	public String doLoginUI(){return "page/index";}

	@Autowired
	private AccountService accountService;

	/**访问主页路径*/
	/**登录校验*/
	@RequestMapping("starter")
	public String starter(String username,String password,Model model) {
		
	model.addAttribute("username",username);
		return "starter"; }
	/**通用返回页面方法（双路径路径） */
	@RequestMapping("{module}/{moduleUI}")
	public String doModileUI(@PathVariable String module,@PathVariable String moduleUI) {return module+"/"+moduleUI;}
	/**管理员医师查询页面跳转 */
	@RequestMapping("doctorListRoot")//跳转页面
	public String doctorModuleUI() {return "doctorRoot/doctorList";}
	/**管理员医师查询页面跳转 */
	@RequestMapping("userListRoot")//跳转页面
	public String userdoModuleUI() {return "userRoot/userList";}
	
	/*doctorAll 下的页面跳转   管理员 患者部分*/
	@RequestMapping("patientDoctorEdit")
	public String userDoctorEdit(Integer id,Model model) {model.addAttribute("idd",id);return "repoDoctor/patientEdit";}
	@RequestMapping("patientDoctorEdit2")
	public String userDoctorEdit2(Integer id,Model model) {model.addAttribute("idd",id);return "repoDoctor/patientEdit2";}

	
	/*！！doctor 下的页面跳转路径 客户功能模块*/
	@RequestMapping("list")
	public String list() {return "doctor/list";}
	@RequestMapping("edit")
	public String edit() {return "doctor/edit";}
	
	
	/*doctorRoot 下的页面跳转    管理员 医师部分*/
	@RequestMapping("doctorEdit")//跳转页面
	public String doctorEdit() {return "doctorRoot/doctorEdit";}
	@RequestMapping("doctorList")//跳转页面
	public String doctorList() {return "doctorRoot/doctorList";}
	
	/*userRoot 下的页面跳转   管理员 患者部分*/
	@RequestMapping("userEdit")
	public String patientEdit(Integer id,Model model) {model.addAttribute("idd",id);return "userRoot/userEdit";}
	@RequestMapping("userList")
	public String patientList() {return "userRoot/userList";}
	
	/*repo 下的页面跳转路径   咨询师功能部分*/
	@RequestMapping("goDoctor")
	public String goDoctor() {return "repoDoctor/doc_info";}
	@RequestMapping("goRepoList")
	public String goRepoList() {return "repoDoctor/repo_list";}
	@RequestMapping("goRepoEdit")
	public String goRepoEdit() {return "repoDoctor/repo_edit";}
	@RequestMapping("goDocsPat")
	public String goDocsPat() {return "repoDoctor/patient_list";}
	
	
	@ResponseBody
	@RequestMapping("root")
	public Integer root(String username,String url) {
		int a=accountService.root(username,url);
		return a;
	}
	
	
	
	/** 总分页内容 界面 ***********************************/
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}

	/**骚操作*/
	@RequestMapping("{module}")
	public String sao(@PathVariable String module) {
		return "sao/"+module;
	}

}
