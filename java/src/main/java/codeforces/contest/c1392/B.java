//package codeforces.contest.c1392;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
4
1 2
1
2 1
-199 192
5 19
5 -1 4 2 0
1 2
69
 */
public class B {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            int n = fs.nextInt();
            long k = fs.nextInt();
            long[] arr = fs.readArrayLong(n);
            for (int j = 0; j < k; j++) {
                long max = Long.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }
                for (int i = 0; i < n; ++i) {
                    arr[i] = max - arr[i];
                }
            }
            fs.printArr(arr);
        }
        fs.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        PrintWriter pt = new PrintWriter(System.out);

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readArrayLong(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        int[][] read2Array(int m, int n) {
            int[][] a = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = nextInt();
                }
            }
            return a;
        }

        void printArr(int[] arr) {
            for (int value : arr) {
                pt.print(value);
                pt.print(" ");
            }
            pt.println();
        }

        void printArr(long[] arr) {
            for (long value : arr) {
                pt.print(value);
                pt.print(" ");
            }
            pt.println();
        }

        void print2Arr(int[][] arr, int m, int n) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    pt.print(arr[i][j]);
                    pt.print(" ");
                }
                pt.println();
            }
            pt.println();
        }

        void close() {
            pt.close();
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
