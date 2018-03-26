package ind.lw.java.concurrent.lock.ch05;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by wang.zhe8 on 2018/3/26.
 */
public class Producer implements Runnable{


    private ProductQueue<String> productQueue;

    public Producer(ProductQueue<String> productQueue) {
        this.productQueue = productQueue;
    }

    @Override
    public void run() {

        int count = 0;
        while (true){
            try {
                productQueue.put("product" + count++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long time = (long) (Math.random()*10);
            System.out.println("produce time: "+time);
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
