package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Threads {

    private static final Object lock = new Object();

    private static final String immutableObjectAndReference = "2345"; //immutable
    //    static int counter;

    final static AtomicInteger counter = new AtomicInteger();//mutable

    final static AtomicReference<String> atomicReference = new AtomicReference<>();//mutable

    static String nonImmutableReference = "zxcv";

//    private Bee bee = new Bee();

    public static void main(String... args) throws Exception {
        //void run()
        Thread t = new Thread(() -> printSomeOutput("thready"));
        t.setPriority(1);
        t.start();
        Thread t2 = new Thread(() -> printSomeOutput("boby"));
        t2.setPriority(10);
        t2.start();
        Thread t3 = new Thread(() -> printSomeOutput("danny"));
        t3.setPriority(1);
        t3.start();
        Thread t4 = new Thread(() -> printSomeOutput("fluffy"));
        t4.setPriority(1);
        t4.start();

//        Class<Threads> threadsClass = Threads.class;

        Thread.sleep(5_000);
        System.out.println("counter = " + counter.intValue()); //20_000
    }

    //synchronized only allows execution of a single thread at any given moment
    //1 key = lock (always an object specific to that type of synchronized block)
    private static void printSomeOutput(String name) { //class lock is used
        Thread.currentThread().setName(name);

        for (int i = 0; i < 10_000; i++) {
            // 1 read the current value,
            // 2 - update the value(++),
            // 3 - assign the result
            //lost update --> common inconsistency problem in concurrency

            // 1 read the current value,
            // 2 - assign the asdf (new value)
            nonImmutableReference = "asdf"; //

            atomicReference.set("asdf");

            var threadsClass = Threads.class;
//            synchronized (lock) {
//                ++counter;
//            }


            int counterCurrentValue = counter.incrementAndGet();

            System.out.println(Thread.currentThread().getName() + " -- " + i);
        }
    }

    //this is used as lock
    private void instanceSyncronizedMeth() {
        synchronized (lock) {

        }
    }
}
