package sjq.light.numjar;

import sjq.light.numjar.ndarray.Array2D;

public class TestDot {
    public static void main(String[] args) {
        double[][] x0 = {{0,1,2},{3,4,5},{6,7,8}};
        double[][] x1 = {{0,1,2},{3,4,5},{6,7,8}};
        
        NumJar nj = NumJar.as();
        Array2D a0 = nj.array(x0);
        Array2D a1 = nj.array(x1);
        
        System.out.println(a0);
        System.out.println(a1);
        
        Array2D dot = nj.dot(a0, a1);
        System.out.println(dot);
    }
}
