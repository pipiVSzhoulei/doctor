package com.cy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.common.vo.PageObject;
import com.cy.pojo.Doctor;
import com.cy.service.DoctorRootService;
import com.cy.util.Assert;
import com.cy.vo.JsonResult;

@RestController
@RequestMapping("/doctor/")
public class DoctorRootControllerBody {
	@Autowired
	private DoctorRootService adminDoctorService;
	//呈现医师页面分页信息
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String name, Integer pageCurrent) {
		PageObject<Doctor> findPageObjects = adminDoctorService.findPageObjects(name,pageCurrent);
		System.out.println(findPageObjects);
		Assert.isServiceValid(
				findPageObjects.getRecords()==null||findPageObjects.getRecords().size()==0, 
				"抱歉没有你要查询的结果");	
		return new JsonResult(findPageObjects);
	}
	//删除医师信息
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id){
		adminDoctorService.deleteObject(id);
		return new JsonResult("医师信息删除成功！");
	}
	//添加医师信息
	@RequestMapping("doInsertObject")
	public JsonResult doInsertObject(Doctor doc){
		adminDoctorService.insertObject(doc);
		return new JsonResult("医师信息添加成功！");
	}
	//修改医师信息
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(Doctor entity){
		adminDoctorService.updateObject(entity);
		return new JsonResult("医师信息修改成功！");
	}
	//搜索医师信息
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(adminDoctorService.findObjectById(id));
	}
	//修改时呈现医师信息
	@RequestMapping("doFindObjectByName")
	public JsonResult doFindObjectByName(String name) {
		return new JsonResult(adminDoctorService.findObjectByName(name));
	}
}
