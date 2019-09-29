package sjq.light.numjar;

import static io.github.laplacedemon.numjar.NumJar.A;

import org.junit.Assert;
import org.junit.Test;

import io.github.laplacedemon.numjar.NumJar;
import io.github.laplacedemon.numjar.ndarray.Array2D;
import io.github.laplacedemon.numjar.ndarray.NDArray;

public class TestNDArray {
	NumJar nj = NumJar.as();
	
	@Test
	public void testIndex00() {
		NDArray ndArray = nj.arange(0,30,1).reshape(2,3,5);
		int index = ndArray.index(1,2,3);
		Assert.assertEquals(index, 28);
	}
	
	@Test
	public void testIndex01() {
		NDArray ndArray = nj.arange(0,30,1).reshape(2,3,5);
		int index = ndArray.index(1,1,1);
		Assert.assertEquals(index, 21);
	}
	
	@Test
    public void testIndex() {
        NDArray ndArray = nj.arange(0,30,1).reshape(2,3,5);
        int index = ndArray.index(1,2,3);
        Assert.assertEquals(index, 28);
    }
	
	@Test
    public void testBoardcastIndex00() {
        NDArray ndArray = nj.arange(0,30,1).reshape(2,3,5);
        int index = ndArray.boardcastIndex(1,2,3);
        Assert.assertEquals(index, 28);
    }
	
	@Test
    public void testBoardcastIndex01() {
        NDArray ndArray = nj.arange(0,10,1).reshape(2,1,5);
        int index = ndArray.boardcastIndex(1,2,3);
        System.out.println(index);
        Assert.assertEquals(index, 8);
    }
	
	@Test
    public void testBoardcastIndex02() {
	    NDArray b = nj.array(
            A(100),
            A(200),
            A(300),
            A(400)
        );
	    Assert.assertEquals(b.boardcastIndex(0,0), 0);
	    Assert.assertEquals(b.boardcastIndex(0,1), 0);
	    Assert.assertEquals(b.boardcastIndex(0,2), 0);
	    Assert.assertEquals(b.boardcastIndex(0,3), 0);
	    
	    Assert.assertEquals(b.boardcastIndex(1,0), 1);
        Assert.assertEquals(b.boardcastIndex(1,1), 1);
        Assert.assertEquals(b.boardcastIndex(1,2), 1);
        Assert.assertEquals(b.boardcastIndex(1,3), 1);
        
        Assert.assertEquals(b.boardcastIndex(2,0), 2);
        Assert.assertEquals(b.boardcastIndex(2,1), 2);
        Assert.assertEquals(b.boardcastIndex(2,2), 2);
        Assert.assertEquals(b.boardcastIndex(2,3), 2);
        
        Assert.assertEquals(b.boardcastIndex(3,0), 3);
        Assert.assertEquals(b.boardcastIndex(3,1), 3);
        Assert.assertEquals(b.boardcastIndex(3,2), 3);
        Assert.assertEquals(b.boardcastIndex(3,3), 3);
    }
	
	@Test
    public void testBoardcastIndex03() {
	    NDArray a = nj.array(A(1,2,3,4)); // 4 --> 1,4
	    Assert.assertEquals(a.boardcastIndex(0,0), 0);
	    Assert.assertEquals(a.boardcastIndex(1,0), 0);
	    Assert.assertEquals(a.boardcastIndex(2,0), 0);
	    Assert.assertEquals(a.boardcastIndex(3,0), 0);
	    
	    Assert.assertEquals(a.boardcastIndex(0,1), 1);
	    Assert.assertEquals(a.boardcastIndex(1,1), 1);
	    Assert.assertEquals(a.boardcastIndex(2,1), 1);
	    Assert.assertEquals(a.boardcastIndex(3,1), 1);
	    
	    Assert.assertEquals(a.boardcastIndex(0,2), 2);
        Assert.assertEquals(a.boardcastIndex(1,2), 2);
        Assert.assertEquals(a.boardcastIndex(2,2), 2);
        Assert.assertEquals(a.boardcastIndex(3,2), 2);
        
        Assert.assertEquals(a.boardcastIndex(0,3), 3);
        Assert.assertEquals(a.boardcastIndex(1,3), 3);
        Assert.assertEquals(a.boardcastIndex(2,3), 3);
        Assert.assertEquals(a.boardcastIndex(3,3), 3);
    }
	
	@Test
    public void testBoardcastAdd00() {
        NDArray a = nj.array(A(1,2,3,4));
        NDArray b = nj.array(
            A(100),A(200),A(300),A(400)
        );
        NDArray add = a.add(b);
        System.out.println(add);
    }
	
	@Test
    public void testBoardcastAdd01() {
        NDArray a = nj.array(
            A( 0, 0, 0),
            A(10,10,10),
            A(20,20,20),
            A(30,30,30)
        );
        
        NDArray b = nj.array(
            1,2,3
        );
        
        NDArray add = a.add(b);
        System.out.println(add);
    }
	
	@Test
    public void testBoardcastAdd02() {
	    Array2D a = nj.arange(0, 60, 10).reshape(-1, 2);
	    Array2D b = nj.array(A(100),A(200),A(300));
        
        NDArray add = a.add(b);
        System.out.println(add);
    }
	
	@Test
    public void testAdd01() {
        NDArray a = nj.array(
            1,2,3
        );
        
        NDArray b = nj.array(
            2,4,6
        );
        
        NDArray add = a.add(b);
        System.out.println(add);
    }
}
