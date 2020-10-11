package codeforces.contest.c1430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/?/?
4
100
11
19
23

 */
public class A {

    static void solve() {
        int n = FS.nextInt();
        if (n % 3 == 0) {
            FS.pt.println(n / 3 + " 0 0");
            return;
        } else if (n % 5 == 0) {
            FS.pt.println("0 " + n / 5 + " 0");
            return;
        } else if (n % 7 == 0) {
            FS.pt.println("0 0 " + n / 7);
            return;
        }

        if ((n - 3) % 5 == 0 && (n - 3) > 0) {
            FS.pt.println("1 " + (n - 3) / 5 + " 0");
            return;
        } else if ((n - 7) % 5 == 0 && (n - 7) > 0) {
            FS.pt.println("0 " + (n - 7) / 5 + " 1");
            return;
        } else if ((n - 5) % 3 == 0 && (n - 5) > 0) {
            FS.pt.println((n - 5) / 3 + " 1 0");
            return;
        } else if ((n - 7) % 3 == 0 && (n - 7) > 0) {
            FS.pt.println((n - 7) / 3 + " 0 1");
            return;
        } else if ((n - 3) % 7 == 0 && (n - 3) > 0) {
            FS.pt.println("1 0 " + (n - 3) / 7);
            return;
        } else if ((n - 5) % 7 == 0 && (n - 5) > 0) {
            FS.pt.println("0 1 " + (n - 5) / 7);
            return;
        }
        FS.pt.println("-1");
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
