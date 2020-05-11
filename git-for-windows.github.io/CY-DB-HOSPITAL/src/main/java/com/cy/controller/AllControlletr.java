package com.cy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 分页信息 路径 
 * @author 18134
 *
 */
@Controller
@RequestMapping("/All/")
public class AllControlletr {

	
	@RequestMapping("{all}")
	public String All(@PathVariable String all) {
		return "page/"+all;
	}
	
}
