package com.cy.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable{
	private static final long serialVersionUID = 1684876792546164773L;
	private Integer rowCount=0;//总行数
	private List<T> records;//当前页要呈现的记录
	private Integer pageCount=0;//总页数
	private Integer pageSize=3;//页面大小（每页要呈现的记录数）
	private Integer pageCurrent=1;//当前页的页码值
	public PageObject(Integer rowCount,List<T> records,Integer pageSize,Integer pageCurrent) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.records = records;		
		this.pageCount=(rowCount-1)/pageSize+1;
	}

}
