package com.cy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.vo.PageObject;
import com.cy.dao.DoctorAllDao;
import com.cy.dao.RepoDao;
import com.cy.util.Assert;
import com.cy.pojo.Repo;
import com.cy.pojo.patient;
@Service

public class RepoServiceImpl implements com.cy.service.RepoService {
	@Autowired
	private RepoDao repoDao;




	@Override

	public PageObject<Repo> findPageObjects(String name,Integer pageCurrent) {
		//1.合法性验证
		Assert.isArgumentValid(pageCurrent==null||pageCurrent<1, "当前页码值无效！");
		//2.查询总记录数并进行校验
		int rowCount=repoDao.getRowCount(name);
		Assert.isServiceValid(rowCount==0, "没有找到对应记录！");
		//3.查询当前页记录
		int pageSize=10;
		int startIndex=(pageCurrent-1)*pageSize;
		List<Repo> records=repoDao.findPageObjects(name, startIndex, pageSize);
		//4.对查询结果进行封装并返回
		return new PageObject<>(rowCount, records, pageSize, pageCurrent);
	}




	@Override
	public int insertObject(Repo repo) {
		//1.合法性验证
		Assert.isArgumentValid(repo==null, "添加内容不能为空！");
		//2.保存医师信息
		int rows=repoDao.insertObject(repo);
		Assert.isServiceValid(rows!=1, "修改失败，可能是目标已经不存在或修改内容超出预期");
		//3.返回结果
		return rows;
	}




	@Override
	public int updateObject(Repo repo) {
		//1.合法性验证
		Assert.isArgumentValid(repo.equals(null), "内容不能为空");
		//2.更新数据
		int rows=repoDao.updateObject(repo);
		Assert.isServiceValid(rows==0, "对象可能已经不存在！"); 
		
		//3.返回结果
		return rows;	
	}




	@Override
	public Repo findObjectById(Integer id) {
		//1.合法性验证
		Assert.isArgumentValid(id<1||id==null, "id不合法");
    	System.out.println("id值不合法！");
    	//2.执行查询
    	Repo result=repoDao.findObjectById(id);
    	//3.验证结果并返回
    	Assert.isServiceValid(result==null, "此记录已经不存在！");
    	return result;
	}



	@Autowired
	private DoctorAllDao doctorAllDao;

	@Override
	public Repo findObjectByIdd(Integer id) {
		patient selectToUpdate = doctorAllDao.selectToUpdate(id);
		String name=selectToUpdate.getName();
		
		
		//1.合法性验证
				Assert.isArgumentValid(name==""||name==null, "用户名错误");
		    	//2.执行查询
		    	Repo result=repoDao.findObjectByIdd(name);
		    	return result;
	}

}


