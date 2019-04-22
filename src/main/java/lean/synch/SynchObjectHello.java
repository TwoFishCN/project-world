package lean.synch;

public class SynchObjectHello {

    public synchronized void say() {
        System.out.println("say Hello World.");

        try {
            System.out.println("say synchronized sleep 3s start.");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("say sleep 3s end.");
    }

    public synchronized void show() {
        System.out.println("show Hello World.");

        try {
            System.out.println("show synchronized sleep 3s start.");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("show sleep 3s end.");
    }

    /*TODO OK synchronized 加锁是对整个对象加锁，所有 synchronized 方法都是同步的。*/
    public static void main(String[] args) {

        SynchObjectHello hello = new SynchObjectHello();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                hello.say();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                hello.show();
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
