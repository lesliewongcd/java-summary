package ind.lw.java.synchronization.thread;

public class ThreadTest {

    private static Object locker = new Object();

    public static void main(String[] args) {
        new Thread(new BlackThread(),"thread-b1").start();
        new Thread(new BlackThread(),"thread-b2").start();
    }

    static long interval = 10*60*1000;



    static class BlackThread implements Runnable{
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();

            System.out.println(threadName+" try to get lock");

            synchronized (locker){
                System.out.println(threadName+" get lock");

                long curTime = System.currentTimeMillis();
                long startTime = curTime;
                while ((curTime-startTime)< interval){
                    curTime = System.currentTimeMillis();
                }

            }
        }
    }
}
