package matrix.multiplier;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Consumer extends Thread {
	private int numOperations;
	private Semaphore completer;
	private ConcurrentLinkedQueue<InnerProductResult> results;
	private Matrix resultMatrix;

	Consumer(int numOperations, Semaphore completer, ConcurrentLinkedQueue<InnerProductResult> results,
			Matrix resultMatrix) {
		this.numOperations = numOperations;
		this.completer = completer;
		this.results = results;
		this.resultMatrix = resultMatrix;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < numOperations; i++) {
				completer.acquire();
				InnerProductResult result = results.poll();
				resultMatrix.getMatrix()[result.getRowIndex()][result.getColIndex()] = result.getValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
