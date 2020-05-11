package com.cy.pojo;

import java.io.Serializable;

import lombok.Data;
//医师身份信息
@Data
public class Doctor implements Serializable{
	private static final long serialVersionUID = -5238294656197262524L;
	private Integer id;//序号
	private String name;//姓名
	private String gender;//性别
	private Integer age;//年龄
	private String education;//学历
	private Integer workTime;//工作时长
	private Integer charge;//费用	
}
