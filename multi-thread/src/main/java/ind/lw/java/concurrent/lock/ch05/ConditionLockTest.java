package ind.lw.java.concurrent.lock.ch05;

/**
 * Created by wang.zhe8 on 2018/3/26.
 */
public class ConditionLockTest {


    static int PRODUCER_NUM = 6;
    static int CUSTOMER_NUM = 5;

    public static void main(String[] args) {

        ProductQueue<String> productQueue = new ProductQueue<>(10);

        for (int i=0;i<PRODUCER_NUM;i++){
            new Thread(new Producer(productQueue)).start();
        }

        for (int i=0;i<CUSTOMER_NUM;i++){
            new Thread(new Customer(productQueue)).start();
        }
    }

}
