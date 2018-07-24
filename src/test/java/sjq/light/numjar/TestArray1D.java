package sjq.light.numjar;

import org.junit.Test;
import sjq.light.numjar.ndarray.Array1D;

public class TestArray1D {
    NumJar nj = NumJar.as();
    
    @Test
    public void testArange0() {
        Array1D arange = nj.arange(10, 20, 2);
        System.out.println(arange);
    }
    
    @Test
    public void testArange1() {
        Array1D arange = nj.arange(9, 20, 2);
        System.out.println(arange);
    }
    
    @Test
    public void testArange2() {
        Array1D arange = nj.arange(11, 20, 2);
        System.out.println(arange);
    }
    
    @Test
    public void testA3() {
        Array1D linspace = nj.linspace(10, 30, 5);
        System.out.println(linspace);
    }
    
}
