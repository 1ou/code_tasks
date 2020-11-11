package codeforces.archieve.c1311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/*
https://codeforces.com/problemset/problem/1311/B
1
6 2
9 1 1 1 1 1
1 2

6
3 2
3 2 1
1 2
4 2
4 1 2 3
3 2
5 1
1 2 3 4 5
1
4 2
2 1 4 3
1 3
4 2
4 3 2 1
1 3
5 2
2 1 2 3 3
1 4
 */
public class B {

    static void solve() {
        int n = FS.nextInt();
        int m = FS.nextInt();
        int[] a = FS.readArray(n);
        int[] p = FS.readArray(m);
        Arrays.sort(p);

        List<Integer> otr = new ArrayList<>();
        List<Integer> otrM = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int f = Arrays.binarySearch(p, i + 1);
            if (f < 0) {
                otr.add(a[i]);
                otrM.add(a[i]);
            } else {
                int min = a[p[f] - 1];
                int max = a[p[f] - 1];
                boolean ff = true;
                while (f < m && ((f < m - 1 && p[f] + 1 == p[f+1]) || ff || (p[f-1] + 1 == p[f] && m - 1 == f))) {
                    if (a[p[f]] < min) {
                        min = a[p[f]];
                    }

                    if (a[p[f]] > max) {
                        max = a[p[f]];
                    }

                    f++;
                    i++;
                    ff = false;
                }
                otr.add(min);
                otrM.add(max);
            }
        }

        for (int i = 0; i < otr.size() - 1; i++) {
            if (otr.get(i) > otr.get(i + 1)) {
                FS.pt.println("NO");
                return;
            }
        }
        for (int i = 0; i < otrM.size() - 1; i++) {
            if (otrM.get(i) > otrM.get(i + 1)) {
                FS.pt.println("NO");
                return;
            }
        }
        FS.pt.println("YES");
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
