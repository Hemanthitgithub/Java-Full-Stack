package day23;

public class ThreadLifeCycle{
	private static final Object lock = new Object();
	
	public static void main(String[] args) {
		Thread thread = new Thread(new RunnableTask(),"Thread");
		
		System.out.println(thread.getName() + " state:"+thread.getName());
		thread.start();
		
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(thread.getName() + " state:"+thread.getState());
	}
	static class RunnableTask implements Runnable{
		
		
		public void run() {
			System.out.println(Thread.currentThread().getName()+"state :"+Thread.currentThread().getState());
			try{
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+" state: "+Thread.currentThread().getState());
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(lock) {
				try {
					lock.wait(1000);
					System.out.println(Thread.currentThread().getName()+"state: "+Thread.currentThread().getState());
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				Thread blockerThread = new Thread(new BlockerTask(),"BlockerThread");
				blockerThread.start();
				synchronized(lock) {
					System.out.println(Thread.currentThread().getName()+"has acquired the lock");
				}
				System.out.println(Thread.currentThread().getName() + " state:"+Thread.currentThread().getState());
				}
		}
		
		static class BlockerTask implements Runnable{
			public void run() {
				synchronized(lock) {
					try {
						Thread.sleep(2000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					}
					lock.notify();
				}
			}
		}
	}
	