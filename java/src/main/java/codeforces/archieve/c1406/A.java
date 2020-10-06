package codeforces.archieve.c1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/1406/A
4
6
0 2 1 5 0 1
3
0 1 2
4
0 2 0 1
6
1 2 3 4 5 6

1
3
0 1 2
 */
public class A {

    static void solve() {
        int n = FS.nextInt();
        int[] arr = FS.readArray(n);
        Arrays.sort(arr);
        int[] mex1 = new int[(n + 1) /2];
        int[] mex2 = new int[(n + 1) /2];

        for (int i = 0; i < (n + 1) / 2; i++) {
            mex1[i] = arr[i * 2];
            if (i * 2 + 1 < n) {
                mex2[i] = arr[i * 2 + 1];
            }
        }

        int min1 = 0;
        int min2 = 0;
        boolean m1 = true;
        boolean m2 = true;
        for (int i = 0; i < n / 2; i++) {
            if (mex1[i] == min1 && m1) {
                min1++;
            } else {
                m1 = false;
            }

            if (mex2[i] == min2 && m2) {
                min2++;
            } else {
                m2 = false;
            }
        }

        FS.pt.println(min1 + min2);
    }

    public static void main(String[] args) {
        int T = FS.nextInt();
        for (int tt = 0; tt < T; tt++) {
            solve();
        }
        FS.pt.close();
    }

    static class FS {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st = new StringTokenizer("");
        static PrintWriter pt = new PrintWriter(System.out);

        static String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        static int[][] read2Array(int m, int n) {
            int[][] a = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = nextInt();
                }
            }
            return a;
        }

        static void printArr(int[] arr) {
            for (int value : arr) {
                pt.print(value);
                pt.print(" ");
            }
            pt.println();
        }

        static void print2Arr(int[][] arr, int m, int n) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    pt.print(arr[i][j]);
                    pt.print(" ");
                }
                pt.println();
            }
            pt.println();
        }

        static void close() {
            pt.close();
        }

        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}
