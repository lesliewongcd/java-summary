package ind.lw.java.concurrent.ch01;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wang.zhe8 on 2018/3/23.
 */
public class CountDownLatchExample {


    public static abstract class Work implements Runnable{

        private String workName;

        private CountDownLatch startLatch;
        private CountDownLatch doneLatch;

        public Work(String workName, CountDownLatch startLatch, CountDownLatch doneLatch) {
            this.workName = workName;
            this.startLatch = startLatch;
            this.doneLatch = doneLatch;
        }

        @Override
        public void run() {
            try{

                trace("Wait for the start signal");
                startLatch.await();
                trace("Start");
                doWork();
                trace("Finish");
                doneLatch.countDown();
            }catch (Exception e) {
                trace("Exception");
            }
        }
        abstract protected  void doWork() ;

        void trace(String message){
            System.out.println(String.format("[%s] %s",workName,message));
        }

    }


    public static class ProcessWork extends Work{

        public ProcessWork(String workName, CountDownLatch startLatch, CountDownLatch doneLatch) {
            super(workName, startLatch, doneLatch);
        }

        @Override
        protected void doWork() {
            try {
                Thread.sleep(5*60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    final static int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {

        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(THREAD_POOL_SIZE);


        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i =0 ;i< THREAD_POOL_SIZE;i++){
            executorService.execute(new ProcessWork("Thread-"+i,startLatch,doneLatch));
        }



        try {
            System.out.println("Main thread is preparing");
            Thread.sleep(3000);
            System.out.println("Main thread finish preparing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ReentrantLockTest start ");
        startLatch.countDown();
        try {
            System.out.println("Wait for all sub-thread finishing");
            doneLatch.await();
            System.out.println("All thread has finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
