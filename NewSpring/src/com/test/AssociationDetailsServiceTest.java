package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.AssociationDetailsService;

public class AssociationDetailsServiceTest extends BaseTransactionTestCase{

	@Autowired
	private AssociationDetailsService associationDetailsService;
	
	@Test
	public void AssociationDetailsServiceShowAssociationDetailsTest() {
		System.out.println(("associationDetailsService.ShowAssociationDetails().size()"+ associationDetailsService.ShowAssociationDetails().size()));
	}
	
	@Test
	public void AssociationDetailsServiceAssociationThumbsTest() {
		try {
			associationDetailsService.AssociationThumbs("1");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
