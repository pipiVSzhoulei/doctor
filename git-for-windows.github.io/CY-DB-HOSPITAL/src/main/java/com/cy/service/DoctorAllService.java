package com.cy.service;



import com.cy.pojo.patient;
import com.cy.common.vo.PageObject;

public interface DoctorAllService {

	//呈现来访者信息页面信息
	PageObject<patient> findPageObjects(String name,Integer pageCurrent,Integer id);
	//增加病人信息
	int insetObject(patient patient);
	//更新病人信息
	int updatePatient(patient patient);

	//通过病人名字查找数据
	patient selectObjectByName(String name);
	//修改页面呈现病人数据(通过id)
	patient selectToUpdate(Integer id);
	//通过id删除病人信息
	int deleteByid(Integer id);
}
