package test.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		es.submit(new Runnable() {

			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("T1: " + Thread.currentThread().getName());
				}
			}

		});

		es.submit(new Runnable() {

			public void run() {

				Thread.currentThread().interrupt();
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
					}
					System.out.println("T2: " + Thread.currentThread().getName());
				}
			}

		});

	}

}
