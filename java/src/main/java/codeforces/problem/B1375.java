package codeforces.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/1375/B
 */
public class B1375 {

    static List<Pair<Integer, Integer>> nearest(int m, int n, int i, int j) {
        List<Pair<Integer, Integer>> ll = new ArrayList<>();
        if (i == 0) {
            if (j == 0) {
                ll.addAll(Arrays.asList(new Pair<>(0, 1), new Pair<>(1, 0)));
            } else if (j == n - 1) {
                ll.addAll(Arrays.asList(new Pair<>(0, j - 1), new Pair<>(1, j)));
            } else {
                ll.addAll(Arrays.asList(new Pair<>(0, j - 1), new Pair<>(0, j + 1), new Pair<>(1, j)));
            }
        } else if (i == m - 1) {
            if (j == 0) {
                ll.addAll(Arrays.asList(new Pair<>(i, 1), new Pair<>(i - 1, 0)));
            } else if (j == n - 1) {
                ll.addAll(Arrays.asList(new Pair<>(i, j - 1), new Pair<>(i - 1, j)));
            } else {
                ll.addAll(Arrays.asList(new Pair<>(i, j - 1), new Pair<>(i, j + 1), new Pair<>(i - 1, j)));
            }
        } else {
            if (j == 0) {
                ll.addAll(Arrays.asList(new Pair<>(i - 1, 0), new Pair<>(i + 1, 0), new Pair<>(i, 1)));
            } else if (j == n - 1) {
                ll.addAll(Arrays.asList(new Pair<>(i - 1, j), new Pair<>(i + 1, j), new Pair<>(i, j - 1)));
            } else {
                ll.addAll(Arrays.asList(new Pair<>(i, j - 1), new Pair<>(i, j + 1), new Pair<>(i - 1, j), new Pair<>(i + 1, j)));
            }
        }
        return ll;
    }

    static void solve() {
        int m = FS.nextInt();
        int n = FS.nextInt();
        long[][] arr = FS.read2ArrayL(m, n);

        int label = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                long s = arr[i][j];
                if (s > 4)
                    label = 0;

                if ((i == 0 || i + 1 == m) && (j == 0 || j + 1 == n) && s > 2)
                    label = 0;

                if ((i == 0 || i + 1 == m) && s > 3)
                    label = 0;

                if ((j == 0 || j + 1 == n) && s > 3)
                    label = 0;
            }
        }

        if (label != 0)
            FS.pt.println("YES");
        else
            FS.pt.println("NO");

        if (label != 0) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if ((i == 0 || i + 1 == m) && (j == 0 || j + 1 == n))
                        FS.pt.print("2 ");
                    else if ((i == 0 || i + 1 == m))
                        FS.pt.print("3 ");
                    else if ((j == 0 || j + 1 == n))
                        FS.pt.print("3 ");
                    else
                        FS.pt.print("4 ");
                }
                FS.pt.println();
            }
        }
    }

    public static void main(String[] args) {
        int T = FS.nextInt();
        for (int tt = 0; tt < T; tt++) {
            solve();
        }
        FS.pt.close();
    }

    static class Pair<T, N> {
        T i;
        N j;

        public Pair(T i, N j) {
            this.i = i;
            this.j = j;
        }
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
        }

        static void print2ArrL(long[][] arr, int m, int n) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    pt.print(arr[i][j]);
                    pt.print(" ");
                }
                pt.println();
            }
        }

        static void close() {
            pt.close();
        }

        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}
