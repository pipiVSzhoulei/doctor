package com.cy.util;

import com.cy.common.vo.ServiceException;



public class Assert {
	/**指定错误报错*/
	public static void isMessage(String message) {
				throw new IllegalArgumentException(message);
	}
	
	/**参数有效性校验*/
	public static void isArgumentValid(boolean statement,String message) {
		if(statement) {
				throw new IllegalArgumentException(message);
		}
	}
	/**参数是否为空验证 String */
	public static void isEmptyString(String content,String message) {
		if(content==null||"".equals(content))
			throw new IllegalArgumentException(message);
	}
	/**参数是否为空验证 Int */
	public static void isEmptyInt(int content,String message) {
		if(content==0||content<1)
			throw new IllegalArgumentException(message);
	}
	/**业务校验*/
	public static void isServiceValid(boolean statement,String message) {
		if(statement)
			throw new ServiceException(message);
	}
}
