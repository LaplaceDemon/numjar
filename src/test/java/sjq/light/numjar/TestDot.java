package sjq.light.numjar;

import org.junit.Assert;
import org.junit.Test;

import io.github.laplacedemon.numjar.NumJar;
import io.github.laplacedemon.numjar.ndarray.Array1D;
import io.github.laplacedemon.numjar.ndarray.Array2D;

import static io.github.laplacedemon.numjar.NumJar.A;


public class TestDot {
    
    @Test
    public void testDot01() {
        NumJar nj = NumJar.as();
        Array2D a = nj.array(new double[][]{
        	{1 ,  2},
        	{3,   4}
        });
        
        Array2D b = nj.array(new double[][]{
        	{11, 12},
        	{13, 14}
        });
        
        Array2D dot = nj.dot(a, b);
        
        Array2D check = nj.array(new double[][]{{37 , 40},{85 , 92}});
        Assert.assertEquals(dot, check);
    }
    
    @Test
    public void testDot02() {
        NumJar nj = NumJar.as();
        Array2D a = nj.array(
    		A(2 , 1),
    		A(4 , 3)
	    );
        
	    Array2D b = nj.array(
    		A(1 , 2),
    		A(1 , 0)
		);
        
        Array2D dot = nj.dot(a, b);
        
        Array2D check = nj.array(new double[][]{{3 , 4},{7 , 8}});
        Assert.assertEquals(dot, check);
    }
    
    @Test
    public void testVDot01() {
        NumJar nj = NumJar.as();
        Array2D a = nj.array(new double[][]{{1 ,  2},{3,   4}});
        Array2D b = nj.array(new double[][]{{11, 12},{13, 14}});
        
        double vdot = nj.vdot(a, b);
        Assert.assertEquals(vdot, 130, 0);
    }
    
    @Test
    public void testInner01() {
        NumJar nj = NumJar.as();
        Array1D a = nj.array(new double[]{1, 2, 3});
        Array1D b = nj.array(new double[]{0, 1, 0});
        
        double inner = nj.inner(a, b);
        Assert.assertEquals(inner, 2, 0);
    }
    
}
