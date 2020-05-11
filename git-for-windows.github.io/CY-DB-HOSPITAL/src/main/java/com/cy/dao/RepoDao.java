package com.cy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pojo.Repo;

@Mapper
public interface RepoDao {
	List<Repo> findPageObjects(
				@Param("name") String name,
			  @Param("startIndex")Integer startIndex,//当前页的起始位置
		      @Param("pageSize")Integer pageSize);//当前页的页面大小
	int getRowCount(String name);//基于条件查询总记录数
		
	public int insertObject(Repo repo);
	
	public int updateObject(Repo repo);
	
	Repo findObjectById(@Param("id") Integer id);
	
	Repo findObjectByIdd(String name);
}
