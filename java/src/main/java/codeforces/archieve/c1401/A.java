package codeforces.archieve.c1401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
11
0 0
0 1
0 2
1 0
1 1
1 2
5 8
2 2
2 0
3 0
7 3
 */
public class A {

    static void solve() {
        long n, k;
        n = FS.nextLong();
        k = FS.nextLong();
        boolean t = false;
        long c = -1;
        long y = k;

        if (n == k) {
            FS.pt.println(0);
        }
        if (k > n) {
            FS.pt.println(k - n);
        }
        if (n > k) {
            if (Math.abs(n - k) % 2 == 0) {
                FS.pt.println(0);
            } else {
                FS.pt.println(1);
            }
        }
//        while (!t) {
//            for (long b = 0; b <= n; b++) {
//                if (Math.abs((b - 0) - (n - b)) == Math.abs(k)) {
//                    t = true;
//                }
//                if (Math.abs((b - 0) - (n - b)) == Math.abs(y)) {
//                    t = true;
//                }
//            }
//            c++;
//            k--;
//            y++;
//        }
//
//        FS.pt.println(c);
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
