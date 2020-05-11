package com.cy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.vo.PageObject;
import com.cy.dao.DoctorRootDao;
import com.cy.dao.PatientRootDao;
import com.cy.pojo.PatInfo;
import com.cy.pojo.UserContent;
import com.cy.service.PatientRootService;
import com.cy.util.Assert;

@Service
public class PatientRootServiceImpl implements PatientRootService {

	@Autowired
	private PatientRootDao patientDao;

	@Override
	public UserContent doFindObjectByName(String username) {
		Assert.isArgumentValid(
				username==null||username.equals("")||username=="姓名",
				"请先登录");
		UserContent userContent=patientDao.doFindObjectByName(username);
		Assert.isServiceValid(userContent==null||userContent.equals(""), "该用户不存在");
		return userContent;
	}

	//==================================================================
	@Autowired
	private DoctorRootDao doctorRootDao;
	//呈现来访者信息页面信息
	@Override
	public PageObject<PatInfo> findPageObjects(String name, Integer pageCurrent) {
		//1.合法性验证
		Assert.isArgumentValid(pageCurrent==null||pageCurrent<1, "当前页码值无效！");
		//2.查询总记录数并进行校验
		int rowCount=patientDao.getRowCount(name);
		Assert.isServiceValid(rowCount==0, "没有找到对应记录！");
		//3.查询当前页记录
		int pageSize=10;
		int startIndex=(pageCurrent-1)*pageSize;
		List<PatInfo> records=patientDao.findPageObjects(name,startIndex, pageSize);
		for (PatInfo patInfo : records) {
			patInfo.setDoctorName(doctorRootDao.findObjectById(patInfo.getParentId()).getName());
			
		}
		Assert.isServiceValid(records==null||records.size()==0, "找不到指定人员信息");
		//4.对查询结果进行封装并返回
		return new PageObject<>(rowCount, records, pageSize, pageCurrent);
	}
	//删除来访者信息
	@Override
	public int dodeletePatients(Integer id) {
		Assert.isArgumentValid(id==null||id<=0, "请先选择一个来访者！");
		int rows=patientDao.deletePatients(id);
		Assert.isServiceValid(rows==0, "此条记录可能已经不存在！");
		return rows;
	}

	//增加来访者信息
	@Override
	public int insertPatient(PatInfo entity) {
		//1.合法性验证
		//2.保存来访者信息
		int rows=patientDao.insertPatient(entity);
		//3.返回结果
		return rows;
	}

	@Override
	public int updatePatient(PatInfo entity) {
		//1.合法性验证
		Assert.isArgumentValid(entity==null, "更新的对象不能为空！");
		Assert.isArgumentValid(entity.getName()==null,"来访者姓名不能为空！");
		Assert.isArgumentValid(entity.getGender()==null,"来访者性别不能为空！");
		Assert.isArgumentValid(entity.getAge()==null,"来访者年龄不能为空！");
		Assert.isArgumentValid(entity.getPhone()==null,"来访者电话不能为空！");
		//2.更新数据
		int rows=patientDao.updatePatient(entity);
		Assert.isServiceValid(rows==0, "对象可能已经不存在！");
		//3.返回结果
		return rows;
	}

	//查询来访者信息
	@Override
	public PatInfo findObjectById(Integer id) {
		//1.合法性验证
		Assert.isArgumentValid(id==null||id<1, "id值不合法！!!!");
		//2.执行查询
		PatInfo result=patientDao.findObjectById(id);
		//3.验证结果并返回
		Assert.isServiceValid(result==null, "此记录已经不存在！");
		return result;
	}
	//修改来访者信息后呈现来访者的信息
	@Override
	public PatInfo findObjectByName(String name) {
		//1.合法性验证
		Assert.isArgumentValid(name==null||name.equals(""), "姓名为空！");
		//2.执行查询
		PatInfo result=patientDao.findObjectByName(name);
		//3.验证结果并返回
		Assert.isServiceValid(result==null, "此记录已经不存在！");
		return result;
	}

	@Override
	public void updatePatientDoctor(Integer parentId,Integer id) {
		Assert.isArgumentValid(parentId==null||parentId==0||id==null||id==0, "id值不合法！!!!");
		PatInfo result=patientDao.findObjectById(id);
		if(result.getParentId()==parentId)
			Assert.isMessage("他已经是你的医师了，不需要修改");
		int rows=patientDao.updatePatientDoctor(parentId,id);
		Assert.isServiceValid(rows!=1, "指定失败");
	}

}











