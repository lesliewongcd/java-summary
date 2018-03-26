package ind.lw.java.concurrent.lock.ch05;

import java.util.concurrent.TimeUnit;

/**
 * Created by wang.zhe8 on 2018/3/26.
 */
public class Customer implements Runnable{

    private ProductQueue<String> productQueue;

    public Customer(ProductQueue<String> productQueue) {
        this.productQueue = productQueue;
    }

    @Override
    public void run() {


        while (true){
            try {
                productQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long time = (long) (Math.random()*10);
            System.out.println("custom time: "+time);

            try {
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
