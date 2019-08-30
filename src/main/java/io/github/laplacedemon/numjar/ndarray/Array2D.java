package io.github.laplacedemon.numjar.ndarray;

import java.util.Arrays;

public class Array2D {
    private double[] data;
    private int[] shape;
    
    public Array2D(int height, int width, double[] data) {
        shape = new int[2];
        shape[0] = height;  // height
        shape[1] = width; // width
        this.data = data;
    }
    
    public Array2D(double[][] data) {
        shape = new int[2];
        shape[0] = data.length;    // height
        shape[1] = data[0].length; // width
        this.data = new double[shape[0]*shape[1]];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                this.data[index(i, j)] = data[i][j];
            }
        }
    }

    public int[] shape() {
        return shape;
    }

    public double[] getData() {
        return data;
    }
    
    /**
     * 获取元素值
     * @param i
     * @param j
     * @return
     */
    public double get(int i, int j) {
        return data[index(i, j)];
    }
    
    /**
     * 设置元素值
     * @param i
     * @param j
     * @param value
     */
    public void set(int i,int j,double value) {
        data[index(i, j)] = value;
    }
    
    /**
     * 获取转置后的元素值
     * @param i
     * @param j
     * @return
     */
    public double getT(int i, int j) {
        return data[index(j, i)];
    }
    
    /**
     * 设置转置后的元素值
     * @param i
     * @param j
     * @param value
     */
    public void setT(int i,int j,double value) {
        data[index(j, i)] = value;
    }
    
    public int index(final int i, final int j) {
        return shape[1] * j + i;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("[");
        sb.append("\n");
        for (int i = 0; i < shape[0]; i++) {
            for (int j = 0; j < shape[1]; i++) {
                sb.append("[");
                sb.append(data[index(i, j)]);
                sb.append(", ");
                sb.append("]");
                sb.append("\n");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static Array2D copyOf(double[][] arr) {
        int height = arr.length;
        int width = arr[0].length;
        double[][] newData = new double[height][width];
        for(int i = 0; i<height; i++) {
            double[] element = arr[i];
            newData[i] = Arrays.copyOf(element, element.length);
        }
        Array2D newA = new Array2D(newData);
        return newA;
    }
    
    public Array2D copy() {
        double[] newData = new double[this.data.length];
        newData = Arrays.copyOf(this.data, this.data.length);
        Array2D newA = new Array2D(this.shape[0], this.shape[1], newData);
        return newA;
    }

}
