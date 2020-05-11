package com.cy.pojo;

import java.sql.Date;

import lombok.Data;

@Data
public class Account {

	private String username;
	private String password;
	private Integer grade;
	private Integer id;
	private Date createdTime;
}
