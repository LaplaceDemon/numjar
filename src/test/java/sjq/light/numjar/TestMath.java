package sjq.light.numjar;

import org.junit.Test;
import sjq.light.numjar.ndarray.Array2D;

public class TestMath {
    private NumJar nj = NumJar.as();

    @Test
    public void testExp() {
        double[][] x = {{1, 2}, {3, 4}};
        Array2D array = nj.array(x);
        Array2D exp = nj.exp(array);
        System.out.println(exp);
    }

    @Test
    public void testSqrt() {
        double[][] x = {{1, 2, 3, 6}, {4, 5, 6, 9}, {7, 8, 9, 1}};

        Array2D array = nj.array(x);
        Array2D sqrt = nj.sqrt(array);
        System.out.println(sqrt);
    }

    @Test
    public void testSin() {
        double[][] x = {{1, 2, 3, 6}, {4, 5, 6, 9}, {7, 8, 9, 1}};

        Array2D array = nj.array(x);
        Array2D sin = nj.sin(array);
        System.out.println(sin);
    }

    @Test
    public void testCos() {
        double[][] x = {{1, 2, 3, 6}, {4, 5, 6, 9}, {7, 8, 9, 1}};

        Array2D array = nj.array(x);
        Array2D cos = nj.cos(array);
        System.out.println(cos);
    }

    @Test
    public void testTan() {
        double[][] x = {{1, 2, 3, 6}, {4, 5, 6, 9}, {7, 8, 9, 1}};

        Array2D array = nj.array(x);
        Array2D tan = nj.tan(array);
        System.out.println(tan);
    }
}
