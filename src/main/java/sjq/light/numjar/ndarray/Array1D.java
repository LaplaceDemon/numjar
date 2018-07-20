package sjq.light.numjar.ndarray;

public class Array1D {
    private double[] arr;
    private int[] shape = new int[1];

    public Array1D(double[] arr) {
        this.arr = arr;
    }

    public int[] shape() {
        return shape;
    }

    public double[] getData() {
        return arr;
    }
}
