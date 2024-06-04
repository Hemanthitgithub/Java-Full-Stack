package day23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool{
	
	

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<=5;i++) {
			Runnable task = new Task("Task "+i);
			executor.submit(task);
		}
		executor.shutdown();
	}
}

class Task implements Runnable{
	private String name;
	
	public Task(String name) {
		this.name = name;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName()+"executing"+name);
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(Thread.currentThread().getName()+"finished "+name);
		
		}
	}

