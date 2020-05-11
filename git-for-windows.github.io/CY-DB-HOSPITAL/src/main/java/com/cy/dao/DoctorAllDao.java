package com.cy.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pojo.patient;

@Mapper
public interface DoctorAllDao {

	int getRowCount(@Param("name")String name,@Param("id")Integer id);//基于条件查询总记录数

	List<patient> findPageObjects(//基于条件分页呈现来访者信息
			@Param("name")String name,//来访者姓名
			@Param("startIndex")Integer startIndex,//起始页
			@Param("pageSize")Integer pageSize,
			@Param("id")Integer id);//当前页面呈现数据的大小


	//删除病人数据操作
	int deleteObjectById(@Param("id")Integer id);
	//增加病人信息
	int insertObject(patient patient);
	//修改病人信息
	int updateObject(patient patient);
	//修改时呈现病人信息
	patient selectToUpdate(Integer id);
	//通过病人名字查找数据 
	patient selectObjectByName(String name);
	
	@Select("select name from doctor where id=#{id}")
	String getRowCountId(Integer id);
	@Select("select grade from account where username=#{doctorName}")
	int getRowsName(String doctorName);
}
