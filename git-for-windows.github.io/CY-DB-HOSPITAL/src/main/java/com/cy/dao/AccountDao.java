package com.cy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pojo.Account;

@Mapper
public interface AccountDao {

	/*根据姓名查询用户表内信息 返回用户等级*/
	int getRowsByName(@Param("username")String username);

	Account getVerification(String username);

	@Select("select grade from account where username=#{username}")
	int getGrade(String username);

}
