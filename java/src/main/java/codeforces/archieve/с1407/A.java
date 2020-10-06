package codeforces.archieve.с1407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
8
2
1 0
2
0 0
4
0 1 1 1
4
1 1 0 0
2
1 1
6
1 1 1 1 1 1
4
1 0 1 0
4
1 1 1 1

1
2
1 1
 */
public class A {

    static void solve() {
        int n = FS.nextInt();
        int[] arr = FS.readArray(n);
        int s0 = 0, s1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                s1++;
            } else {
                s0++;
            }
        }
        if (s1 > s0) {
            int y = 0;
            if ((n / 2) % 2 != 0) {
                FS.pt.println(n / 2 + 1);
                y = 1;
            } else {
                FS.pt.println(n / 2);
            }
            for (int i = 0; i < n / 2 + y; i++) {
                FS.pt.print("1 ");
            }
        } else {
            FS.pt.println(n / 2);
            for (int i = 0; i < n / 2; i++) {
                FS.pt.print("0 ");
            }
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
