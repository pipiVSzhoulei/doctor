package com.cy.service;


import com.cy.common.vo.PageObject;
import com.cy.pojo.Repo;


public interface RepoService {
	PageObject<Repo> findPageObjects(String name,Integer pageCurrent);
	int insertObject(Repo repo);//添加报告
	int updateObject(Repo repo);//修改报告
	Repo findObjectById(Integer id);
	Repo findObjectByIdd(Integer id);
}
