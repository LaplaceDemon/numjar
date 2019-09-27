package io.github.laplacedemon.numjar.ndarray;

import java.util.function.Consumer;

public class ArrayUtils {
    public static int cumprod(int... xs) {
        int pai = 1;
        for (int x : xs) {
            pai *= x;
        }

        return pai;
    }
    
    public static int[] boardcastShape(int[] shape0, int[] shape1) {
        int[] longerShape;
        int[] shorterShape;
        if (shape0.length > shape1.length) {
            longerShape = shape0;
            shorterShape = shape1;
        } else {
            longerShape = shape1;
            shorterShape = shape0;
        }
        
        int[] boardcastShape = new int[longerShape.length];
        for (int n = 0; n < shorterShape.length; n++) {
            if (longerShape[longerShape.length - 1 - n] == shorterShape[shorterShape.length - 1 - n]) {
                boardcastShape[longerShape.length - 1 - n] = longerShape[longerShape.length - 1 - n];
            } else if (longerShape[longerShape.length - 1 - n] == 1) {
                boardcastShape[longerShape.length - 1 - n] = shorterShape[shorterShape.length - 1 - n];
            } else if (shorterShape[shorterShape.length - 1 - n] == 1) {
                boardcastShape[longerShape.length - 1 - n] = longerShape[longerShape.length - 1 - n];
            } else {
                throw new RuntimeException();
            }
        }
        
        for (int n = longerShape.length - shorterShape.length - 1; n >= 0;--n) {
            boardcastShape[n] = longerShape[n];
        }
        
        return boardcastShape;
    }
    
    public static void foreach(int[] shape, final Consumer<int[]> consumer) {
        int[] index = new int[shape.length];
        int point = shape.length - 1;
        int point0 = shape.length - 1;
        
        // init
        consumer.accept(index);
        while (true) {
            if (point < 0) {
                break;
            }
            index[point]++;
            if(point < point0) {
                point = point0;
            }
            
            consumer.accept(index);
            for(int j = point0; j >= 0; --j) {
                if (index[point] >= shape[point]-1) {
                    // 进位
                    index[point] = 0;
                    --point;
                } else {
                    break ;
                }
            }
        }
    }
}
