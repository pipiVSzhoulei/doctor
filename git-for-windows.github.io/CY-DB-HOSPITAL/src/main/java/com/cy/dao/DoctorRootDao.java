package com.cy.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pojo.Doctor;

@Mapper
public interface DoctorRootDao {
	List<Doctor> findPageObjects(//基于条件分页呈现医师信息
			@Param("name")String  name,//医师姓名
		      @Param("startIndex")Integer startIndex,//当前页的起始位置
		      @Param("pageSize")Integer pageSize);//当前页的页面大小
	int getRowCount(@Param("name") String name);//基于条件查询总记录数
	int deleteObjectsById(Integer id);//删除医师信息
	int insertObject(Doctor doc);//添加医师信息
	int updateObject(Doctor doc);//修改医师信息
	Doctor findObjectById(Integer id);//搜索医师信息
	Doctor findObjectByName(String name);//修改医师信息是呈现信息
}
