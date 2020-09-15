package codeforces.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/1364/A
4
3 3
1 2 3
3 4
1 2 3
2 2
0 6
3 3
3 6 9

1
3 4
1 2 3
 */
public class A1364 {

    static void solve() {
        int n = FS.nextInt();
        int x = FS.nextInt();
        int[] arr = FS.readArray(n);
        int[] sum = new int[n];
        sum[0] = arr[0];
        boolean each = true;
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
            if (each && arr[i] % x != 0) {
                each = false;
            }
        }
        if (each) {
            FS.pt.println(-1);
            return;
        }
        if (sum[n - 1] % x != 0) {
            FS.pt.println(n);
            return;
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    if (sum[i] % x != 0) {
                        max = Math.max(max, i + 1);
                    }
                } else {
                    if ((sum[j] - sum[i]) % x != 0) {
                        max = Math.max(max, j - i);
                    }
                }
            }
        }

        FS.pt.println(max);
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
