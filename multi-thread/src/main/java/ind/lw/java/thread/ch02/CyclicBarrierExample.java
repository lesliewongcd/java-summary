package ind.lw.java.thread.ch02;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 */
public class CyclicBarrierExample {



    public static class GoTask implements Runnable{
        @Override
        public void run() {
            System.out.println("Go !!!");
        }
    }

    public static class Runner implements Runnable{


        private int id;

        private CyclicBarrier cyclicBarrier;

        public Runner(int id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {



            Random random = new Random();
            long v = random.nextInt(20000);
            trace("I am preparing "+v);
            try {
                Thread.sleep(5000L+v);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            trace("I'm ready");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void trace(String message){
            System.out.println(String.format("[%d] %s",id,message));
        }
    }


    final static int RUNNER_NUM = 3;

    public static void main(String[] args) {


        CyclicBarrier cyclicBarrier = new CyclicBarrier(RUNNER_NUM,new GoTask());


        for (int i=0;i<RUNNER_NUM;i++){
            new Thread(new Runner(i,cyclicBarrier)).start();
        }

    }



}
