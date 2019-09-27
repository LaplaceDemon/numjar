package sjq.light.numjar;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

import io.github.laplacedemon.numjar.ndarray.ArrayUtils;

public class TestArrayUtils {
    
    @Test
    public void testBoardcastShape01() {
        int[] shape0 = {4,1};
        int[] shape1 = {3};
        int[] boardcastShape = ArrayUtils.boardcastShape(shape0, shape1);
        Assert.assertArrayEquals(boardcastShape, new int[] {4,3});
    }
    
    @Test
    public void testBoardcastShape02() {
        int[] shape0 = {4,1,2};
        int[] shape1 = {  3,2};
        int[] boardcastShape = ArrayUtils.boardcastShape(shape0, shape1);
        Assert.assertArrayEquals(boardcastShape, new int[] {4,3,2});
    }
    
    @Test
    public void testBoardcastShape03() {
        int[] shape0 = {4,1,2};
        int[] shape1 = {2};
        int[] boardcastShape = ArrayUtils.boardcastShape(shape0, shape1);
        Assert.assertArrayEquals(boardcastShape, new int[] {4,1,2});
    }
    
    @Test
    public void testForeach() {
        AtomicInteger i = new AtomicInteger();
        ArrayUtils.foreach(new int[] {3,2,2}, (int[] index)-> {
            i.incrementAndGet();
            System.out.println(i.get() + ":" + Arrays.toString(index));
        });
    }
}
