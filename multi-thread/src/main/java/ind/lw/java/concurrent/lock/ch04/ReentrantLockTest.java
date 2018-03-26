package ind.lw.java.concurrent.lock.ch04;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by wang.zhe8 on 2018/3/26.
 */
public class Test {

    public static void main(String[] args) {

        fair();
//        unfair();

    }

    private static void unfair() {

        MyReentrantLock lock = new MyReentrantLock();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i =0;i<5 ;i++){

            Thread thread = new Thread(new MyTask(lock, cyclicBarrier)){
                @Override
                public String toString() {
                    return getName();
                }
            };
            thread.setName(""+i);
            thread.start();
        }

    }

    private static void fair() {
        MyReentrantLock lock = new MyReentrantLock(true);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        for (int i =0;i<5 ;i++){
            Thread thread = new Thread(new MyTask(lock, cyclicBarrier)){
                @Override
                public String toString() {
                    return getName();
                }
            };
            thread.setName(""+i);
            thread.start();
        }

    }

}
