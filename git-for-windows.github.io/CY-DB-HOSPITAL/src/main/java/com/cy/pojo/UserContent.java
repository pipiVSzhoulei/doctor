package com.cy.pojo;

import java.sql.Date;

import lombok.Data;

@Data
public class UserContent{

	private Integer id; //患者id
	private String name; 
	private String gender;
	private Integer age;
	private Integer phone; //患者电话
	private String note;	//患者备注
	private Date firstTime; //患者首次来访时间
	private Integer parentId; //患者表外键 和 医师表id关联
	private String education;	//医师表医师学历
	private Integer workTime;	//医师医龄	
	private Integer charge;		//医师收费标准
	
}
