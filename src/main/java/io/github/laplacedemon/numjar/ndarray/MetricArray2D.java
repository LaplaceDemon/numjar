//package io.github.laplacedemon.numjar.ndarray;
//
//import java.util.Arrays;
//
//public class MetricArray2D {
//    private double[][] data;
//    private int[] shape = new int[2];
//
//    public MetricArray2D(double[][] data) {
//        this.data = data;
//        shape[0] = data.length;
//        shape[1] = data[0].length;
//    }
//
//    public int[] shape() {
//        return shape;
//    }
//
//    public double[][] getData() {
//        return data;
//    }
//    
//    /**
//     * 获取元素值
//     * @param i
//     * @param j
//     * @return
//     */
//    public double get(int i,int j) {
//        return data[i][j];
//    }
//    
//    /**
//     * 设置元素值
//     * @param i
//     * @param j
//     * @param value
//     */
//    public void set(int i,int j,double value) {
//        data[i][j] = value;
//    }
//    
//    /**
//     * 获取转置后的元素值
//     * @param i
//     * @param j
//     * @return
//     */
//    public double getT(int i,int j) {
//        return data[j][i];
//    }
//    
//    /**
//     * 设置转置后的元素值
//     * @param i
//     * @param j
//     * @param value
//     */
//    public void setT(int i,int j,double value) {
//        data[j][i] = value;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("[");
//        sb.append("\n");
//        for (int i = 0; i < data.length; i++) {
//            double[] ds = data[i];
//            sb.append("  ");
//            sb.append(Arrays.toString(ds));
//            sb.append("\n");
//        }
//        sb.append("]");
//
//        return sb.toString();
//    }
//    
//    public static Array2D copyOf(double[][] arr) {
//        int height = arr.length;
//        int width = arr[0].length;
//        double[][] newData = new double[height][];
//        for(int i = 0; i<height; i++) {
//            double[] element = arr[i];
//            newData[i] = Arrays.copyOf(element, element.length);
//        }
//        Array2D newA = new Array2D(newData);
//        return newA;
//    }
//    
//    public Array2D copy() {
//        double[][] newData = new double[data.length][];
//        for(int i = 0;i<newData.length;i++) {
//            double[] element = data[i];
//            newData[i] = Arrays.copyOf(element, element.length);
//        }
//        Array2D newA = new Array2D(newData);
//        return newA;
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + Arrays.deepHashCode(data);
//        result = prime * result + Arrays.hashCode(shape);
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Array2D other = (Array2D) obj;
//        if (!Arrays.deepEquals(data, other.data))
//            return false;
//        if (!Arrays.equals(shape, other.shape))
//            return false;
//        return true;
//    }
//    
//}
