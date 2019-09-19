package io.github.laplacedemon.numjar.ndarray;

import java.util.Arrays;

public class NDArray {
	protected double[] data;
	protected int[] shape;
	
	public int[] shape() {
		return shape;
	}

	public double[] getData() {
		return data;
	}

	public NDArray reshape(int... is) {
		NDArray ndarray = new NDArray();
		ndarray.data = this.data;
		ndarray.shape = Arrays.copyOf(is, is.length);
		return ndarray;
	}

	public int index(int... is) {
		int isLength = is.length;
		int k = 1;
		int index = 0;
		for (int n = 0; n < isLength; n++) {
			index += k * is[is.length - 1 - n];
			k *= shape[shape.length - 1 - n];
		}

		return index;
	}

//	public NDArray add(NDArray array) {
//		
//	}
}
