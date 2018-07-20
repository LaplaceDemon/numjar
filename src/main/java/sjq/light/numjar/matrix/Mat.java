package sjq.light.numjar.matrix;

public class Mat {
    private double[][] data;
    private int[] shape = new int[2];

    Mat(double[][] data) {
        this.data = data;
    }

    public int[] shape() {
        return shape;
    }

    public double[][] getData() {
        return data;
    }

}
