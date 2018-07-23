package sjq.light.numjar;

import org.junit.Test;
import sjq.light.numjar.ndarray.Array2D;

public class TestCreate {
    
    NumJar nj = NumJar.as();
    
    @Test
    public void testCreate() {
        double[][] x = {{1,2,3,6},{4,5,6,9},{7,8,9,1}};
        
        Array2D array = nj.array(x);
        System.out.println(array);
    }
    
    @Test
    public void testZeros() {
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
        double[][] data = array.getData();
        System.out.println(data + "," + data[0]);
        Array2D copyArray = array.copy();
        double[][] data2 = copyArray.getData();
        System.out.println(data2 + "," + data2[0]);
        System.out.println(array);
        System.out.println(copyArray);
    }

}
