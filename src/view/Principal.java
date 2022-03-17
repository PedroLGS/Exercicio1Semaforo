package view;
import java.util.concurrent.Semaphore;

import controller.bdthread;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for (int i = 0; i < 21; i++) {
			Thread thread = new bdthread(i, semaforo);
			thread.start();
		}
	}
}