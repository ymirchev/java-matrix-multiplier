package matrix.multiplier;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

class Worker implements Runnable {

	InnerProductTask task;
	private Semaphore completer; // Operations completer
	private Semaphore poolBounder;
	private ConcurrentLinkedQueue<InnerProductResult> results;

	Worker(InnerProductTask task, Semaphore completer, Semaphore poolBounder,
			ConcurrentLinkedQueue<InnerProductResult> results) {

		this.task = task;
		this.completer = completer;
		this.poolBounder = poolBounder;
		this.results = results;
	}
	
	@Override
	public void run() {
		try {
			float value = Utils.calcInnerProduct(task.getVec1(), task.getVec2());
			this.results.add(new InnerProductResult(task.getRowIndex(), task.getColIndex(), value));

			this.completer.release();
			this.poolBounder.release();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
