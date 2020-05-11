package com.cy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.pojo.PatInfo;
import com.cy.pojo.UserContent;

@Mapper
public interface PatientRootDao {

	@Select("select * from patient where name=#{name}")
	UserContent doFindObjectByName(String name);

	
	// ===========================================================
	List<PatInfo> findPageObjects(//基于条件分页呈现来访者信息
			@Param("name")String  name,//来访者姓名
		      @Param("startIndex")Integer startIndex,//当前页的起始位置
		      @Param("pageSize")Integer pageSize);//当前页的页面大小
	int getRowCount(@Param("name") String name);//基于条件查询总记录数
//	List<PatInfo>findPatInfo(String name);
	
	int deletePatients(Integer id);
	int insertPatient(PatInfo entity);
	
	int updatePatient(PatInfo entity);
	PatInfo findObjectById(Integer id);//搜索来访者信息
	PatInfo findObjectByName(String name);//修改来访者信息呈现信息

	@Update("update patient set parentId=#{parentId} where id=#{id}")
	int updatePatientDoctor(@Param("parentId")Integer parentId, @Param("id")Integer id);//重新指定患者信息
}
