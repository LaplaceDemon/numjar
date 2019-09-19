package sjq.light.numjar;

import org.junit.Assert;
import org.junit.Test;

import io.github.laplacedemon.numjar.NumJar;
import static io.github.laplacedemon.numjar.NumJar.A;
import io.github.laplacedemon.numjar.ndarray.Array2D;

public class TestLinalg {
    NumJar nj = NumJar.as();
    
    @Test
    public void testInv() {
        double[][] x = {{4, 2, 1, 5},{8,7,2,10},{4,8,3,6},{6,8,4,9}};
        Array2D array = nj.array(x);
        
        Array2D invArray = nj.linalg.inv(array);
        System.out.println("A^-1 = " + invArray);
        
        Array2D eArr = nj.dot(invArray, array);
        System.out.println(eArr);
    }
    
    @Test
    public void testLinalgDet00() {
        double[][] x = {{1,1,3,6},{4,-5,6,9},{7,8,9,212},{7,8,9,1}};
        Array2D array = nj.array(x);
        double det = nj.linalg.det(array);
        Assert.assertEquals(det, -24054.0, 0);
    }
    
    @Test
    public void testLinalgDet01() {
        double[][] x = {{1,2,3},{4,5,6},{7,8,9}};
        Array2D array = nj.array(x);
        double det = nj.linalg.det(array);
        Assert.assertEquals(det, 0.0, 0);
    }
    
    @Test
    public void testLinalgDet02() {
        double[][] x = {{1, 2},{3, 4}};
        Array2D array = nj.array(x);
        double det = nj.linalg.det(array);
        Assert.assertEquals(det, -2, 0);
    }
    
    @Test
    public void testLinalgInv00() {
        double[][] x = {{1, 2},{3, 4}};
        Array2D array = nj.array(x);
        Array2D[] lu = nj.linalg.LU(array);
        Array2D l = lu[0];
        Array2D u = lu[1];
        
        Array2D invL = nj.linalg.invL(l);
        Array2D dot0 = nj.dot(invL, l);
        System.out.println("dot0:" + dot0);
        
        Array2D invU = nj.linalg.invU(u);
        Array2D dot1 = nj.dot(invU, u);
        System.out.println("dot1:" + dot1);
        
        System.out.println(l);
        System.out.println(u);
        Array2D dot = nj.dot(l, u);
        System.out.println("dot:" + dot);
        
        Array2D inv = nj.linalg.inv(array);
        System.out.println("inv:" + inv);
        
        Array2D invinv = nj.linalg.inv(inv);
        System.out.println("invinv:" + invinv);
//        Assert.assertEquals(det, -2, 0);
    }
    
    @Test
    public void testLU0() {
        double[][] x = {{9,1,3},{4,5,6},{7,8,9}};
        Array2D array = nj.array(x);
        Array2D[] lu = nj.linalg.LU(array);
        Array2D l = lu[0];
        Array2D u = lu[1];
        
        System.out.println("原始矩阵" + array);
        
        System.out.println(l);
        System.out.println(u);
        
        Array2D dot = nj.dot(l, u);
        System.out.println(dot);
        
//        u11, u12, ··· , u1n; l21, l31, ··· , ln1; u22, u23, ··· , u2n; l32, l42, ··· , ln2; ··· .
//        u00, u01, u02, l10,l20
//        u11, u12, 
    }
    
    @Test
    public void testLU1() {
        double[][] x = {{9,1,3},{4,5,6},{7,8,9}};
        int[] shape = {3,3};
        Array2D[] lu = nj.linalg.LU(x, shape);
        Array2D l = lu[0];
        Array2D u = lu[1];
        
//        System.out.println("原始矩阵" + array);
        
        System.out.println(l);
        System.out.println(u);
        
        Array2D dot = nj.dot(l, u);
        System.out.println(dot);
        
//        u11, u12, ··· , u1n; l21, l31, ··· , ln1; u22, u23, ··· , u2n; l32, l42, ··· , ln2; ··· .
//        u00, u01, u02, l10,l20
//        u11, u12, 
    }
    
//    @Test
//    public void testLU1() {
//        double[][] x = {{4, 2, 1, 5},{8,7,2,10},{4,8,3,6},{6,8,4,9}};
//        Array2D array = nj.array(x);
////        Array2D[] lu = nj.linalg.LU(array);
////        Array2D l = lu[0];
////        Array2D u = lu[1];
//        
////        System.out.println("原始矩阵" + array);
////        
////        System.out.println("L = "  + l);
////        System.out.println("U = " + u);
////        
////        Array2D dot = nj.dot(l, u);
////        System.out.println(dot);
//        
////        Array2D invL = nj.linalg.invL(l);
////        System.out.println("L^-1 = " + invL);
//        
////        Array2D dot2 = nj.dot(invL, l);
////        System.err.println(dot2);
//        
////        Array2D invU = nj.linalg.invU(u);
////        System.out.println("U^-1 = " + invU);
////        
////        Array2D dot3 = nj.dot(invU, u);
////        System.err.println(dot3);
//
//        Array2D invArray = nj.linalg.inv(array);
//        System.err.println("A^-1 = " + invArray);
//        
//        Array2D dot4 = nj.dot(invArray, array);
//        System.err.println(dot4);
//    }
    
//    @Test
//    public void testLU2() {
//        Array2D array = nj.array(
//        		A(1, -2, -2 , -3),
//        		A(3, -9 , 0,  -9),
//        		A(-1, 2,  4,   7),
//        		A(-3, -6, 26,  2)
//		);
//        
////        double[][] array = new double[][]{
////        		{1, -2, -2 , -3},
////        		{3, -9 , 0,  -9},
////        		{-1, 2,  4,   7},
////        		{-3, -6, 26,  2}
////        };
//        
//        Array2D[] lu = nj.linalg.LU(array);
//        Array2D l = lu[0];
//        Array2D u = lu[1];
//        
//        System.out.println("原始矩阵" + array);
//        
//        System.out.println("L:" + l);
//        System.out.println("U:" + u);
//        
//        Array2D dot = nj.dot(l, u);
//        System.out.println(dot);
//        
////        u11, u12, ··· , u1n; l21, l31, ··· , ln1; u22, u23, ··· , u2n; l32, l42, ··· , ln2; ··· .
////        u00, u01, u02, l10,l20
////        u11, u12, 
//    }
    
}
