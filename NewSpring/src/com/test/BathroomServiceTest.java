package com.test;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.BathroomService;

public class BathroomServiceTest extends BaseTransactionTestCase{

	
	@Autowired
  	private BathroomService bathroomService;
	
	@Test
	public void BathroomServiceBarTest() {
		System.out.println(("bathroomService.Bar().size()"+ bathroomService.Bar().size()));
	}
	
	@Test
	public void BathroomServicePieTest() {
		System.out.println(("bathroomService.Pie().size()"+ bathroomService.Pie().size()));
	}

}
