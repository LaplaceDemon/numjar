package sjq.light.numjar;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import io.github.laplacedemon.numjar.NumJar;
import io.github.laplacedemon.numjar.ndarray.Array1D;
import io.github.laplacedemon.numjar.ndarray.Array2D;

public class TestShape {
    
    @Test
    public void testShape00() {
        NumJar nj = NumJar.as();
        Array2D reshapeArray2D = nj.arange(0,15,1).reshape(3, 5);
        double d = reshapeArray2D.get(2, 1);
        Assert.assertEquals(d, 11.0, 0);
    }
    
    @Test
    public void testShape01() {
        NumJar nj = NumJar.as();
        Array1D arange = nj.arange(0, 60, 10);
        arange.reshape(-1, 1);
    }
    
}
