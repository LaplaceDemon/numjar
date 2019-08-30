package sjq.light.numjar;

import org.junit.Test;

import io.github.laplacedemon.numjar.NumJar;
import io.github.laplacedemon.numjar.ndarray.Array1D;
import io.github.laplacedemon.numjar.ndarray.Array2D;

public class TestDot {
    
//    public static void main(String[] args) {
//        NumJar nj = NumJar.as();
//        Array2D a0 = nj.array(new double[][]{{0,1,2},{3,4,5},{6,7,8}});
//        Array2D a1 = nj.array(new double[][]{{0,1,2},{3,4,5},{6,7,8}});
//        
//        System.out.println(a0);
//        System.out.println(a1);
//        
//        Array2D dot = nj.dot(a0, a1);
//        System.out.println(dot);
//    }
    
    @Test
    public void testDot01() {
        NumJar nj = NumJar.as();
        Array2D a = nj.array(new double[][]{{1 ,2},{3, 4}});
        Array2D b = nj.array(new double[][]{{11, 12},{13, 14}});
        
        Array2D dot = nj.dot(a, b);
        System.out.println(dot);
    }
    
    @Test
    public void testVDot01() {
        NumJar nj = NumJar.as();
        Array2D a = nj.array(new double[][]{{1 ,2},{3, 4}});
        Array2D b = nj.array(new double[][]{{11, 12},{13, 14}});
        
        double vdot = nj.vdot(a, b);
        System.out.println(vdot);
    }
    
    @Test
    public void testInner01() {
        NumJar nj = NumJar.as();
        Array1D a = nj.array(new double[]{1, 2, 3});
        Array1D b = nj.array(new double[]{0, 1, 0});
        
        double inner = nj.inner(a, b);
        System.out.println(inner);
    }
    
    
}
