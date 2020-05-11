package com.cy.service;

import com.cy.common.vo.PageObject;
import com.cy.pojo.PatInfo;
import com.cy.pojo.UserContent;

public interface PatientRootService {

	/**根据姓名查询登录用户信息*/
	UserContent doFindObjectByName(String name);
	
	
	//=============================================
	PageObject<PatInfo> findPageObjects(String name,Integer pageCurrent);//呈现分页信息
	//	List<PatInfo> findPatInfo(String name);
	
	int dodeletePatients(Integer id);
	
	int insertPatient(PatInfo entity);
	
	int updatePatient(PatInfo entity);
	
	PatInfo findObjectById(Integer id);//搜索来访者信息
	PatInfo findObjectByName(String name);//修改时呈现来访者信息


	void updatePatientDoctor(Integer parentId,Integer id);//修改用户医师
}
