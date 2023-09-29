package matrix.multiplier;

public class InnerProductResult {
	private int rowIndex;
	private int colIndex;
	private float value;
	
	public InnerProductResult(int rowIndex, int colIndex, float value) {
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
		this.value = value;
	}
	
	public int getColIndex() {
		return colIndex;
	}
	
	public int getRowIndex() {
		return rowIndex;
	}
	
	public float getValue() {
		return value;
	}
}
