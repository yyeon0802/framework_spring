package polymorphism;

public class BeanFactory {
	//�������̽��� ��ü�� �����ؾ��ϴ� ���ŷο��� �ִ�. ������������ �̿��Ͽ� parameter�� ���� ���� ����Ǵ� ����� �˾ƺ���
	
	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		}else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}
