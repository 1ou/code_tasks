package codeforces.contest.c1408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/1408/A

 */
public class A {

    static void solve() {
        int n = FS.nextInt();
        int a[] = FS.readArray(n);
        int b[] = FS.readArray(n);
        int c[] = FS.readArray(n);
        int[] p = new int[n];
        p[0] = a[0];
        for (int i = 1; i < n; i++) {
            if (i != n -1) {
                if (p[i - 1] != a[i]) {
                    p[i] = a[i];
                    continue;
                }
                if (p[i - 1] != b[i]) {
                    p[i] = b[i];
                    continue;
                }
                if (p[i - 1] != c[i]) {
                    p[i] = c[i];
                    continue;
                }
            } else {
                if (p[i - 1] != a[i] && p[0] != a[i]) {
                    p[i] = a[i];
                    continue;
                }
                if (p[i - 1] != b[i] && p[0] != b[i]) {
                    p[i] = b[i];
                    continue;
                }
                if (p[i - 1] != c[i] && p[0] != c[i]) {
                    p[i] = c[i];
                    continue;
                }
            }
        }
        FS.printArr(p);
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

        void printArr(long[] arr) {
            for (long value : arr) {
                pt.print(value);
                pt.print(" ");
            }
            pt.println();
        }
        static long[] readArrayL(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
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
