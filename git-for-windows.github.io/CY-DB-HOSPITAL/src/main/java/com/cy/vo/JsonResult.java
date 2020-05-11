package com.cy.vo;

import java.io.Serializable;

import lombok.Data;

//基于此对象,封装控制层要响应到客户端的数据
@Data
public class JsonResult implements Serializable{
	private static final long serialVersionUID = -2864444342898185243L;
	private int state = 1;//状态码，1表示ok，0表示错误
	private String message = "ok";//状态信息
	private Object data;//借此属性封装控制层从业务获得的数据
	public JsonResult() {}
	public JsonResult(String message){
		this.message=message;
	}
	//一般查询时调用，封装查询结果
	public JsonResult(Object data) {
		this.data=data;
	}
	//出现异常时调用
	public JsonResult(Throwable t){
		this.state=0;
		this.message=t.getMessage();
	}
	

	
}
