package matrix.multiplier;

public class InnerProductTask {
	private float[] vec1;
	private float[] vec2;
	private int rowIndex;
	private int colIndex;
	
	public InnerProductTask(float[] vec1, float[] vec2, int rowIndex, int colIndex) {
		this.vec1 = vec1;
		this.vec2 = vec2;
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}

	public float[] getVec1() {
		return vec1;
	}

	public float[] getVec2() {
		return vec2;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public int getColIndex() {
		return colIndex;
	}
}
