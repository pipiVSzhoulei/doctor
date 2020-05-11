package com.cy.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.common.vo.PageObject;
import com.cy.pojo.Repo;
import com.cy.service.RepoService;
import com.cy.vo.JsonResult;

@RestController 
@RequestMapping("/goRepo/")
public class RepoControllerBody {
	@Autowired
	private RepoService repoService;
	//呈现报告页面分页信息
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String name,Integer pageCurrent) {
		PageObject<Repo> pageObject=
	    repoService.findPageObjects(name, pageCurrent);
		return new JsonResult(pageObject);//result.data.records
	}
	@RequestMapping("doInsertObject")
	public JsonResult doInsertObject(Repo repo){
		repoService.insertObject(repo);
		return new JsonResult("报告添加成功！");    
	}
	//修改医师信息
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(Repo repo){	
		repoService.updateObject(repo);
		return new JsonResult("报告修改成功！");
	}
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		Repo result=
	    repoService.findObjectById(id);
		return new JsonResult(result);//result.data.records
	}
	@RequestMapping("doFindObjectByIdd")
	public JsonResult doFindObjectByIdd(Integer id) {
		
		Repo result=
	    repoService.findObjectByIdd(id);
		return new JsonResult(result);//result.data.records
	}
}







