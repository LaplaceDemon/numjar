package sjq.light.numjar;

import java.util.Arrays;

import org.junit.Test;

import io.github.laplacedemon.numjar.NumJar;
import io.github.laplacedemon.numjar.ndarray.Array1D;
import io.github.laplacedemon.numjar.ndarray.Array2D;

public class TestShape {
    
    @Test
    public void testShape() {
        double[][] x = {{1,2,3,4},{4,5,6,7},{7,8,9,10}};
        NumJar nj = NumJar.as();
        Array2D array = nj.array(x);
        System.out.println(Arrays.toString(array.shape()));
    }
    
    @Test
    public void testShape01() {
        NumJar nj = NumJar.as();
        Array1D arange = nj.arange(0, 60, 10);
        arange.reshape(-1, 1);
    }
}
