package com.springbook.ioc.injection;

import java.util.List;
import java.util.Properties;
import java.util.Map;
import java.util.Set;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.ioc.injection.CollectionBean;

public class CollectionBeanClient {

	public static void main(String[] args) {
		
		// list -> set -> map -> Properties
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Properties addressList = bean.getAddressList();
		
		//Properties �϶�, .toString(); �߰� => value�� �������� �ʾұ� ������ ���� �޾� String���� ��ȯ�� �ʿ���
		String address = addressList.get("��浿").toString();
		String address2 = addressList.get("������").toString();
		
		System.out.println("��浿 �ּ� : " + address);
		System.out.println("������ �ּ� : " + address2);
		
		/*
		 * for(String address : addressList) { System.out.println(address.toString()); }
		 */
		
		factory.close();
	}
}
