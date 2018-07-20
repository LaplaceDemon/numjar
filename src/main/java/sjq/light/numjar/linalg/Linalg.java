package sjq.light.numjar.linalg;

import sjq.light.numjar.ndarray.Array2D;

public class Linalg {

    public Array2D inv(Array2D arr) {
        int[] shape = arr.shape();
        int w = shape[0];
        int h = shape[1];
        if (w != h) {
            throw new RuntimeException("Last 2 dimensions of the array must be square");
        }

        int n = w;
        double[][] data = arr.getData();
        double[][] invArr = inv0(data, n);
        Array2D resultArray = new Array2D(invArr);
        return resultArray;
    }

    private double[][] inv0(double[][] a, int n) {
        int i, j, k, l, u, v;
        double d, p;
        int[] is = new int[n];
        int[] js = new int[n];

        for (k = 0; k <= n - 1; k++) {
            d = 0.0;
            for (i = k; i <= n - 1; i++)
                for (j = k; j <= n - 1; j++) {
                    l = i * n + j;
                    p = Math.abs(a[l][0]);
                    if (p > d) {
                        d = p;
                        is[k] = i;
                        js[k] = j;
                    }
                }

            if (d + 1.0 == 1.0) {
                throw new RuntimeException("error!");
            }

            if (is[k] != k)
                for (j = 0; j <= n - 1; j++) {
                    u = k * n + j;
                    v = is[k] * n + j;
                    p = a[u][0];
                    a[u] = a[v];
                    a[v][0] = p;
                }
            if (js[k] != k)
                for (i = 0; i <= n - 1; i++) {
                    u = i * n + k;
                    v = i * n + js[k];
                    p = a[u][0];
                    a[u] = a[v];
                    a[v][0] = p;
                }
            l = k * n + k;

            a[l][0] = 1.0 / a[l][0];
            for (j = 0; j <= n - 1; j++)
                if (j != k) {
                    u = k * n + j;
                    a[u][0] = a[u][0] * a[l][0];
                }
            for (i = 0; i <= n - 1; i++)
                if (i != k)
                    for (j = 0; j <= n - 1; j++)
                        if (j != k) {
                            u = i * n + j;
                            a[u][0] = a[u][0] - a[i * n + k][0] * a[k * n + j][0];
                        }
            for (i = 0; i <= n - 1; i++)
                if (i != k) {
                    u = i * n + k;
                    a[u][0] = -a[u][0] * a[l][0];
                }
        }
        for (k = n - 1; k >= 0; k--) {
            if (js[k] != k)
                for (j = 0; j <= n - 1; j++) {
                    u = k * n + j;
                    v = js[k] * n + j;
                    p = a[u][0];
                    a[u][0] = a[v][0];
                    a[v][0] = p;
                }
            if (is[k] != k)
                for (i = 0; i <= n - 1; i++) {
                    u = i * n + k;
                    v = i * n + is[k];
                    p = a[u][0];
                    a[u][0] = a[v][0];
                    a[v][0] = p;
                }
        }

        return a;
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
        double[][] a = arr.getData();

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
        
        for(int i = 1; i <= n; i++) {
            l[i-1][i-1] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int k = i;k <= n;k++) {
                double tmpSum = 0;
                for(int j = 1;j <= i-1;j++) {
                    tmpSum += l[i-1][j-1]*u[j-1][k-1];
                }
                
                u[i-1][k-1] = a[i-1][k-1] - tmpSum;
                System.out.print("u[" +  i + "][" + k + "],");
            }
            
            for(int k = i+1;k <= n;k++) {
                double tmpSum = 0;
                for(int j = 1;j <= i-1;j++) {
                    tmpSum += l[k-1][j-1]*u[j-1][i-1];
                }
                
                l[k-1][i-1] = (a[k-1][i-1] - tmpSum)/u[i-1][i-1];
                System.out.print("l[" +  k + "][" + i + "],");
            }
            
            System.out.println();
        }
        
        Array2D arrU = new Array2D(u);
        Array2D arrL = new Array2D(l);

        Array2D[] result = new Array2D[] {arrL, arrU};
        return result;
    }
    
    public Array2D invL(Array2D arr) {
        double[][] l = arr.getData();
        int[] shape = arr.shape();
        int w = shape[0];
        int h = shape[1];

        if (w != h) {
            throw new RuntimeException("Last 2 dimensions of the array must be square");
        }
        int n = w;

        double[][] r = new double[n][n];
        
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                r[i][i] = 1;
                if(i == j) {
                    r[j][i] = 1/(l[i][i]);
                } else if(i<j) {
                    double tmpSum = 0;
                    for(int k = i+1;k<=j;k++) {
                        tmpSum += r[j][k]*l[k][i];
                    }
                    
                    r[j][i] = -r[i][i]*tmpSum;
                } else {
                    r[j][i] = 0;
                }
            }
        }
        
        Array2D result = new Array2D(r);
        return result;
    }
    
    
}
