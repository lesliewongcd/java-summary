package ind.lw.java.concurrent.lock.ch04;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by wang.zhe8 on 2018/3/26.
 */
public class MyTask implements Runnable{

    private Lock lock;

    private CyclicBarrier cyclicBarrier;

    public MyTask(Lock lock, CyclicBarrier cyclicBarrier) {
        this.lock = lock;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName()+" wait...");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


        for (int i=0;i<5;i++){

            System.out.println(Thread.currentThread().getName()+" try time: "+(i+1));

            lock.lock();
            try{

                System.out.println("Lock Owner: "+Thread.currentThread().getName()
                +" Waiting Queue: "+((MyReentrantLock)lock).getQueuedThread());

//                TimeUnit.SECONDS.sleep(1L);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
