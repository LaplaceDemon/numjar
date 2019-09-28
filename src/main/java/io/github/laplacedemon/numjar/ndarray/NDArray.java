package io.github.laplacedemon.numjar.ndarray;

import java.util.Arrays;

public class NDArray {
	protected double[] data;
	protected int[] shape;
	
	public NDArray() {
        super();
    }

    public NDArray(double[] data, int[] shape) {
        super();
        this.data = data;
        this.shape = shape;
    }

    public int[] shape() {
		return shape;
	}

	public double[] getData() {
		return data;
	}
	
	public int size() {
        return this.data.length;
    }

	public NDArray reshape(int... is) {
		NDArray ndarray = new NDArray();
		ndarray.data = this.data;
		ndarray.shape = Arrays.copyOf(is, is.length);
		return ndarray;
	}

	public int index(int... is) {
		int isLength = is.length;
		int k = 1;
		int index = 0;
		for (int n = 0; n < isLength; n++) {
			index += k * is[is.length - 1 - n];
			k *= shape[shape.length - 1 - n];
		}

		return index;
	}
	
	public int index(int[] is, int begin) {
	    int isLength = is.length;
        int k = 1;
        int index = 0;
        for (int n = 0; n < isLength - begin ; n++) {
            index += k * is[is.length - 1 - n];
            k *= shape[shape.length - 1 - n];
        }

        return index;
    }
	
	public int boardcastIndex(int... dims) {
//	    int[] tmpIndex = new int[this.shape.length];
//	    for (int n = this.shape.length - 1; n >= 0; --n) {
//	        if (shape[this.shape.length - n - 1] == 1) {
//	            tmpIndex[tmpIndex.length - n - 1] = 0;
//	        } else {
//	            tmpIndex[tmpIndex.length - n - 1] = dims[dims.length - n - 1];
//	        }
//	    }
//	    
//	    return index(tmpIndex);
	    
//	    int[] tmpIndex = new int[this.shape.length];
	    
        for (int n = this.shape.length - 1; n >= 0; --n) {
            if (shape[this.shape.length - n - 1] == 1) {
                dims[dims.length - n - 1] = 0;
            }
        }
        
        return index(dims, dims.length - this.shape.length);
    }
	
	public NDArray add(NDArray other) {
	    return this.calc(other, (double x0, double x1) -> {
	        return x0 + x1;
	    });
	}
	
	public NDArray sub(NDArray other) {
        return this.calc(other, (double x0, double x1) -> {
            return x0 - x1;
        });
    }
	
	public NDArray mul(NDArray other) {
        return this.calc(other, (double x0, double x1) -> {
            return x0 * x1;
        });
    }
	
	public NDArray div(NDArray other) {
        return this.calc(other, (double x0, double x1) -> {
            return x0 / x1;
        });
    }
	
	public NDArray add(double x) {
        return this.calc(x, (double x0, double x1) -> {
            return x0 + x1;
        });
    }
    
	public NDArray sub(double x) {
        return this.calc(x, (double x0, double x1) -> {
            return x0 - x1;
        });
    }
	
	public NDArray mul(double x) {
        return this.calc(x, (double x0, double x1) -> {
            return x0 * x1;
        });
    }
	
	public NDArray div(double x) {
        return this.calc(x, (double x0, double x1) -> {
            return x0 / x1;
        });
    }
	
	public NDArray calc(double x, BiDoubleFunction biFunc) {
        // fast calc
        NDArray ndarry;
        double[] data = new double[this.data.length];
        int[] shape = Arrays.copyOf(this.shape, this.shape.length);
        if (this.shape.length == 1) {
            ndarry = new Array1D(data);
        } else if (this.shape.length == 2) {
            ndarry = new Array2D(data, shape);
        } else {
            ndarry = new NDArray();
            ndarry.data = data;
            ndarry.shape = Arrays.copyOf(this.shape, this.shape.length);
        }
        
        for (int i = 0; i < this.data.length; i++) {
            ndarry.data[i] = biFunc.apply(this.data[i] , x);
        }
        
        return ndarry;
    }
	
	public NDArray calc(NDArray other, BiDoubleFunction biFunc) {
	    // fast calc
	    if (Arrays.equals(this.shape, other.shape)) {
	        NDArray ndarry;
	        double[] data = new double[this.data.length];
	        int[] shape = Arrays.copyOf(this.shape, this.shape.length);
	        if (this.shape.length == 1) {
	            ndarry = new Array1D(data);
	        } else if (this.shape.length == 2) {
	            ndarry = new Array2D(data, shape);
	        } else {
	            ndarry = new NDArray();
	            ndarry.data = data;
	            ndarry.shape = Arrays.copyOf(this.shape, this.shape.length);
	        }
	        
	        for (int i = 0; i < this.data.length; i++) {
	            ndarry.data[i] = biFunc.apply(this.data[i] , other.data[i]);
	        }
	        
	        return ndarry;
	    }
	    
	    // boardcast calc
	    int[] boardcastShape = ArrayUtils.boardcastShape(this.shape, other.shape);
	    final NDArray ndarry;
	    if (boardcastShape.length == 2) {
            ndarry = new Array2D();
        } else {
            ndarry = new NDArray();
        }
	    
	    ndarry.data = new double[ArrayUtils.cumprod(boardcastShape)];
	    ndarry.shape = boardcastShape;
	    
	    final int[] copyIndex0 = new int[ndarry.shape.length];
	    final int[] copyIndex1 = new int[ndarry.shape.length];
	    ArrayUtils.foreach(boardcastShape, (int[] index) -> {
	        System.arraycopy(index, 0, copyIndex0, 0, index.length);
	        System.arraycopy(index, 0, copyIndex1, 0, index.length);
	        ndarry.data[ndarry.index(index)] = biFunc.apply(this.data[this.boardcastIndex(copyIndex0)] , other.data[other.boardcastIndex(copyIndex1)]);
	    });
	    
	    return ndarry;
	}

    @Override
    public String toString() {
        return "NDArray [data=" + Arrays.toString(data) + ", shape=" + Arrays.toString(shape) + "]";
    }

}
