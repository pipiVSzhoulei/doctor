package com.cy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.common.vo.PageObject;
import com.cy.pojo.Doctor;
import com.cy.service.DoctorRootService;
import com.cy.service.impl.DoctorRootServiceImpl;

@SpringBootTest
class HospitalApplicationTests {

	@Autowired
	private DoctorRootServiceImpl adminDoctorService;
	@Test
	void contextLoads() {
		PageObject<Doctor> findPageObjects = adminDoctorService.findPageObjects(null, 1);
		
		
	}

}
