package matrix;

import matrix.multiplier.Matrix;
import matrix.multiplier.MatrixMultiplier;

public class Entry {

	public static void main(String[] args) throws Exception {
		//////////////////////////////////////////////////////////
		// General case
		float a[][] = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
		float b[][] = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };

		Matrix am = new Matrix(a);
		Matrix bm = new Matrix(b);
		Matrix result = MatrixMultiplier.multiply(am, bm);

		float ab[][] = { { 6, 6, 6 }, { 12, 12, 12 }, { 18, 18, 18 } };
		Matrix abm = new Matrix(ab);
		System.out.println("* General case");
		System.out.println("Is equal: " + Matrix.isEqual(abm, result));
		System.out.println(result);

		//////////////////////////////////////////////////////////
		// Identity matrix case
		result = MatrixMultiplier.multiply(am, Matrix.createIdentityMatrix(3));
		System.out.println("* Identity matrix case");
		System.out.println("Is equal: " + Matrix.isEqual(am, result));
		System.out.println(result);

		//////////////////////////////////////////////////////////
		// Very big matrix case
		int len = 500;
		Matrix rm = Matrix.createRandomMatrix(len);
		result = MatrixMultiplier.multiply(rm, Matrix.createIdentityMatrix(len));
		System.out.println("* Very big matrix case");
		System.out.println("Is equal: " + Matrix.isEqual(rm, result) + "\n");

		//////////////////////////////////////////////////////////
		// Zero length matrix case
		Matrix im = Matrix.createIdentityMatrix(0);
		result = MatrixMultiplier.multiply(im, im);
		System.out.println("* Zero length matrix case");
		System.out.println("Is equal: " + Matrix.isEqual(im, result));
	}
}
