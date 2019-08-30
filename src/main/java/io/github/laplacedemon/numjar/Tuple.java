package io.github.laplacedemon.numjar;

public class Tuple<T0, T1> {
    private T0 v0;
    private T1 v1;
    
    public Tuple(T0 v0, T1 v1) {
        this.v0 = v0;
        this.v1 = v1;
    }

    public T0 get0() {
        return v0;
    }

    public T1 get1() {
        return v1;
    }

}
