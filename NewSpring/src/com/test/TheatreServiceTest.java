package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.TheatreService;

public class TheatreServiceTest extends BaseTransactionTestCase{

	@Autowired
	private TheatreService theatreService;
	
	@Test
	public void TheatreServiceBarTest() {
		System.out.println(("theatreService.Bar().size()"+ theatreService.Bar().size()));
	}
	
	@Test
	public void TheatreServicePieTest() {
		System.out.println(("theatreService.Pie().size()"+ theatreService.Pie().size()));
	}

}
