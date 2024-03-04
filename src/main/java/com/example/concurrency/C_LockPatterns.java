package com.example.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class C_LockPatterns {
    // Intrinsic and Explicit Locking

    public void synchronizedDemoOne() {
        // If the thread is blocked while executing the synchronised code, all the other thread are also blocked and restarting the JVM is the only way to release the locks
        /*
            public class Persion {
                private final Object key = new Object();
                public String init() {
                    synchronized (key) {
                        // Do some work
                    }
                }
            }
         */
    }

    public void lockDemoOne() {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            // Do some work
        } finally {
            lock.unlock();
        }
    }

    // Interruptibly
    public void lockDemoTwo() {
        Lock lock = new ReentrantLock();
        try {
            lock.lockInterruptibly();

            // Do some work
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    // Interruptibly
    public void lockDemoThree() throws InterruptedException {
        Lock lock = new ReentrantLock();

        if(lock.tryLock()) {
            try {
                // Do some work
            } finally {
                lock.unlock();
            }
        } else {
            // Some other work if lock is occupied
        }



        if(lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                // Do some work
            } finally {
                lock.unlock();
            }
        } else {
            // Some other work if lock is occupied
        }
    }


    // Interruptibly
    public void lockDemoFour() throws InterruptedException {
        // for fairness add true, now first task to come will have the lock first
        Lock lock = new ReentrantLock(true);

        if(lock.tryLock()) {
            try {
                // Do some work
            } finally {
                lock.unlock();
            }
        } else {
            // Some other work if lock is occupied
        }
    }

//    Object lock = new Object();
//    class Producer {
//        public void produce() {
//            synchronized (lock) {
//                while(isFull(buffer))
//                    lock.wait();
//
//                buffer[count++] = 1;
//                lock.notifyAll();
//            }
//        }
//    }

//    class Consumer {
//        public void consume() {
//            synchronized (lock) {
//                while(isEmpty(buffer))
//                    lock.wait();
//
//                buffer[--count] = 0;
//                lock.notifyAll();
//            }
//        }
//    }

//    Lock lock = new ReentrantLock();
//    Condition notFull = lock.newCondition();
//    Condition notEmpty = lock.newCondition();
//    class Producer {
//        public void produce() {
//            try {
//                lock.lock();
//                while(isFull(buffer))
//                    notFull.await();
//                buffer[count++] = 1;
//                notEmpty.signal();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } finally {
//                lock.unlock();
//            }
//        }
//    }
//
//    class Consumer {
//        public void consume() {
//            try {
//                lock.lock();
//                while (isEmpty(buffer))
//                    notEmpty.await();
//
//                buffer[--count] = 0;
//                notFull.signal();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } finally {
//                lock.unlock();
//            }
//        }
//    }
        /*
            Await Versions

            await()
            await(time, TIMEUNIT)
            awaitNanos(nanoTimeout)
            awaitUntil(date)
            awaitUninterruptibly()
         */
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    Map<Long, String> cache = new HashMap<>();

    public void readLockImplementation(long key) {
        try {
            readLock.lock();
            String value = cache.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public void writeLockImplementation(long key, String value) {
        try {
            writeLock.lock();
            cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    Semaphore semaphore = new Semaphore(5, true);

    public void semaphoreDemo() {
        try {
            semaphore.acquire();
            // guarded block of code
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    public void semaphoreDemoThree() {
        try {
            semaphore.acquire(2);
            // guarded block of code
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release(2);
        }
    }

    public void semaphoreDemoTwo() {
        try {
            if(semaphore.tryAcquire()) {
                // guarded block of code
            } else {

            }
        } finally {
            semaphore.release();
        }
    }

    public void semaphoreDemoFour() {
        try {
            semaphore.acquireUninterruptibly();
            // guarded block of code
        } finally {
            semaphore.release();
        }
    }
}
