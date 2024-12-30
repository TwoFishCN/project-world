package com.project.world.lean.synch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHello {

    private final ReentrantLock lock = new ReentrantLock(true);

    private final CountDownLatch latch = new CountDownLatch(5);

    public void hello() {
        lock.lock();
        try {
            System.out.println("hello");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    private void count() {
        latch.countDown();
    }

    public static void main(String[] args) {
        ReentrantLockHello reentrantLockHello = new ReentrantLockHello();
        for (int i = 0; i < 2; i++) {
            new Thread(reentrantLockHello::hello).start();
        }
    }
}
