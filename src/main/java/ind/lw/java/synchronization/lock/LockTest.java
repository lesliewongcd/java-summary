package ind.lw.java.synchronization.lock;


import java.util.concurrent.CyclicBarrier;

public class LockTest {


    //开启线程数
    static int THREAD_NUM = 10;

    //每个线程计数的值
    static int NUM_PER_TASK = 10000;


    CyclicBarrier barrier = new CyclicBarrier(11);

    public static void main(String[] args) {

        CountWithReentrantLock count1 = new CountWithReentrantLock();
        for (int i=0;i<THREAD_NUM;i++){
            new Thread(new CountWithLockTask(count1,NUM_PER_TASK),"thread-1"+i).start();
        }

//        CountWithReentrantLock count2 = new CountWithReentrantLock();
//        for (int i=0;i<THREAD_NUM;i++){
//            new Thread(new CountWithoutLockTask(count2,NUM_PER_TASK),"thread-2"+i).start();
//        }
    }


    static class CountWithLockTask implements Runnable{

        private CountWithReentrantLock count ;
        private int num;
        public CountWithLockTask(CountWithReentrantLock count,int num) {
            this.count = count;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i=0;i<num;i++){
                count.incrWithLock();
            }

            System.out.println(Thread.currentThread().getName()+" completes,count: "+count.getCount());
        }
    }
    static class CountWithoutLockTask implements Runnable{

        private CountWithReentrantLock count ;
        private int num;
        public CountWithoutLockTask(CountWithReentrantLock count,int num) {
            this.count = count;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i=0;i<num;i++){
                count.incrWithoutLock();
            }
            System.out.println(Thread.currentThread().getName()+" completes,count: "+count.getCount());
        }
    }
}
