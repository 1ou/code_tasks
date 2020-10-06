package codeforces.archieve.c1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/*
https://codeforces.com/problemset/problem/1406/A
6
6
-1 -2 -3 1 2 -1
5
-1 -2 -3 -4 -5
11
1 0 5 4 -4 3 1 1 0 -3 2
6
-1 0 0 0 -1 -1
6
-9 -7 -5 -3 -2 1
12
-1 -1 -2 0 0 1 1 2 3 -5 1 -1

 */
public class B {

    static void solve() {
        int n = FS.nextInt();
        List<Integer> arr = new ArrayList<>(n);
        for (int i =0; i < n; i++) {
            arr.add(FS.nextInt());
        }
        arr.sort(Comparator.comparingInt(Math::abs));

        int min = 0;
        for (int i = n - 1; i >= n - 5; i--) {
            if (arr.get(i) < 0) {
                min++;
            }
        }

        int sum = 1;
        int k = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k == 5) break;

            if (min % 2 != 0 && k == 4 && arr.get(i) > 0 && i != 0) {
                continue;
            }
            sum *= arr.get(i);
            k++;
        }

        FS.pt.println(sum);
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
