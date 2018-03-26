package ind.lw.java.concurrent.lock.ch05;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wang.zhe8 on 2018/3/26.
 */
public class ProductQueue<T> {


    private T[] products;

    private int count;

    private int tail = 0;

    private int head = 0;

    private ReentrantLock lock;

    private Condition notEmpty;

    private Condition notFull;

    public ProductQueue(int capacity) {

        this.products = (T[]) new Object[capacity];

        this.lock = new ReentrantLock();

        this.notEmpty = lock.newCondition();

        this.notFull = lock.newCondition();
    }

    public int getCapacity() {
        return products.length;
    }

    public void put(T t) throws InterruptedException {

        lock.lock();

        try {

            while (count == getCapacity()) {
                System.out.println("Queue Full");
                notFull.await();
            }

            products[tail] = t;
            if (++tail == getCapacity()) {
                tail = 0;
            }

            ++count;

            notEmpty.signalAll();

        } finally {
            lock.unlock();
        }
    }


    public T take() throws InterruptedException {

        lock.lock();

        try{

            while (count == 0){
                System.out.println("Queue Empty");
                notEmpty.await();
            }

            T t = products[head];
            products[head] = null;

            if (++head == getCapacity()){
                head = 0;
            }

            --count;

            notFull.signalAll();

            return t;
        }finally {
            lock.unlock();
        }
    }
}
