package codeforces.problem.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/1369/B
5
10
0001111111
4
0101
8
11001101
10
1110000000
1
1

1
4
0101
 */
public class B1369 {

    static void solve() {
        int n = FS.nextInt();
        char[] s = FS.next().toCharArray();
        int start = -1;
        int leadZeros = 0;
        boolean t = true;
        for (int i = 0; i < n - 1; i++) {
            if (t && s[i] == '0') {
                leadZeros++;
            } else {
                t = false;
            }
            if (s[i] == '1' && s[i+1] == '0') {
                start = i;
            }
        }

        int tOnes = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == '1') {
                tOnes++;
            } else {
                break;
            }
        }
        if (start == -1) {
            FS.pt.println(s);
        } else {
            for (int i = 0; i <= leadZeros; i++) {
                FS.pt.print("0");
            }

            for (int i = 0; i < tOnes; i++) {
                FS.pt.print("1");
            }
            FS.pt.println();
        }
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
