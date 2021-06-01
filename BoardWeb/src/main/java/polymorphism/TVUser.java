package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class TVUser {
	
	public static void main(String[] args) {
//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		// LgTV�� ����
//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		/* Ŭ�������� �޼ҵ尡 �ٸ����, ������ �޼ҵ���� �����ؾ��ϴ� ������ �ִ�.
		 * �������̽��� ����Ѵٸ�, ���յ��� ������, ��ü�� �����Ѵٸ� �޼ҵ�� ������� �����ϴ�.
		 * */
		
		/* �������̽��� ��ü�� �����ؾ��ϴ� ���ŷο��� �ִ�. 
		 * ������������ �̿��Ͽ� parameter�� ���� ���� ����Ǵ� ����� �˾ƺ��� */
		
		//run configurations -> arguments : lg, samsung : parameter�� ����
		
//		BeanFactory factory = new BeanFactory();
//		TV tv = (TV)factory.getBean(args[0]);
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
//				
		
		/*Spring IoC
		 * 
		 * applicationContext�� id ���� ����Ͽ� ��ü������ �����԰� ���������� �������� �ش�.
		 * 
		 * */
		
		// 1. Spring �����̳ʸ� �����Ѵ�
		/* 1-1. applicationContext�� id���� ��� Class�� �� �����Ѵٸ� �����̳� ������ �����ϴ�. 
		 	->�� id���� ���ٸ�, � bean���� Ȯ���� ������ ���� �ʱ� ������ �ĺ��� ��ƴ�.(�Ʒ��� ��� lg samsung �Ѵ� �ö��)
		 	->id���� �ߺ��̸�, error
		*/
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2.Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û(Lookup)�Ѵ� 
		
//		TV tv = (TV)factory.getBean("samsungTv"); // -> applicationContext�� bean id="samsungTv"
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
//		TV tv = (TV)factory.getBean("lgTv"); // -> applicationContext�� bean id="lgTv"
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();

		/*
		 * scope="singleton" => ��ü�� 3�� �����ص�, singleton���� ��ü�� �ѹ��� �����Ͽ� ����
		 * scope="prototype" => ��ü 3�� �����ϸ� �Ѱ��� ���� ����		
		*/ 
		
		TV tv = (TV)factory.getBean("tv"); 
//		TV tv2 = (TV)factory.getBean("tv"); 
//		TV tv3 = (TV)factory.getBean("tv"); 
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. Spring �����̳� ����
		factory.close();
		
		
	}
}
