package syn;


import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
	public static void main(String[] args) {
		AtomicDemo demo = new AtomicDemo();
		for (int i=0;i<10;i++){
			new Thread(demo).start();
		}
	}
}

class AtomicDemo implements Runnable{
//	private AtomicInteger ato = new AtomicInteger();
	private int num = 100;
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		}catch (Exception e){

		}

//		System.out.println("当前值:"+ato.getAndIncrement()+"之后值:"+ato.get());
		System.out.println("当前值:"+num++);
	}
}
