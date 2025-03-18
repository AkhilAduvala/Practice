public class ThreadTester {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();

        thread1.start();

        RunnableImpl runnableImpl = new RunnableImpl();

        Thread thread2 = new Thread(runnableImpl);

        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running thread using anonymous impl of runnable");
            }
        });

        thread3.start();

        Thread thread4 = new Thread(
            () -> System.out.println("Running thread using lambda impl of Thread")
        );

        thread4.start();

        Runnable runnableLambda = () -> System.out.println("Running thread using lambda impl of runnable");

        Thread thread5 = new Thread(runnableLambda);

        thread5.start();

        Runnable deamonRunnable = () -> System.out.println("Running deamon thread");

        Thread deamonThread = new Thread(deamonRunnable);

        deamonThread.setDaemon(true);
        deamonThread.start();

//        AtomicCounter counter = new AtomicCounter();
        SyncCounter counter = new SyncCounter();
        Runnable incrementCounter = () -> {
            for(int i = 0; i < 50000; i++){
                counter.increment();
            }
        };

        Thread thread6 = new Thread(incrementCounter);
        thread6.start();

        Thread thread7 = new Thread(
            () -> {
                for (int i = 0; i < 50000; i++) {
                    counter.increment();
                }
            }
        );

        thread7.start();

        thread6.join();
        thread7.join();
        System.out.println("count : " + counter.getCount());
    }
}
