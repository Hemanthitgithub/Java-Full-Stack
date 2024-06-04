package day23;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented, count: " + count);
    }

    public synchronized void decrement() {
        count--;
        System.out.println(Thread.currentThread().getName() + " decremented, count: " + count);
    }

    public synchronized int getCount() {
        return count;
    }
}

final class SharedData {
    private final String data;

    public SharedData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

class CounterTask implements Runnable {
    private final Counter counter;

    public CounterTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
            try {
                Thread.sleep(50); // Simulate some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            counter.decrement();
        }
    }
}

class SharedDataTask implements Runnable {
    private final SharedData sharedData;

    public SharedDataTask(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " received data: " + sharedData.getData());
    }
}

public class ThreadSafe {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(new CounterTask(counter), "Thread 1");
        Thread t2 = new Thread(new CounterTask(counter), "Thread 2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final counter value: " + counter.getCount());

        SharedData sharedData = new SharedData("Shared information");
        Thread t3 = new Thread(new SharedDataTask(sharedData), "Thread 3");
        Thread t4 = new Thread(new SharedDataTask(sharedData), "Thread 4");

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}