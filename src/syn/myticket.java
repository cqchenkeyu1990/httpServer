package syn;

/**
 * @author
 * @date 2020/2/29
 **/
public class myticket {

    public static void main(String[] args) {
train t = new train();
t.total = 100;
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);

//        t1.setName("窗口一");
//        t2.setName("窗口二");
//        t3.setName("窗口三");
//        t4.setName("窗口四");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


class train implements Runnable{
    private int num = 1;
    public int total;
    @Override
    public void run() {
        while (true){
            if (total>num) {
                System.out.println( Thread.currentThread().getName()+"--" + num++);
            }
            else break;
        }
    }


}
