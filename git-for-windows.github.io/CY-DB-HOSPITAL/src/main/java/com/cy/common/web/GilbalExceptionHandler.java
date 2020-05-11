package com.cy.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.vo.JsonResult;
//@RestControllerAdvice==@ControllerAdvice+@ResponseBody
/**全局异常处理类*/
@ControllerAdvice
public class GilbalExceptionHandler {
	
	/**
	 * @ExceptionHandler 描述的方法为异常处理方法 注解内部定义的
	 * 异常类型为此方法可以处理的异常类型
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(RuntimeException.class)
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();
		return new JsonResult(e);
	}
}
