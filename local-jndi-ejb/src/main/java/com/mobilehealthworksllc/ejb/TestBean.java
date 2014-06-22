package com.mobilehealthworksllc.ejb;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 * Basic bean used to test local lookups
 * @author jordanbragg
 *
 */
@Stateless
@RolesAllowed("TestUser")
public class TestBean implements TestBeanLocal{

	public boolean invoke() {
		return true;
	}
	
}
