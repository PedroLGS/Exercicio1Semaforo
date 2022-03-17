package controller;
import java.util.concurrent.Semaphore;

public class bdthread extends Thread {
	private int i;
	private Semaphore semaforo;
	
	public bdthread(int threadId, Semaphore semaforo) {
		this.i = threadId;
		this.semaforo = semaforo;
	}
	public void run() {
		
		if (i % 3 == 1) {
			calculos();
			transacao();
			calculos();
			transacao();
		}
		if (i % 3 == 2) {
			calculos();
			transacao();
			calculos();
			transacao();
			calculos();
			transacao();	
		}	
		if (i % 3 == 0) {
			calculos();
			transacao();
			calculos();
			transacao();
			calculos();
			transacao();		
	}
}
	public void transacao() {
		int tempo = 0;
		
		if (i % 3 == 1) {
			tempo = 1000;
		}
		if (i % 3 == 2) {
			tempo = 1500;
		}
		if (i % 3 == 0) {
			tempo = 1500;
		}
		
		try {
			semaforo.acquire();
			System.out.println("A thread #" + i + " está realizando a transação");
			Thread.sleep(tempo);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}finally {
			semaforo.release();
		}
		System.out.println("A thread #" + i + " terminou a transação");
	}
	public void calculos() {
		int tempo = 0;
		if (i % 3 == 1) {
			tempo = (int) ((int) (Math.random() + 0.2) * Math.pow(10, 9));
		}
		if (i % 3 == 2) {
			tempo = (int) ((int) ((Math.random()* 1.6) + 0.5) * Math.pow(10, 9));
		}
		if (i % 3 == 0) {
			tempo = (int) ((int) ((Math.random() * 1.1) + 1) * Math.pow(10, 9));
		}
		System.out.println("A thread #" + i + " está realizando o cálculo");
		
		try {
			Thread.sleep(tempo);
		} catch (Exception e) {
			
		}
	}
}