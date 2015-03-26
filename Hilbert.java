package hilbert;

import java.util.ArrayList;
import java.util.Arrays;
import Jama.Matrix;
import Jama.util.Maths;

/**
 * Hilbert Matrix Procedures using the Matrix Package
 * 
 * @author Ashika Ganesh
 * @version 1.0
 */
public class Hilbert {
	private double[][] array;
	private Matrix matrix, l, u, b, q, r;
	private int size;

	public Hilbert(int columns) {
		size = columns;
		b = new Matrix(columns, 1, 1);
		array = new double[columns][columns];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (1.0 / (i + j + 1));
			}
		}
		matrix = new Matrix(array);
	}

	public Hilbert(double[][] array) {
		size = array.length;
		b = new Matrix(size, 1, 1);
		this.array = array;
		matrix = new Matrix(array);
	}

	public void qr_fact_househ() {
		//In each version, your program should return the matrices Q and R, and the error
	}

	public void qr_fact_givens() {
		//In each version, your program should return the matrices Q and R, and the error
	}

	public void solve_lu_b() {
	// Implement the procedures to obtain the solution to a system Ax = b, for an n × n matrix A and an n×1 vector b, using the LU and QR-factorizations.
	}

	public void solve_qr_b() {
	// Implement the procedures to obtain the solution to a system Ax = b, for an n × n matrix A and an n×1 vector b, using the LU and QR-factorizations.
	}



}