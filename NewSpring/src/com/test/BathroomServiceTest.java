package com.test;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.BathroomService;

public class BathroomServiceTest extends BaseTransactionTestCase{

	
	@Autowired
  	private BathroomService bathroomService;
	
	@Test
	public void BarTest() {
		System.out.println(("bathroomService.Bar().size()"+ bathroomService.Bar().size()));
	}

}
