package sjq.light.numjar;

import org.junit.Test;

import io.github.laplacedemon.numjar.NumJar;
import io.github.laplacedemon.numjar.ndarray.Array1D;

public class TestArithmetic {
	NumJar nj = NumJar.as();
	
	@Test
	public void testAdd() {
		Array1D a = nj.array(1,2,3);
		Array1D b = nj.array(2,4,6);
		
		Array1D add = nj.add(a, b);
		System.out.println(add);
		
//        System.out.println(array);
	}
}
