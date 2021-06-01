package com.springbook.ioc.injection;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.Properties;

public class CollectionBean {

	// List -> Set ����
	// Set -> Map ����
	// Map -> Properties ����
	
	private Properties addressList;


	public void setAddressList(Properties addressList) {
		this.addressList = addressList;
	}
	
	public Properties getAddressList() {
		return addressList;
	}
	
	
}
