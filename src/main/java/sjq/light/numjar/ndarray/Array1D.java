package sjq.light.numjar.ndarray;

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
        return Arrays.toString(data);
    }

    public Array1D copy() {
        double[] newData = new double[data.length];
        newData = Arrays.copyOf(newData, newData.length);
        Array1D newA = new Array1D(newData);
        return newA;
    }
}
