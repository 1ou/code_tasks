package codeforces.contest.c1409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
9
10 10 8 5 3
12 8 8 7 2
12343 43 4543 39 123212
1000000000 1000000000 1 1 1
1000000000 1000000000 1 1 1000000000
10 11 2 1 5
10 11 9 1 10
1 1 1 1 1
10 10 9 9 2

1
10 11 9 1 10
1
10 11 2 1 5

 */
public class B {

    static void solve() {
        long a = FS.nextLong();
        long b = FS.nextLong();
        long x = FS.nextLong();
        long y = FS.nextLong();
        long n = FS.nextLong();

//        FS.pt.println(" a " + a + " b " + b);

        while (n > 0 && (a > x || b > y)) {
            if ( b > y) {
                long r = Math.min(n, b - y);
                n -= r;
                b -= r;
            } else {
                long r = Math.min(n, a - x);
                n -= r;
                a -= r;
            }
        }
        FS.pt.println(a * b);
    }
/*
        while (n > 0 && (a > x || b > y)) {
            if (a - x >= b - y && b > y && bPrev - prevN > y) {
                long r = Math.min(n, b - y);
                n -= r;
                b -= r;
            } else if (a - x <= b - y && a > x && aPrev - prevN > x){
                long r = Math.min(n, a - x);
                n -= r;
                a -= r;
            } else if (b > y){
                long r = Math.min(n, b - y);
                n -= r;
                b -= r;
            } else {
                long r = Math.min(n, a - x);
                n -= r;
                a -= r;
            }
        }
 */

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
