package matrix.multiplier;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MatrixMultiplier {
	private static final int NUM_WORKERS = 3;
	
	public static Matrix multiply(Matrix a, Matrix b) throws Exception {
		if (!Matrix.isEqualDimensions(a, b)) {
			throw new Exception("Dimentions are not equal");
		}
		
		int len = a.getMatrix().length;
		int numOperations = len * len;
		Matrix resultMatrix = new Matrix(len);
		
		Semaphore poolBounder = new Semaphore(NUM_WORKERS * 2, true);
		Semaphore completer = new Semaphore(0, true);
		ExecutorService pool = Executors.newFixedThreadPool(NUM_WORKERS);
		ConcurrentLinkedQueue<InnerProductResult> results = new ConcurrentLinkedQueue<InnerProductResult>();

		Producer producer = new Producer(a, b, pool, completer, poolBounder, results);
		Consumer consumer = new Consumer(numOperations, completer, results, resultMatrix);
		
		producer.start();
		consumer.start();
		producer.join();
		consumer.join();

		pool.shutdown();
		
		return resultMatrix;
	}
}
