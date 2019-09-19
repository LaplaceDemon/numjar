package io.github.laplacedemon.numjar;

import java.util.function.Function;

import io.github.laplacedemon.numjar.linalg.Linalg;
import io.github.laplacedemon.numjar.ndarray.Array1D;
import io.github.laplacedemon.numjar.ndarray.Array2D;

public class NumJar {
    private NumJar() {}
    
    public static double[] A(double... arr) {
        return arr;
    }
    
    public static final NumJar INS = new NumJar();

    public static NumJar as() {
        return INS;
    }
    
    public Linalg linalg = new Linalg(this);
    
    public Array1D array(double... data) {
        Array1D arr = Array1D.copyOf(data);
        return arr;
    }

    public Array2D array(double[]... data) {
        Array2D arr = Array2D.copyOf(data);
        return arr;
    }
    
    public Array1D asarray(double... data) {
        Array1D arr = new Array1D(data);
        return arr;
    }
    
    public Array2D asarray(double[][] data) {
        Array2D arr = new Array2D(data);
        return arr;
    }
    
    public Array1D mapfunc(Array1D array1d, Function<Double, Double> f) {
        int[] shape = array1d.shape();
        int s0 = shape[0];
        double[] newData = new double[s0];

        double[] data = array1d.getData();
        for (int i = 0; i < s0; i++) {
            newData[i] = f.apply(data[i]);
        }

        Array1D newArr = new Array1D(newData);
        return newArr;
    }

    public Array2D mapfunc(Array2D array2d, Function<Double, Double> f) {
        int[] shape = array2d.shape();
        int s0 = shape[0];
        int s1 = shape[0];
        double[] data = array2d.getData();
        double[] newData = new double[data.length];
        
        for (int i = 0; i < data.length; i++) {
            newData[i] = f.apply(data[i]);
        }
        
        Array2D newArr = new Array2D(s0, s1, newData);
        return newArr;
    }

    public Array2D sin(Array2D array2d) {
        return this.mapfunc(array2d, Math::sin);
    }
    
    public Array1D sin(Array1D arr) {
        return this.mapfunc(arr, Math::sin);
    }

    public Array2D cos(Array2D array2d) {
        return this.mapfunc(array2d, Math::cos);
    }
    
    public Array1D cos(Array1D arr) {
        return this.mapfunc(arr, Math::cos);
    }

    public Array2D tan(Array2D array2d) {
        return this.mapfunc(array2d, Math::tan);
    }
    
    public Array1D tan(Array1D arr) {
        return this.mapfunc(arr, Math::tan);
    }

    public Array2D abs(Array2D array2d) {
        return this.mapfunc(array2d, Math::abs);
    }
    
    public Array1D abs(Array1D arr) {
        return this.mapfunc(arr, Math::abs);
    }

    public Array2D arcsin(Array2D array2d) {
        return this.mapfunc(array2d, Math::asin);
    }
    
    public Array1D arcsin(Array1D array1d) {
        return this.mapfunc(array1d, Math::asin);
    }

    public Array2D arccos(Array2D array2d) {
        return this.mapfunc(array2d, Math::acos);
    }
    
    public Array1D arccos(Array1D array1d) {
        return this.mapfunc(array1d, Math::acos);
    }

    public Array2D arctan(Array2D array2d) {
        return this.mapfunc(array2d, Math::atan);
    }
    
    public Array1D arctan(Array1D array1d) {
        return this.mapfunc(array1d, Math::atan);
    }
    
    public Array2D tanh(Array2D array2d) {
        return this.mapfunc(array2d, Math::tanh);
    }
    
    public Array1D tanh(Array1D array1d) {
        return this.mapfunc(array1d, Math::tanh);
    }
    
    public Array2D ln(Array2D array2d) {
        return this.mapfunc(array2d, Math::log);
    }
    
    public Array1D ln(Array1D array1d) {
        return this.mapfunc(array1d, Math::log);
    }

    public Array2D log(Array2D array2d) {
        return this.mapfunc(array2d, Math::log10);
    }
    
    public Array1D log10(Array1D array1d) {
        return this.mapfunc(array1d, Math::log10);
    }
    
    public Array2D exp(Array2D array2d) {
        return this.mapfunc(array2d, Math::exp);
    }
    
    public Array1D exp(Array1D array1d) {
        return this.mapfunc(array1d, Math::exp);
    }
    
    public Array2D sqrt(Array2D array2d) {
        return this.mapfunc(array2d, Math::sqrt);
    }
    
    public Array1D sqrt(Array1D array1d) {
        return this.mapfunc(array1d, Math::sqrt);
    }
    
    public Array1D add(Array1D x0, Array1D x1) {
        int[] shape0 = x0.shape();
        int[] shape1 = x1.shape();

        int x0w = shape0[0];
        int x1w = shape1[0];

        if (x0w != x1w) {
            throw new RuntimeException("objects are not aligned");
        }

        double[] arr0 = x0.getData();
        double[] arr1 = x1.getData();

        double[] c = new double[x0w];
        for (int i = 0; i < x0w; i++) {
            c[i] = arr0[i] + arr1[i];
        }

        Array1D arr1d = new Array1D(c);
        return arr1d;
    }
    
    public Array2D add(Array2D x0, Array2D x1) {
        int[] shape0 = x0.shape();
        int[] shape1 = x1.shape();

        int x0h = shape0[0];
        int x0w = shape0[1];
        int x1h = shape1[0];
        int x1w = shape1[1];
        
        if (x0w != x1w || x0h != x1h) {
            throw new RuntimeException("objects are not aligned");
        }

        double[] arr0 = x0.getData();
        double[] arr1 = x1.getData();

        double[] c = new double[x0w * x0h];
        for (int i = 0; i < x0w; i++) {
            for (int j = 0; j < x0h; j++) {
//                c[i][j] = arr0[i][j] + arr1[i][j];
                c[i * x0h + j] = x0.get(i, j) + x1.get(i, j);
            }
        }

        Array2D arr2d = new Array2D(x0h, x0w, c);
        return arr2d;
    }
    
    public Array1D sub(Array1D x0, Array1D x1) {
        int[] shape0 = x0.shape();
        int[] shape1 = x1.shape();

        int x0w = shape0[0];
        int x1w = shape1[0];

        if (x0w != x1w) {
            throw new RuntimeException("objects are not aligned");
        }

        double[] arr0 = x0.getData();
        double[] arr1 = x1.getData();

        double[] c = new double[x0w];
        for (int i = 0; i < x0w; i++) {
            c[i] = arr0[i] - arr1[i];
        }

        Array1D arr1d = new Array1D(c);
        return arr1d;
    }
    
    public Array2D sub(Array2D x0, Array2D x1) {
        int[] shape0 = x0.shape();
        int[] shape1 = x1.shape();

        int x0h = shape0[0];
        int x0w = shape0[1];
        int x1h = shape1[0];
        int x1w = shape1[1];
        
        if (x0w != x1w || x0h != x1h) {
            throw new RuntimeException("objects are not aligned");
        }

        double[] arr0 = x0.getData();
        double[] arr1 = x1.getData();

        double[] c = new double[x0w * x0h];
        for (int i = 0; i < x0w; i++) {
            for (int j = 0; j < x0h; j++) {
//                c[i][j] = arr0[i][j] + arr1[i][j];
                c[i * x0h + j] = x0.get(i, j) - x1.get(i, j);
            }
        }

        Array2D arr2d = new Array2D(x0h, x0w, c);
        return arr2d;
    }
    
    public Array1D mul(Array1D x0, Array1D x1) {
        int[] shape0 = x0.shape();
        int[] shape1 = x1.shape();

        int x0w = shape0[0];
        int x1w = shape1[0];

        if (x0w != x1w) {
            throw new RuntimeException("objects are not aligned");
        }

        double[] arr0 = x0.getData();
        double[] arr1 = x1.getData();

        double[] c = new double[x0w];
        for (int i = 0; i < x0w; i++) {
            c[i] = arr0[i] * arr1[i];
        }

        Array1D arr1d = new Array1D(c);
        return arr1d;
    }
    
    public Array2D mul(Array2D x0, Array2D x1) {
        int[] shape0 = x0.shape();
        int[] shape1 = x1.shape();

        int x0h = shape0[0];
        int x0w = shape0[1];
        int x1h = shape1[0];
        int x1w = shape1[1];
        
        if (x0w != x1w || x0h != x1h) {
            throw new RuntimeException("objects are not aligned");
        }

        double[] arr0 = x0.getData();
        double[] arr1 = x1.getData();

        double[] c = new double[x0w * x0h];
        for (int i = 0; i < x0w; i++) {
            for (int j = 0; j < x0h; j++) {
//                c[i][j] = arr0[i][j] + arr1[i][j];
                c[i * x0h + j] = x0.get(i, j) * x1.get(i, j);
            }
        }

        Array2D arr2d = new Array2D(x0h, x0w, c);
        return arr2d;
    }
    
    public Array1D div(Array1D x0, Array1D x1) {
        int[] shape0 = x0.shape();
        int[] shape1 = x1.shape();

        int x0w = shape0[0];
        int x1w = shape1[0];

        if (x0w != x1w) {
            throw new RuntimeException("objects are not aligned");
        }

        double[] arr0 = x0.getData();
        double[] arr1 = x1.getData();

        double[] c = new double[x0w];
        for (int i = 0; i < x0w; i++) {
            c[i] = arr0[i] / arr1[i];
        }

        Array1D arr1d = new Array1D(c);
        return arr1d;
    }
    
    public Array2D div(Array2D x0, Array2D x1) {
        int[] shape0 = x0.shape();
        int[] shape1 = x1.shape();

        int x0h = shape0[0];
        int x0w = shape0[1];
        int x1h = shape1[0];
        int x1w = shape1[1];
        
        if (x0w != x1w || x0h != x1h) {
            throw new RuntimeException("objects are not aligned");
        }

        double[] arr0 = x0.getData();
        double[] arr1 = x1.getData();

        double[] c = new double[x0w * x0h];
        for (int i = 0; i < x0w; i++) {
            for (int j = 0; j < x0h; j++) {
//                c[i][j] = arr0[i][j] + arr1[i][j];
                c[i * x0h + j] = x0.get(i, j) / x1.get(i, j);
            }
        }

        Array2D arr2d = new Array2D(x0h, x0w, c);
        return arr2d;
    }
    

    public Array1D linspace(double x0, double x1, int num) {
        double dx = (x1 - x0) / (num-1);
        double[] data = new double[num];

        for (int i = 0; i < data.length; i++) {
            data[i] = x0 + i * dx;
        }

        Array1D array1d = new Array1D(data);
        return array1d;
    }

    public Array2D dot(Array2D x0, Array2D x1) {
        int[] shape0 = x0.shape();
        int[] shape1 = x1.shape();

        int x0h = shape0[0];
        int x0w = shape0[1];
        int x1h = shape1[0];
        int x1w = shape1[1];
        
        if (x0h != x1w) {
            throw new RuntimeException("objects are not aligned");
        }

        double[] arr0 = x0.getData();
        double[] arr1 = x1.getData();

        double[] c = new double[x0h * x1w];
        for (int i = 0; i < x0h; i++) {
            for (int j = 0; j < x1h; j++) {
                for (int k = 0; k < x0w; k++) {
//                    c[i][j] += arr0[i][k] * arr1[k][j];
                    c[i * x1w + j] += arr0[i * x0h + k] * arr1[k * x1h +  j];
                }
            }
        }

        Array2D arr2d = new Array2D(x1h, x0w, c);
        return arr2d;
    }
    
    public double vdot(Array2D x0, Array2D x1) {
        int[] shape0 = x0.shape();
        int[] shape1 = x1.shape();

        int x0w = shape0[0];
        int x0h = shape0[1];
        int x1w = shape1[0];
        int x1h = shape1[1];

        if (x0w != x1w || x0h != x1h) {
            throw new RuntimeException("objects are not aligned");
        }

        double[] arr0 = x0.getData();
        double[] arr1 = x1.getData();

        double sum = 0.0;
        for (int i = 0; i < x0w; i++) {
            for (int j = 0; j < x0h; j++) {
//                sum += arr0[i][j] * arr1[i][j];
                sum += x0.get(i, j) * x1.get(i, j);
            }
        }

        return sum;
    }
    
    public double inner(Array1D x0, Array1D x1) {
        int[] shape0 = x0.shape();
        int[] shape1 = x1.shape();

        int x0w = shape0[0];
        int x1w = shape1[0];

        if (x0w != x1w) {
            throw new RuntimeException("objects are not aligned");
        }

        double[] arr0 = x0.getData();
        double[] arr1 = x1.getData();

        double sum = 0.0;
        for (int i = 0; i < x0w; i++) {
            sum += arr0[i] * arr1[i];
        }

        return sum;
    }
    
    public Array1D zeros(int dim0) {
        double[] c = new double[dim0];
        Array1D arr1d = new Array1D(c);
        return arr1d;
    }
    
    public Array2D zeros(int dim0, int dim1) {
        double[] c = new double[dim0 * dim1];
        Array2D arr2d = new Array2D(dim0, dim1, c);
        return arr2d;
    }
    
    public Array2D ones(int dim0, int dim1) {
        double[] c = new double[dim0*dim1];
        for (int i = 0; i < c.length; i++) {
            c[i] = 1.0;
        }
        Array2D arr2d = new Array2D(dim0, dim1, c);
        return arr2d;
    }
    
    public Array1D arange(double x0, double x1, double step) {
        double numLength = x1 - x0;
        int len = (int)(numLength/step);
        if(numLength % step != 0) {
            len += 1;
        }
        
        double[] array = new double[len];
        
        array[0] = x0;
        for(int i = 1; i < array.length; i++) {
            array[i] = array[i-1] + step;
        }
        
        Array1D array1d = new Array1D(array);
        return array1d;
    }

}
