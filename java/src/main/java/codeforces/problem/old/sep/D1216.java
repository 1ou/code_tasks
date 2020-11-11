package codeforces.problem.old.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/1216/D
3
3 12 6
7
2 1000000000 4 6 8 4 2
2
2 9
37
114 331 517 362 641 238 52 920 734 610 889 641 393 889 889 548 114 579 920 207 486 858 207 548 207 176 455 734 517 579 920 734 300 889 641 455 21
 */
public class D1216 {
    public static long gcd(long a, long b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return Math.max(a, b);
    }

    static void solve() {
        int n = FS.nextInt();
        long[] arr = FS.readArrayL(n);
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i], max);
            sum += arr[i];
        }
        long minGcd = max - arr[0];
        for (int i = 1; i < n; i++) {
            minGcd = gcd(minGcd, max - arr[i]);
        }
        FS.pt.println(((max * n - sum) / minGcd) + " " + minGcd);
    }

    public static void main(String[] args) {
//        int T = FS.nextInt();
//        for (int tt = 0; tt < T; tt++) {
        solve();
//        }
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

        static long[] readArrayL(int n) {
            long[] a = new long[n];
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
