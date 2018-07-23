package sjq.light.numjar;

import java.util.function.Function;

import sjq.light.numjar.linalg.Linalg;
import sjq.light.numjar.ndarray.Array1D;
import sjq.light.numjar.ndarray.Array2D;

public class NumJar {
    private NumJar() {}
    
    public static final NumJar INS = new NumJar();

    public static NumJar as() {
        return INS;
    }
    
    public Linalg linalg = new Linalg(this);

    public Array2D array(double[][] data) {
        Array2D arr = new Array2D(data);
        return arr;
    }

    public Array2D mapfunc(Array2D array2d, Function<Double, Double> f) {
        int[] shape = array2d.shape();
        int s0 = shape[0];
        int s1 = shape[0];
        double[][] newData = new double[s0][s1];

        double[][] data = array2d.getData();
        for (int i = 0; i < s0; i++) {
            for (int j = 0; j < s1; j++) {
                newData[i][j] = f.apply(data[i][j]);
            }
        }

        Array2D newArr = new Array2D(newData);
        return newArr;
    }

    public Array2D sin(Array2D array2d) {
        return this.mapfunc(array2d, Math::sin);
    }

    public Array2D cos(Array2D array2d) {
        return this.mapfunc(array2d, Math::cos);
    }

    public Array2D tan(Array2D array2d) {
        return this.mapfunc(array2d, Math::tan);
    }

    public Array2D abs(Array2D array2d) {
        return this.mapfunc(array2d, Math::abs);
    }

    public Array2D arcsin(Array2D array2d) {
        return this.mapfunc(array2d, Math::asin);
    }

    public Array2D arccos(Array2D array2d) {
        return this.mapfunc(array2d, Math::acos);
    }

    public Array2D arctan(Array2D array2d) {
        return this.mapfunc(array2d, Math::atan);
    }

    public Array2D ln(Array2D array2d) {
        return this.mapfunc(array2d, Math::log);
    }

    public Array2D log(Array2D array2d) {
        return this.mapfunc(array2d, Math::log10);
    }
    
    public Array2D exp(Array2D array2d) {
        return this.mapfunc(array2d, Math::exp);
    }
    
    public Array2D sqrt(Array2D array2d) {
        return this.mapfunc(array2d, Math::sqrt);
    }

    public Array1D linspace(double x0, double x1, int step) {
        double dx = (x1 - x0) / step;
        double[] data = new double[step];

        for (int i = 0; i < data.length; i++) {
            data[i] = x0 + i * dx;
        }

        Array1D array1d = new Array1D(data);
        return array1d;
    }

    public Array2D dot(Array2D x0, Array2D x1) {
        int[] shape0 = x0.shape();
        int[] shape1 = x1.shape();

        int x0w = shape0[0];
        int x0h = shape0[1];
        int x1w = shape1[0];
        int x1h = shape1[1];

        if (x0h != x1w) {
            throw new RuntimeException("objects are not aligned");
        }

        double[][] arr0 = x0.getData();
        double[][] arr1 = x1.getData();

        double[][] c = new double[x0w][x1h];
        for (int i = 0; i < x0h; i++) {
            for (int j = 0; j < x1h; j++) {
                for (int k = 0; k < x0w; k++) {
                    c[i][j] += arr0[i][k] * arr1[k][j];
                }
            }
        }

        Array2D arr2d = new Array2D(c);
        return arr2d;
    }
    
    public Array2D zeros(int dim0,int dim1) {
        double[][] c = new double[dim0][dim1];
        Array2D arr2d = new Array2D(c);
        return arr2d;
    }
    
    public Array2D ones(int dim0,int dim1) {
        double[][] c = new double[dim0][dim1];
        Array2D arr2d = new Array2D(c);
        double[][] data2d = arr2d.getData();
        for(int i = 0;i<data2d.length;i++) {
            double[] data1d = data2d[i];
            for(int j = 0;j<data1d.length;j++) {
                data1d[j] = 1;
            }
        }
        
        return arr2d;
    }
    
    public Array1D arange(double x0,double x1,double step) {
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
