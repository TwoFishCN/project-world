package com.project.world.lean.synch;

public class SynchChunkHello {

    public void chunkSay() {
        System.out.println("chunkSay Hello World.");

        synchronized (this) {
            try {
                System.out.println("chunkSay synchronized sleep 3s start.");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("chunkSay sleep 3s end.");
    }

    public synchronized void chunkShow() {
        System.out.println("chunkShow Hello World.");

        synchronized (this) {
            try {
                System.out.println("chunkShow synchronized sleep 3s start.");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("chunkShow sleep 3s end.");
    }

    public static void main(String[] args) {

        SynchChunkHello hello = new SynchChunkHello();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                hello.chunkSay();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                hello.chunkShow();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
