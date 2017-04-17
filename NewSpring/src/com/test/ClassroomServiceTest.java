package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.ClassroomService;

public class ClassroomServiceTest extends BaseTransactionTestCase{

	@Autowired
	private ClassroomService classroomService;
	
	@Test
	public void ClassroomServiceClassroomBarTest() {
		System.out.println(("classroomService.ClassroomBar"+ classroomService.ClassroomBar("4#101")));
	}
	
	@Test
	public void ClassroomServiceAcademicBuildingBarTest() {
		System.out.println(("classroomService.AcademicBuildingBar().size()"+ classroomService.AcademicBuildingBar().size()));
	}

}
