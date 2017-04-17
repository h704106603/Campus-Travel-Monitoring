package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.CanteenService;

public class CanteenServiceTest extends BaseTransactionTestCase{

	@Autowired
	private CanteenService canteenService;
	
	@Test
	public void CanteenServiceBarTest() {
		System.out.println(("canteenService.Bar().size()"+ canteenService.Bar().size()));
	}
	
	@Test
	public void CanteenServicePieTest() {
		System.out.println(("canteenService.Pie().size()"+ canteenService.Pie().size()));
	}

}
