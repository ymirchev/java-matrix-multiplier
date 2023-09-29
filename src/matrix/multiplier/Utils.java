package matrix.multiplier;

public class Utils {
	public static float calcInnerProduct(float[] vec1, float[] vec2) {
		float result = 0;
		
		for (int i = 0; i < vec1.length; i++) {
			result += vec1[i] * vec2[i];
		}
		
		return result;
	}

	public static float[] extractColumn(float[][] matrix, int colIndex) {
		float[] result = new float[matrix.length];
		
		for (int k = 0; k < matrix.length; k++) {
			result[k] = matrix[k][colIndex];
		}
		
		return result;
	}
}
