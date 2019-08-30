package io.github.laplacedemon.numjar.linalg;

import io.github.laplacedemon.numjar.NumJar;
import io.github.laplacedemon.numjar.ndarray.Array2D;

public class Linalg {
    private NumJar numja;

    public Linalg(NumJar numja) {
        this.numja = numja;
    }

    public Array2D inv(Array2D arr) {
        Array2D[] lu = LU(arr);
        Array2D invL = invL(lu[0]);
        Array2D invU = invU(lu[1]);
        Array2D invArr = numja.dot(invU, invL);
        return invArr;
    }

    public double determinant(double a[][], int n) {
        double det = 0;

        if (n == 1) {
            det = a[0][0];
        } else if (n == 2) {
            det = a[0][0] * a[1][1] - a[1][0] * a[0][1];
        } else {
            det = 0;
            for (int j1 = 0; j1 < n; j1++) {
                double[][] m = new double[n - 1][];
                for (int k = 0; k < (n - 1); k++) {
                    m[k] = new double[n - 1];
                }
                for (int i = 1; i < n; i++) {
                    int j2 = 0;
                    for (int j = 0; j < n; j++) {
                        if (j == j1)
                            continue;
                        m[i - 1][j2] = a[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0, 1.0 + j1 + 1.0) * a[0][j1] * determinant(m, n - 1);
            }
        }
        return det;
    }

    public double det(Array2D arr) {
        double[] a = arr.getData();

        int[] shape = arr.shape();
        int w = shape[0];
        int h = shape[1];
        if (w != h) {
            throw new RuntimeException("Last 2 dimensions of the array must be square");
        }
        int n = w;

        double detValue = determinant(a, n);
        return detValue;
    }

    public Array2D[] LU(Array2D arr) {
        double[][] a = arr.getData();
        int[] shape = arr.shape();
        int w = shape[0];
        int h = shape[1];

        if (w != h) {
            throw new RuntimeException("Last 2 dimensions of the array must be square");
        }
        int n = w;

        double[][] l = new double[n][n];
        double[][] u = new double[n][n];

        for (int i = 1; i <= n; i++) {
            l[i - 1][i - 1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int k = i; k <= n; k++) {
                double tmpSum = 0;
                for (int j = 1; j <= i - 1; j++) {
                    tmpSum += l[i - 1][j - 1] * u[j - 1][k - 1];
                }

                u[i - 1][k - 1] = a[i - 1][k - 1] - tmpSum;
            }

            for (int k = i + 1; k <= n; k++) {
                double tmpSum = 0;
                for (int j = 1; j <= i - 1; j++) {
                    tmpSum += l[k - 1][j - 1] * u[j - 1][i - 1];
                }

                l[k - 1][i - 1] = (a[k - 1][i - 1] - tmpSum) / u[i - 1][i - 1];
            }

        }

        
        Array2D arrL = new Array2D(l);
        Array2D arrU = new Array2D(u);

        Array2D[] result = new Array2D[] {arrL, arrU};
        return result;
    }

    /**
     * 相关文档：http://www.docin.com/p-785750320.html?docfrom=rrela
     * 
     * @param arr
     * @return
     */
    public Array2D invL(Array2D arr) {
        double[] l = arr.getData();
        int[] shape = arr.shape();
        int w = shape[0];
        int h = shape[1];

        if (w != h) {
            throw new RuntimeException("Last 2 dimensions of the array must be square");
        }
        int n = w;

        double[][] r = new double[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = j; i < n; i++) {
                if (i == j) {
                    r[i][j] = 1;
                } else {
                    double tmpSum = 0;
                    for (int k = 0; k < i; k++) {
//                        tmpSum += l[i][k] * r[k][j];
                        tmpSum += arr.get(i, k) * r[k][j];
                    }

                    r[i][j] = -tmpSum;
                }
            }
        }

        Array2D result = new Array2D(r);
        return result;
    }

    /**
     * 相关文档：http://www.docin.com/p-785750320.html?docfrom=rrela
     * 
     * @param arr
     * @return
     */
    public Array2D invU(Array2D arr) {
        double[] u = arr.getData();
        int[] shape = arr.shape();
        int w = shape[0];
        int h = shape[1];

        if (w != h) {
            throw new RuntimeException("Last 2 dimensions of the array must be square");
        }
        int n = w;

        double[][] r = new double[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
//                    r[i][j] = 1 / u[i][j];
                    r[i][j] = 1 / arr.index(i, j);
                } else {
                    double tmpSum = 0;
                    for (int k = i + 1; k <= j; k++) {
//                        tmpSum += u[i][k] * r[k][j];
                        tmpSum += arr.index(i, k) * r[k][j];
                    }

//                    r[i][j] = -tmpSum / u[i][i];
                    r[i][j] = -tmpSum / arr.index(i, i);
                }
            }
        }

        Array2D result = new Array2D(r);
        return result;
    }

}
