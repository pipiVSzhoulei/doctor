package com.cy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pojo.patient;
import com.cy.common.vo.PageObject;
import com.cy.service.DoctorAllService;
import com.cy.vo.JsonResult;

@RestController
@RequestMapping("/doctorPatient/")
public class DoctorAllController {
	@Autowired
	private DoctorAllService doctorService;
	//查询到的病人信息
	@RequestMapping("doFindByDocId")
	public JsonResult doFindPageObjects(String username,Integer pageCurrent,Integer id) {
		PageObject<patient> findPageObjects = doctorService.findPageObjects(username, pageCurrent,id);
		return new JsonResult(findPageObjects);
	}
}
