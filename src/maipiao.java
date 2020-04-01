/**
 * @author
 * @date 2020/2/29
 **/
public class maipiao {
//    private static int ticket = 0;

  public static void main(String[] args) {
      window w = new window();
      Seller s = new Seller();
      Thread a = new Thread(s);
      a.setName("1号售票点");
      a.start();
      Thread b = new Thread(s);
      b.setName("2号售票点");
      b.start();
      Thread c = new Thread(s);
      c.setName("3号售票点");
      c.start();
  }
}

class Seller implements Runnable {
    private int num = 200;

    public void run() {
        String name = Thread.currentThread().getName();
        for(int i=0; i<210; i++) {
            if(this.num>0) {
                System.out.println(name + " 卖票，当前卖出的票号为： " + this.num--);
            }
        }
    }

}
class window implements Runnable{
    @Override
    public void run() {
        while (true) {
//               if (ticket <= 100)
//                   System.out.println("窗口-" + Thread.currentThread().getName() + "正在打印第" + ticket++ + "张票");
//               else break;
        }
    }
}