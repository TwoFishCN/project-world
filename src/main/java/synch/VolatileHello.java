package synch;

public class VolatileHello {
    private volatile Boolean stopped = false;

    public void start() {
        while (!stopped) {
            System.out.println("not stopped ");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStopped(Boolean stopped) {
        this.stopped = stopped;
    }

    public static void main(String[] args) {
        VolatileHello hello = new VolatileHello();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                hello.start();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                hello.setStopped(true);
            }
        });

        thread.start();
        thread2.start();

        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
