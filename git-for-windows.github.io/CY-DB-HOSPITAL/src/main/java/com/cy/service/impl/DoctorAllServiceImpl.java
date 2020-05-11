package com.cy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.vo.ServiceException;
import com.cy.dao.DoctorAllDao;
import com.cy.pojo.patient;
import com.cy.util.Assert;
import com.cy.common.vo.PageObject;
import com.cy.service.DoctorAllService;
@Service
public class DoctorAllServiceImpl implements DoctorAllService{
	@Autowired
	private DoctorAllDao doctorDao;

	//呈现来访者信息页面信息
	@Override
	public PageObject<patient> findPageObjects(String name, Integer pageCurrent,Integer id) {
		Assert.isArgumentValid(id==0, "用户信息错误");
		//参数校验
		Assert.isArgumentValid(pageCurrent==null||pageCurrent<1, "当前页码值不正确");
		String doctorName=doctorDao.getRowCountId(id);
		int rows=doctorDao.getRowsName(doctorName);
		if(rows!=2&&rows!=3)Assert.isMessage("您没有权限查看");
		//查询总记录数并校验
		System.out.println(name);
		int rowCount = doctorDao.getRowCount(name,id);
		Assert.isServiceValid(rowCount==0, "没有对应的记录");
		//查询当前页角色信息记录
		Integer pageSize=4;
		Integer startIndex=(pageCurrent-1)*pageSize;
		List<patient> records = doctorDao.findPageObjects(name, startIndex, pageSize,id);
		//封装查询结果
		return new PageObject<>(rowCount, records, pageSize, pageCurrent);
	}
	//通过id删除病人信息
	@Override
	public int deleteByid(Integer id) {
		//参数校验
		Assert.isArgumentValid(id==null||id<=0, "id值无效");
		int rows = doctorDao.deleteObjectById(id);
		return rows;
	}
	//增加病人信息
	@Override
	public int insetObject(patient patient) {
		//参数校验
		Assert.isArgumentValid(patient==null, "参数不能为空！");
		int rows = doctorDao.insertObject(patient);
		return rows;
	}
	//更新病人信息
	@Override
	public int updatePatient(patient patient) {
		//参数校验
		Assert.isArgumentValid(patient==null, "更新对象不能为空!");
		Assert.isArgumentValid(patient.getName()==null, "来访者姓名不能为空!");
		Assert.isArgumentValid(patient.getGender()==null, "来访者性别不能为空!");
		Assert.isArgumentValid(patient.getAge()==null, "来访者年龄不能为空!");
		Assert.isArgumentValid(patient.getPhone()==null, "来访者电话不能为空!");
		Assert.isArgumentValid(patient.getParentId()==null, "来访者所属医生不能为空!");
		int rows = doctorDao.updateObject(patient);
		Assert.isServiceValid(rows==0, "对象可能已经不存在！");
		return rows;
	}
	//通过病人名字查找数据
	@Override
	public patient selectObjectByName(String name) {
		//参数校验
		Assert.isArgumentValid(name=="", "请输入正确的病人姓名！");
		patient result = doctorDao.selectObjectByName(name);
		//查询结果校验
		if (result==null) {
			throw new ServiceException("此记录已经不存在！");
		}
		return result;
	}
	//修改页面呈现病人数据(通过id)
	@Override
	public patient selectToUpdate(Integer id) {
		Assert.isArgumentValid(id==null, "请选择真确的id进行修改操作！");
		patient result = doctorDao.selectToUpdate(id);
		if (result==null) {
			throw new ServiceException("您要修改的结果为空!");
		}
		return result;
		
	}

}
