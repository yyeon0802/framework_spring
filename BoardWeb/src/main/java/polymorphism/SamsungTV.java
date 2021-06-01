package polymorphism;

public class SamsungTV implements TV{ // implements ~ �������̽��� ��� 

	private Speaker speaker; 
	private int price; //���� ����

	/*
	public SamsungTV(Speaker speaker, int price) { //alt+shit+s ������ �ڵ����� Speaker �������̽� ����, SonySpeaker�� �޾����� ��ü��
		System.out.println("===> SamsungTV(3) ��ü ����");
		this.speaker = speaker;
		this.price = price;
	}
	*/
	
	

	/*
	public void initMethod() {
		System.out.println("��ü �ʱ�ȭ �۾�ó��...");
	}
	
	public void destroyMethod() {
		System.out.println("��ü ���� ���� ó���� ���� ó��...");
	}
	*/
	
	public SamsungTV() { //�� Ŭ������ �⺻ ������ / IoC ���� ��ü�� ������ �Ǵ��� �˾ƺ���
		System.out.println("===> SamsungTV(1) ��ü ����");
	}
	
	
	//Setter Injection	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() ȣ��");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setPrice() ȣ��");
		this.price = price;
	}

	
	
	public SamsungTV(Speaker speaker) { // DI ��� 
		System.out.println("===> SamsungTV(2) ��ü ����");
		this.speaker = speaker;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV--���� �Ҵ�.(���� : " + price +")");
	}

	public void powerOff() {
		System.out.println("SamsungTV--���� ����.");
	}

	public void volumeUp() {
//		System.out.println("SamsungTV--�Ҹ� �ø���.");
//		speaker = new SonySpeaker();	//SonySpeaker ��ü�� �ι��̳� ������, DI�� �̿��� ������ �ʿ�!
		speaker.volumeUp();
		
	}

	public void volumeDown() {
//		System.out.println("SamsungTV--�Ҹ� ������.");
//		speaker = new SonySpeaker(); 	//SonySpeaker ��ü�� �ι��̳� ������,  DI�� �̿��� ������ �ʿ�!
		speaker.volumeDown();
	}
	
}
