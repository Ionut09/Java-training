package concurrency;

import lombok.SneakyThrows;

public class DeadlockSimulation {

    private final Object left = new Object();

    private final Object right = new Object();

    public static void main(String... args) {
        DeadlockSimulation object = new DeadlockSimulation();
        new Thread(object::leftRight).start();

        new Thread(object::rightLeft).start();
    }

    @SneakyThrows
    public void leftRight() {
        Thread.currentThread().setName("FIRST");
        System.out.format("Thread: %s acquires lock left%n", Thread.currentThread().getName());
        synchronized (left) {
            Thread.sleep(1000);
            System.out.format("Thread: %s waits for lock right while holds lock left%n", Thread.currentThread().getName());
//            synchronized (right) {
//                doSOmething();
//            }
        }
    }

    @SneakyThrows
    public void rightLeft() {
        Thread.currentThread().setName("SECOND");

        System.out.format("Thread: %s acquires lock right%n", Thread.currentThread().getName());
        synchronized (right) {
            Thread.sleep(1000);
            System.out.format("Thread: %s waits for lock right while holds lock right%n", Thread.currentThread().getName());

//            synchronized (left) {
//                doSOmething();
//            }
        }
    }

    private void doSOmething() {
        System.out.println("I've done my job "+Thread.currentThread().getName());
    }

}
