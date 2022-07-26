package kr.co.tj1;

interface MessageBean{
	void call(String name);
}

class MessageBeanKr implements MessageBean{

	@Override
	public void call(String name) {
		System.out.println("안녕하세요,"+name+"씨!");
	}
	
}

class MessageBeanEn implements MessageBean{

	@Override
	public void call(String name) {
		System.out.println("Hello"+ name + "!");
	}
	
}

public class Hi {

	public static void main(String[] args) {
		MessageBean bean = new MessageBeanKr();
		bean.call("조용운");
		bean = new MessageBeanEn();
		bean.call("YONG");
	}

}
