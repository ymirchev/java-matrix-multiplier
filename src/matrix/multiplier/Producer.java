package matrix.multiplier;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class Producer extends Thread {
	private ExecutorService pool;
	private Semaphore completer;
	private Semaphore poolBounder;
	private ConcurrentLinkedQueue<InnerProductResult> results;
	private Matrix matrix1, matrix2;

	Producer(Matrix matrix1, Matrix matrix2, ExecutorService pool, Semaphore completer, Semaphore poolBounder,
			ConcurrentLinkedQueue<InnerProductResult> results) {

		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.pool = pool;
		this.completer = completer;
		this.poolBounder = poolBounder;
		this.results = results;
	}
	
	@Override
	public void run() {
		try {
			int len = matrix1.getMatrix().length;

			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					float[] row = matrix1.getMatrix()[i];
					float[] col = Utils.extractColumn(matrix2.getMatrix(), j);  // can be optimized by caching column vector
					
					InnerProductTask task = new InnerProductTask(row, col, i, j);
					
					poolBounder.acquire();
					pool.execute(new Worker(task, completer, poolBounder, results));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
