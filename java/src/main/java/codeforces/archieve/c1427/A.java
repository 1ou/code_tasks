package codeforces.archieve.c1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/*
https://codeforces.com/problemset/problem/?/?
4
4
1 -2 3 -4
3
0 0 0
5
1 -1 1 -1 1
6
40 -31 -9 0 13 -40

 */
public class A {
    static void solve() {
        int n = FS.nextInt();
        List<Integer> a = new ArrayList<>();
        int negative = 0;
        int positive = 0;
        int nu = 0;
        for (int i = 0; i < n; i++) {
            int y = FS.nextInt();
            a.add(y);
            if (y < 0) {
                negative += Math.abs(y);
            } else if (y > 0) {
                positive += y;
            } else {
                nu++;
            }
        }
        if (negative == positive) {
            FS.pt.println("NO");
            return;
        }
        FS.pt.println("YES");
        if (negative > positive) {
            for (int i = 0; i < n; i++) {
                if (a.get(i) < 0) {
                    FS.pt.print(a.get(i) + " ");
                }
            }
            for (int i = 0; i < n; i++) {
                if (a.get(i) > 0) {
                    FS.pt.print(a.get(i) + " ");
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (a.get(i) > 0) {
                    FS.pt.print(a.get(i) + " ");
                }
            }
            for (int i = 0; i < n; i++) {
                if (a.get(i) < 0) {
                    FS.pt.print(a.get(i) + " ");
                }
            }
        }

        for (int i = 0; i < nu; i++) {
            FS.pt.print(" 0 ");
        }
        FS.pt.println();
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

        static long[][] read2ArrayL(int m, int n) {
            long[][] a = new long[m][n];
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

        static void printArrL(int[] arr) {
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

        static void print2Arr(long[][] arr, int m, int n) {
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
