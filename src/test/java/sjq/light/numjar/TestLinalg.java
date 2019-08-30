package sjq.light.numjar;

import org.junit.Test;

import io.github.laplacedemon.numjar.NumJar;
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
    public void testDet() {
        double[][] x = {{1,1,3,6},{4,-5,6,9},{7,8,9,212},{7,8,9,1}};
        Array2D array = nj.array(x);
        double det = nj.linalg.det(array);
        System.out.println(det);
    }
    
    @Test
    public void testDet1() {
        double[][] x = {{1,2,3},{4,5,6},{7,8,9}};
        Array2D array = nj.array(x);
        double det = nj.linalg.det(array);
        System.out.println(det);
    }
    
    @Test
    public void testLU() {
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
        double[][] x = {{4, 2, 1, 5},{8,7,2,10},{4,8,3,6},{6,8,4,9}};
        Array2D array = nj.array(x);
//        Array2D[] lu = nj.linalg.LU(array);
//        Array2D l = lu[0];
//        Array2D u = lu[1];
        
//        System.out.println("原始矩阵" + array);
//        
//        System.out.println("L = "  + l);
//        System.out.println("U = " + u);
//        
//        Array2D dot = nj.dot(l, u);
//        System.out.println(dot);
        
//        Array2D invL = nj.linalg.invL(l);
//        System.out.println("L^-1 = " + invL);
        
//        Array2D dot2 = nj.dot(invL, l);
//        System.err.println(dot2);
        
//        Array2D invU = nj.linalg.invU(u);
//        System.out.println("U^-1 = " + invU);
//        
//        Array2D dot3 = nj.dot(invU, u);
//        System.err.println(dot3);

        Array2D invArray = nj.linalg.inv(array);
        System.err.println("A^-1 = " + invArray);
        
        Array2D dot4 = nj.dot(invArray, array);
        System.err.println(dot4);
    }
    
}
