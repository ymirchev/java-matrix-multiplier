package matrix.multiplier;

import java.util.Random;

public class Matrix {
	private float matrix[][];

	public Matrix(float[][] matrix) {
		this.matrix = matrix;
	}

	public Matrix(int len) {
		matrix = createEmpyMatrix(len);
	}

	private static float[][] createEmpyMatrix(int len) {
		return new float[len][len];
	}

	public float[][] getMatrix() {
		return matrix;
	}

	public static Matrix createIdentityMatrix(int len) {
		Matrix matrix = new Matrix(createEmpyMatrix(len));

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				matrix.getMatrix()[i][j] = i == j ? 1 : 0;
			}
		}

		return matrix;
	}

	public static Matrix createRandomMatrix(int len) {
		Matrix matrix = new Matrix(createEmpyMatrix(len));

		Random rd = new Random();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				matrix.getMatrix()[i][j] = rd.nextFloat() * 100000;
			}
		}

		return matrix;
	}

	public static boolean isEqualDimensions(Matrix a, Matrix b) {
		if (a.getMatrix().length != b.getMatrix().length) {
			return false;
		}

		for (int i = 0; i < a.getMatrix().length; i++) {
			if (a.getMatrix()[i].length != b.getMatrix()[i].length) {
				return false;
			}
		}

		return true;
	}

	public static boolean isEqual(Matrix a, Matrix b) {
		if (a.getMatrix().length != b.getMatrix().length) {
			return false;
		}

		for (int i = 0; i < a.getMatrix().length; i++) {
			if (a.getMatrix()[i].length != b.getMatrix()[i].length) {
				return false;
			}

			for (int j = 0; j < a.getMatrix()[i].length; j++) {
				if (a.getMatrix()[i][j] != b.getMatrix()[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				String s = matrix[i][j] + (j < matrix.length - 1 ? "," : "\n");
				sb.append(s);
			}
		}

		return sb.toString();
	}
}
