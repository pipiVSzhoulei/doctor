package com.cy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.vo.JsonResult;
import com.cy.common.vo.PageObject;
import com.cy.pojo.Doctor;
import com.cy.pojo.PatInfo;
import com.cy.service.DoctorRootService;
import com.cy.service.PatientRootService;
@RequestMapping("/patient/")
@RestController
public class PatientRootControllerBody {
	
	@Autowired 
	private PatientRootService patientService;
	@Autowired
	private DoctorRootService adminDoctorService;
	
	@RequestMapping("doFindObjects")
	public JsonResult patientList(String name,Integer pageCurrent) {
		PageObject<Doctor> findPageObjects = adminDoctorService.findPageObjects(name,pageCurrent);
		
		return new JsonResult(findPageObjects);
	}
	@RequestMapping("doUpdateObject")
	public JsonResult daUpdateObject(Integer parentId,Integer id) {
		patientService.updatePatientDoctor(parentId,id);	
		return new JsonResult("指定成功");
	}
	
	
	
	
	
	
	
	
	//=============================================


//呈现来访者页面分页信息
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String name, Integer pageCurrent) {
		PageObject<PatInfo> findPageObjects = patientService.findPageObjects(name,pageCurrent);
		
		

		return new JsonResult(findPageObjects);
	}

//@RequestMapping("")
//public JsonResult findPatInfo(String name) {
//	List<PatInfo> records = patientService.findPatInfo(name);
//	return new JsonResult(records);
//}
@RequestMapping("doDeletePatients")
public JsonResult dodeletePatients(Integer id) {
	patientService.dodeletePatients(id);
	return new JsonResult("Delete Ok");
}
@RequestMapping("doInsertPatients")
public JsonResult doinsertPatients(PatInfo entity) {
	patientService.insertPatient(entity);
	return new JsonResult("Save Ok");
}
@RequestMapping("doUpdatePatients")
public JsonResult doupdatePatients(PatInfo entity) {
	patientService.updatePatient(entity);
	return new JsonResult("Update Ok");
}
//搜索来访者信息
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(patientService.findObjectById(id));
	}
	//修改时呈现来访者信息
	@RequestMapping("doFindObjectByName")
	public JsonResult doFindObjectByName(String name) {
		return new JsonResult(patientService.findObjectByName(name));
	}

}
