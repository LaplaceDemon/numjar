package io.github.laplacedemon.numjar.ndarray;

import java.util.Arrays;

public class Array1D {
    private double[] data;
    private int[] shape = new int[1];

    public Array1D(double[] arr) {
        this.data = arr;
    }

    public int[] shape() {
        return shape;
    }

    public double[] getData() {
        return data;
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
        return new Array2D(height, width ,this.data);
    }
    
}
