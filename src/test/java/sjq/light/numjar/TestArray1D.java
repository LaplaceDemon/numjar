package sjq.light.numjar;

import org.junit.Assert;
import org.junit.Test;

import io.github.laplacedemon.numjar.NumJar;
import io.github.laplacedemon.numjar.ndarray.Array1D;

public class TestArray1D {
    NumJar nj = NumJar.as();
    
    @Test
    public void testArange0() {
        Array1D arange = nj.arange(10, 20, 2);
        Assert.assertEquals(arange, new Array1D(10.0, 12.0, 14.0, 16.0, 18.0));
    }
    
    @Test
    public void testArange1() {
        Array1D arange = nj.arange(9, 20, 2);
        Assert.assertEquals(arange, new Array1D(9.0, 11.0, 13.0, 15.0, 17.0, 19.0));
    }
    
    @Test
    public void testArange2() {
        Array1D arange = nj.arange(11, 20, 2);
        Assert.assertEquals(arange, new Array1D(11.0, 13.0, 15.0, 17.0, 19.0));
    }
    
    @Test
    public void testArange3() {
        Array1D arange = nj.arange(0, 60, 10);
        Assert.assertEquals(arange, new Array1D(0.0, 10.0, 20.0, 30.0, 40.0, 50.0));
    }
    
    @Test
    public void testA3() {
        Array1D linspace = nj.linspace(10, 30, 5);
        Assert.assertEquals(linspace, new Array1D(10.0, 15.0, 20.0, 25.0, 30.0));
    }
    
}
