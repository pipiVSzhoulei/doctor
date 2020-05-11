package com.cy.service;

/**
 * 登录信息用
 * @author 18134
 *
 */

public interface AccountService {

	/**根据姓名查询登录者信息*/
	public int getRowsByName(String username,String password);

	public int getGrade(String username);

	public int root(String username, String url);

	
}
