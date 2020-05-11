package com.cy.service;


import com.cy.common.vo.PageObject;
import com.cy.pojo.Doctor;

public interface DoctorRootService {
	PageObject<Doctor> findPageObjects(String name,Integer pageCurrent);//呈现分页信息
	int deleteObject(Integer id);//删除医师信息
	int insertObject(Doctor entity);//添加医师信息
	int updateObject(Doctor entity);//修改医师信息
	Doctor findObjectById(Integer id);//搜索医师信息
	Doctor findObjectByName(String name);//修改时呈现医师信息

}
