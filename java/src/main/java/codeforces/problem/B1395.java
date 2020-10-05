package codeforces.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

/*
3 3 2 2
3 4 2 2
100 100 2 2
 */
public class B1395 {

    static void solve() {
        int n = FS.nextInt();
        int m = FS.nextInt();
        int Sx = FS.nextInt();
        int Sy = FS.nextInt();

        FS.pt.println(Sx + " " + Sy);
        int[][] matrix = new int[n][m];
        matrix[Sx - 1][Sy - 1] = 1;
        boolean t = false;
        int start = 2;

        int [] visitX = new int[n];
        int [] visitY = new int[m];
        visitX[Sx - 1] = 1;
        visitY[Sy - 1] = 1;

        while (start <= n * m) {

            t = !t;

            if (t) {
                int x = 0;
                int u = 0;
                while (x <= n - 1) {
                    if (matrix[x][Sy - 1] == 0) {
                        matrix[x][Sy - 1] = 1;
                        start++;
                        FS.pt.println((x + 1) + " " + Sy);
                        u = x + 1;
                    }
                    x++;
                }
                Sx = u;
            } else {
                int y = 0;
                int u = 0;
                while (y <= m - 1) {
                    if (matrix[Sx - 1][y] == 0) {
                        matrix[Sx - 1][y] = 1;
                        start++;
                        FS.pt.println(Sx + " " + (y + 1));
                        u = y + 1;
                    }
                    y++;
                }
                Sy = u;
            }
        }
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
