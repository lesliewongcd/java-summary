package ind.lw.java.synchronization.lock;


import java.util.concurrent.locks.ReentrantLock;

public class LockTest {


    static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {


        try{

            lock.lock();

            //do something

            doTask();

        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }

    private static void doTask() {



    }


}
