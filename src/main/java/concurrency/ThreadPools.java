package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ThreadPools {

    public static void main(String... args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        threadPool.submit(() -> printSomeOutput("thready"));
        threadPool.submit(() -> printSomeOutput("boby"));
        threadPool.shutdown();

        threadPool = Executors.newFixedThreadPool(4);
        threadPool.submit(() -> printSomeOutput("danny"));
        threadPool.submit(() -> printSomeOutput("fluffy"));

        Future<String> submit = threadPool.submit(() -> writeToDb());
        String s = submit.get();
        if (s != null) {
            threadPool.submit(() -> readFromDb());
        }
        threadPool.shutdown();

        ScheduledExecutorService schedulingPool = Executors.newScheduledThreadPool(8);
        schedulingPool.schedule(() -> System.out.println("Runned"), 1, SECONDS);

        schedulingPool.scheduleWithFixedDelay(() -> System.out.println("Runned with fixed delay at 1 sec"), 1, 1, SECONDS);
        schedulingPool.scheduleAtFixedRate(() -> System.out.println("Runned with fixed rate at 1 sec"), 1, 1, SECONDS);
        Thread.sleep(5000);
        schedulingPool.shutdown();
    }

    private static void readFromDb() {

    }

    @SneakyThrows
    private static String writeToDb() {
        Thread.sleep(100); //wriet data to DB
        return "object inserted in DB";
    }

    private static void printSomeOutput(String name) {
//      Thread.currentThread().setName(name);
        for (int i = 0; i < 10_000; i++) {
            System.out.println(Thread.currentThread().getName() + " -- " + i);
        }
    }

}
