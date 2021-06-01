package polymorphism;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")//id(bean���� �ϱ����� "tv"�� ����)
public class LgTV implements TV{
	
	@Autowired 				// speaker�� apple sony �ΰ��� ��ü�� �ֱ� ������ autowired�����δ� error
//	@Qualifier("apple") 	//appleSpeaker ����
	private Speaker speaker; //autowired�� ���Ͽ� sony speaker�� ��ü�� ����
	
	public LgTV() { //IoC ���� ��ü�� ������ �Ǵ��� �˾ƺ���
		System.out.println("===> LgTV ��ü ����");
	}
	
	public void powerOn() {
		System.out.println("LgTV--���� �Ҵ�.");
	}

	public void powerOff() {
		System.out.println("LgTV--���� ����.");
	}

	public void volumeUp() {
		speaker.volumeUp();
//		System.out.println("LgTV--�Ҹ� �ø���.");
	}

	public void volumeDown() {
		speaker.volumeDown();
//		System.out.println("LgTV--�Ҹ� ������.");
	}
	
	
	
}
