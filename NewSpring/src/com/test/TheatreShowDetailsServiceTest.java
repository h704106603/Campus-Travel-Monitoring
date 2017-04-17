package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.TheatreShowDetailsService;

public class TheatreShowDetailsServiceTest extends BaseTransactionTestCase{

	@Autowired
	private TheatreShowDetailsService theatreShowDetailsService;
	
	@Test
	public void TheatreShowDetailsServiceShowTheatreShowDetailsTest() {
		System.out.println(("theatreShowDetailsService.ShowTheatreShowDetails().size()"+ theatreShowDetailsService.ShowTheatreShowDetails().size()));
	}
	
	@Test
	public void TheatreShowDetailsServiceTheatreThumbsTest() {
		try {
			theatreShowDetailsService.TheatreThumbs("1");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
