package sjq.light.numjar;

import org.junit.Test;
import sjq.light.numjar.ndarray.Array2D;

public class TestMath {
    private NumJar nj = NumJar.as();
    
    @Test
    public void testSqrt() {
        double[][] x = {{1,2,3,6},{4,5,6,9},{7,8,9,1}};
        
        Array2D array = nj.array(x);
        Array2D exp = nj.exp(array);
        System.out.println(exp);
    }
}
