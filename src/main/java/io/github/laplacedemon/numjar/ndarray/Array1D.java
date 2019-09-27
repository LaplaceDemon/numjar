package io.github.laplacedemon.numjar.ndarray;

import java.util.Arrays;

public class Array1D extends NDArray {

    public Array1D(double... arr) {
        this.data = arr;
        this.shape = new int[]{arr.length};
    }

    @Override
    public String toString() {
        return "Array1D [data=" + Arrays.toString(data) + ", shape=" + Arrays.toString(shape) + "]";
    }
    
    public static Array1D copyOf(double[] arr) {
        double[] newData = new double[arr.length];
        newData = Arrays.copyOf(arr, arr.length);
        Array1D newA = new Array1D(newData);
        return newA;
    }

    public Array1D copy() {
        double[] newData = new double[data.length];
        newData = Arrays.copyOf(this.data, this.data.length);
        Array1D newA = new Array1D(newData);
        return newA;
    }

    public Array2D reshape(int height, int width) {
        if (height < 0 && width > 0) {
            height = this.data.length / width;
            return new Array2D(this.data, height, width);
        } else if (height > 0 && width < 0) {
            width = this.data.length / height;
            return new Array2D(this.data, height, width);
        } else if (height > 0 && width > 0) {
            return new Array2D(this.data, height, width);
        } else {
            throw new RuntimeException();
        }
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + Arrays.hashCode(shape);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Array1D other = (Array1D) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		if (!Arrays.equals(shape, other.shape))
			return false;
		return true;
	}
    
}
