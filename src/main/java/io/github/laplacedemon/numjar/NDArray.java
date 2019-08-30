package io.github.laplacedemon.numjar;

import java.util.ArrayList;
import java.util.List;

public class NDArray {
    List<Integer> shape = new ArrayList<>();
    Object data;

    NDArray() {}

    public List<Integer> shape() {
        return this.shape;
    }
    
}
