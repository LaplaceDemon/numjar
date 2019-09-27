package sjq.light.numjar;

import org.junit.Assert;
import org.junit.Test;

import io.github.laplacedemon.numjar.NumJar;
import static io.github.laplacedemon.numjar.NumJar.A;
import io.github.laplacedemon.numjar.ndarray.Array1D;
import io.github.laplacedemon.numjar.ndarray.Array2D;

public class TestShape {
    
    @Test
    public void testShape00() {
        NumJar nj = NumJar.as();
        Array2D reshapeArray2D = nj.arange(0, 15 ,1).reshape(3, 5);
        double d = reshapeArray2D.get(2, 1);
        Assert.assertEquals(d, 11.0, 0);
    }
    
    @Test
    public void testShape01() {
        NumJar nj = NumJar.as();
        Array1D arange = nj.arange(0, 60, 10);
        Array2D reshape = arange.reshape(-1, 2);
        Array2D check2DArray = nj.array(A(0,10),A(20,30),A(40,50));
        Assert.assertEquals(reshape, check2DArray);
    }
    
}
