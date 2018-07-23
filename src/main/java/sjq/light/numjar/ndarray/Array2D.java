package sjq.light.numjar.ndarray;

import java.util.Arrays;

public class Array2D {
    private double[][] data;
    private int[] shape = new int[2];

    public Array2D(double[][] data) {
        this.data = data;
        shape[0] = data.length;
        shape[1] = data[0].length;
    }

    public int[] shape() {
        return shape;
    }

    public double[][] getData() {
        return data;
    }
    
    /**
     * 获取元素值
     * @param i
     * @param j
     * @return
     */
    public double get(int i,int j) {
        return data[i][j];
    }
    
    /**
     * 设置元素值
     * @param i
     * @param j
     * @param value
     */
    public void set(int i,int j,double value) {
        data[i][j] = value;
    }
    
    /**
     * 获取转置后的元素值
     * @param i
     * @param j
     * @return
     */
    public double getT(int i,int j) {
        return data[j][i];
    }
    
    /**
     * 设置转置后的元素值
     * @param i
     * @param j
     * @param value
     */
    public void setT(int i,int j,double value) {
        data[j][i] = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append("\n");
        for (int i = 0; i < data.length; i++) {
            double[] ds = data[i];
            sb.append("  ");
            sb.append(Arrays.toString(ds));
            sb.append("\n");
        }
        sb.append("]");

        return sb.toString();
    }
    
    public Array2D copy() {
        double[][] newData = new double[data.length][];
        for(int i = 0;i<newData.length;i++) {
            double[] element = data[i];
            newData[i] = Arrays.copyOf(element, element.length);
        }
        Array2D newA = new Array2D(newData);
        return newA;
    }

}
