package com.mobilehealthworksllc.ejb;

import javax.ejb.Local;

@Local
public interface TestBeanLocal {
	public static final String JNDI_NAME="java:global/local-jndi-app-1.0.0-SNAPSHOT/local-jndi-ejb-1.0.0-SNAPSHOT/TestBean!com.mobilehealthworksllc.ejb.TestBeanLocal";
	public boolean invoke();
}
