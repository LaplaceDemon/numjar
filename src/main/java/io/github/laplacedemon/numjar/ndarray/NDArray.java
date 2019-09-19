package io.github.laplacedemon.numjar.ndarray;

public class NDArray {
	protected double[] data;
	protected int[] shape;
	
	public int[] shape() {
		return shape;
	}

	public double[] getData() {
		return data;
	}
}
