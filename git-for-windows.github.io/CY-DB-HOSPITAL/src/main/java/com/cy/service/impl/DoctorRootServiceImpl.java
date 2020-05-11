package com.cy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.vo.PageObject;
import com.cy.dao.DoctorRootDao;
import com.cy.pojo.Doctor;
import com.cy.service.DoctorRootService;
import com.cy.util.Assert;

@Service
public class DoctorRootServiceImpl implements DoctorRootService{
	@Autowired
	private DoctorRootDao adminDoctorDao;
	//呈现医师信息页面信息
	@Override
	public PageObject<Doctor> findPageObjects(String name,Integer pageCurrent) {
		//1.查询总记录数并进行校验
		int rowCount=adminDoctorDao.getRowCount(name);
		Assert.isServiceValid(rowCount<1, "找不到指定记录");
		//2.查询当前页记录
		int pageSize=5;
		int startIndex=(pageCurrent-1)*pageSize;
		List<Doctor> records=adminDoctorDao.findPageObjects(name,startIndex, pageSize);
		//3.对查询结果进行封装并返回
		return new PageObject<>(rowCount, records, pageSize, pageCurrent);
	}	
	//删除医师信息
	@Override
	public int deleteObject(Integer id) {
		//1.合法性验证
		Assert.isEmptyInt(id, "请先选择一个医师！");
		//2.删除医师信息
		int rows=adminDoctorDao.deleteObjectsById(id);
		Assert.isServiceValid(rows==0, "此条记录可能已经不存在！！！！");
		if(rows==0)
			System.out.println("此条记录可能已经不存在！");
		//3.返回结果
		return rows;
	}
	//添加医师信息
	@Override
	public int insertObject(Doctor doc) {
		//1.合法性验证
		Assert.isArgumentValid(doc==null, "添加内容不能为空！");
		//2.保存医师信息
		int rows=adminDoctorDao.insertObject(doc);
		//3.返回结果
		return rows;
	}
	//修改医师信息
	@Override
	public int updateObject(Doctor doc) {
		//1.合法性验证
    	if(doc==null)
        System.out.println("更新的对象不能为空！");
    	if(doc.getName()==null)
        	System.out.println("医师姓名不能为空！");
    	if(doc.getGender()==null)
    		System.out.println("医师性别不能为空！");
    	if(doc.getAge()==null)
    		System.out.println("医师年龄不能为空！");
    	if(doc.getEducation()==null)
    		System.out.println("医师学历不能为空！");
    	if(doc.getWorkTime()==null)
    		System.out.println("工龄不能为空！");
    	if(doc.getCharge()==null)
    		System.out.println("医师费用不能为空！");
    	
    	
    	//姜：业务判断 应为医师姓名为  唯一约束  所以不能重复
    	Assert.isServiceValid(
    			adminDoctorDao.getRowCount(doc.getName())>0, 
    			"抱歉 用户名重复 请重新输入");
    	
    	//2.更新数据
    	int rows=adminDoctorDao.updateObject(doc);
    	if(rows==0)
        System.out.println("对象可能已经不存在！");
    	//3.返回结果
    	return rows;
	}
	//搜索医师信息
	@Override
	public Doctor findObjectById(Integer id) {
		//1.合法性验证
    	if(id==null||id<1)
    	System.out.println("id值不合法！");
    	//2.执行查询
    	Doctor result=adminDoctorDao.findObjectById(id);
    	//3.验证结果并返回
    	if(result==null)
    	System.out.println("此记录已经不存在！");
    	return result;
	}
	//修改医师信息时呈现医师信息
	@Override
	public Doctor findObjectByName(String name) {
		//1.合法性验证
		if(name==null)
			System.out.println("姓名为空！");
		//2.执行查询
		Doctor result=adminDoctorDao.findObjectByName(name);
		//3.验证结果并返回
		if(result==null)
			System.out.println("此记录已经不存在！");
		return result;
	}

}













