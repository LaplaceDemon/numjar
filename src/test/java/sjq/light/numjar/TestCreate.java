package sjq.light.numjar;

import org.junit.Test;

import io.github.laplacedemon.numjar.NumJar;
import static io.github.laplacedemon.numjar.NumJar.A;
import io.github.laplacedemon.numjar.ndarray.Array1D;
import io.github.laplacedemon.numjar.ndarray.Array2D;

public class TestCreate {
    
    NumJar nj = NumJar.as();
    
    @Test
    public void testCreate1D01() {
        double[] x = {1,2,2,4,8,32};
        Array1D array = nj.array(x);
        System.out.println(array);
    }
    
    @Test
    public void testCreate1D02() {
        Array1D array = nj.array(1,2,2,4,8,32);
        System.out.println(array);
    }
    
    @Test
    public void testCreate2D01() {
        double[][] x = {{1,2,3,6},{4,5,6,9},{7,8,9,1}};
        
        Array2D array = nj.array(x);
        System.out.println(array);
    }
    
    @Test
    public void testCreate2D02() {
        Array2D array = nj.array(A(1,2,3,6),A(4,5,6,9),A(7,8,9,1));
        System.out.println(array);
    }
    
    @Test
    public void testZeros1D() {
        Array1D array = nj.zeros(5);
        System.out.println(array);
    }
    
    @Test
    public void testZeros2D() {
        Array2D array = nj.zeros(2, 3);
        System.out.println(array);
    }
    
    @Test
    public void testOnes() {
        Array2D array = nj.ones(2, 3);
        System.out.println(array);
    }
    
    @Test
    public void testCopy() {
        Array2D array = nj.ones(10, 10);
        double[] data = array.getData();
        System.out.println(data + "," + data[0]);
        Array2D copyArray = array.copy();
        double[] data2 = copyArray.getData();
        System.out.println(data2 + "," + data2[0]);
        System.out.println(array);
        System.out.println(copyArray);
    }

}
