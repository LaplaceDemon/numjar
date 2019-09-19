package sjq.light.numjar;

import org.junit.Assert;
import org.junit.Test;

import io.github.laplacedemon.numjar.NumJar;
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
	public void testIndex() {
		NDArray ndArray = nj.arange(0,30,1).reshape(2,3,5);
		int index = ndArray.index(1,1,1);
		Assert.assertEquals(index, 21);
	}
}
