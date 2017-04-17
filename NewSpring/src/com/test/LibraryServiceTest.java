package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.LibraryService;

public class LibraryServiceTest extends BaseTransactionTestCase{

	@Autowired
	private LibraryService libraryService;
	
	@Test
	public void LibraryServiceBarTest() {
		System.out.println(("libraryService.Bar().size()"+ libraryService.Bar().size()));
	}
	
	@Test
	public void LibraryServicePieTest() {
		System.out.println(("libraryService.Pie().size()"+ libraryService.Pie().size()));
	}

}
