package sjq.light.numjar;

import org.junit.Test;
import sjq.light.numjar.ndarray.Array2D;

public class TestShape {
    @Test
    public void testCreate() {
        double[][] x = {{1,2,3,4},{4,5,6,7},{7,8,9,10}};
        NumJar nj = NumJar.as();
        Array2D array = nj.array(x);
        System.out.println(array.shape());
        
//        System.out.println(m1);
    }
}
