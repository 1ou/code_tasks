package codeforces.contest.c1400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/*
3
101110
2
01
1
110
1

 */
public class Cproblem {

    static void solve() {
        int x;
        String s = FS.next();
        x = FS.nextInt();
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            arr[i] = '1';
        }
        for (int i =0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                if (i - x >= 0)
                    arr[i - x] = '0';
                if (i + x < s.length())
                    arr[i + x] = '0';
            }
        }
        for (int i = 0; i < s.length(); i++) {
            boolean one = false;
            one = i - x >= 0 && arr[i - x] == '1';
            one = one || (i + x < s.length() && arr[i + x] == '1');

            char c = (one) ? '1' : '0';
            if (s.charAt(i) != c) {
                FS.pt.println(-1);
                return;
            }
        }

        FS.pt.println(arr);
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
