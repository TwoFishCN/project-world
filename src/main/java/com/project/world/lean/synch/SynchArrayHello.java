package com.project.world.lean.synch;

public class SynchArrayHello {

    private Hello[] hello = new Hello[3];

    public SynchArrayHello() {
        hello[0] = new Hello("0");
        hello[1] = new Hello("1");
        hello[2] = new Hello("2");
    }

    public void show(int index) {
        if (index > hello.length) {
            System.out.println("Nothing find.");
        }

        System.out.println("in the show method. " + index);

        synchronized (hello[index]) {
            System.out.println(hello[index].name);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("show End.");
    }

    public class Hello {
        public String name;

        public Hello(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        SynchArrayHello hello = new SynchArrayHello();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                hello.show(1);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                hello.show(1);
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                hello.show(2);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
