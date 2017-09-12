package ind.lw.java.synchronization.lock;

import java.util.concurrent.locks.ReentrantLock;

public class CountWithReentrantLock {


    private long count = 0L;


    private ReentrantLock lock = new ReentrantLock();

    public void incrWithLock(){

        try{
            lock.lock();
            count++;
        }finally {
            lock.unlock();
        }

    }

    public void incrWithoutLock(){
        count++;
    }

    public long getCount(){
        return this.count;
    }
}
