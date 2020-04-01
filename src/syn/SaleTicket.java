package syn;


import java.util.concurrent.atomic.AtomicInteger;

public class SaleTicket {
//    private static int ticket = 0;

	public static void main(String[] args) {
		Seller s = new Seller();
		Thread a = new Thread(s);
		a.setName("1����Ʊ��");
		a.start();
		Thread b = new Thread(s);
		b.setName("2����Ʊ��");
		b.start();
		Thread c = new Thread(s);
		c.setName("3����Ʊ��");
		c.start();
	}
}
//�в�������
/*class Seller implements Runnable {
	private int num = 1;
	public void run() {
		try {
			Thread.sleep(200);
		}catch (Exception e){

		}
		String name = Thread.currentThread().getName();
		while(true) {
			if(this.num<20) {
				System.out.println(name + " ��Ʊ����ǰ������Ʊ��Ϊ�� " + this.num++);
			}
			else break;
		}
	}
}*/
//û�в�������
class Seller implements Runnable {
	private AtomicInteger num = new AtomicInteger(0);
	public void run() {
		try {
			Thread.sleep(200);
		}catch (Exception e){

		}
		String name = Thread.currentThread().getName();
		while(true) {
			if(this.num.get()<20) {
				System.out.println(name + " ��Ʊ����ǰ������Ʊ��Ϊ�� " + this.num.incrementAndGet());
			}
			else break;
		}
	}
}
