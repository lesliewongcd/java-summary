package ind.lw.java.concurrent.lock.ch04;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wang.zhe8 on 2018/3/26.
 */
public class MyReentrantLock extends ReentrantLock{

    public MyReentrantLock() {
        super();
    }

    public MyReentrantLock(boolean fair) {
        super(fair);
    }

    public Collection<Thread> getQueuedThread(){
        return super.getQueuedThreads();
    }

}
