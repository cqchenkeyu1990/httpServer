package syn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestABCIteator {
	public static void main(String[] args) {
		showLog sho = new showLog();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=1;i<=20;i++) {
					sho.doworkA(i);
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=1;i<=20;i++) {
					sho.doworkB(i);
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=1;i<=20;i++) {
					sho.doworkC(i);
				}
			}
		}).start();
	}

}

class showLog{
	Lock lock = new ReentrantLock();
	Condition conditionA = lock.newCondition();
	Condition conditionB = lock.newCondition();
	Condition conditionC = lock.newCondition();
	int number = 1;
	public void doworkA(int loopint){
		lock.lock();
		try {
			/*if (number==1){  //错误写法,问题在于,当 number = 2进来时,
				for (int i =1;i<2;i++){
					System.out.println(*//*Thread.currentThread().getName()+*//*"A------------"+loopint);
				}
				number = 2;
				conditionB.signal();
			}else {
				conditionA.await();  //此处等待,醒来后,向下执行,而不打印...
			}*/

			if (number!=1){
				conditionA.await();
			}
			for (int i =1;i<2;i++){
				System.out.println(/*Thread.currentThread().getName()+*/"A------------"+loopint);
			}
			number = 2;
			conditionB.signal();

		}catch (Exception e){

		}finally {
			lock.unlock();
		}
	}
	public void doworkB(int loopint){
		lock.lock();
		try {
			if (number!=2){
				conditionB.await();
			}
				for (int i =1;i<2;i++){
					System.out.println(/*Thread.currentThread().getName()+*/"B------------"+loopint);
				}
				number = 3;
				conditionC.signal();
		}catch (Exception e){

		}finally {
			lock.unlock();
		}
	}
	public void doworkC(int loopint){
		lock.lock();
		try {
			if (number!=3){

				conditionC.await();
			}
				for (int i =1;i<2;i++){
					System.out.println(/*Thread.currentThread().getName()+*/"C------------"+loopint);
					System.out.println("--------------------------------");
				}
				number = 1;
				conditionA.signal();
		}catch (Exception e){

		}finally {
			lock.unlock();
		}
	}
}
