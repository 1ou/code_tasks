//package codeforces.archieve.c1379;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/1379/A
6
7
abacaba
7
???????
11
aba?abacaba
11
abacaba?aba
15
asdf???f???qwer
11
abacabacaba

 */
public class A {

    static void solve() {
        int n = FS.nextInt();
        char[] str = FS.next().toCharArray();
        char[] sub = "abacaba".toCharArray();
        int c = 0, k = 0;
        int cId = 0;
        for (int i = 0; i < n - sub.length + 1; i++) {
            int u = 0;
            int r = 0;

            for (int j = 0; j < sub.length; j++) {
                boolean b = str[i + j] == sub[j];

                if (b || (str[i + j] == '?')) {
                    u++;
                }

                if (b) {
                    r++;
                }
            }
            if (u == sub.length) {
                c++;
                cId = i;
            }
            if (r == sub.length) k++;
        }

        if (k > 1) {
            FS.pt.println("NO");
            return;
        }
        if (c + k > 0) {
            FS.pt.println("YES");
            if (k == 0) {
                for (int i = 0; i < sub.length; i++) {
                    str[i + cId] = sub[i];
                }

                int cc = 0;
                for (int i = 0; i < sub.length * 2 && i + cId < n; i++) {
                    boolean b = false;
                    for (int j = 0; j < sub.length; j++) {
                        if (str[i] != sub[j]) {
                            b = true;
                            break;
                        }
                    }
                    if (!b) {
                        cc++;
                    }
                }
                if (cc > 1) {
                    FS.pt.println("");
                }
            }

            for (int i = 0; i < str.length; i++) {
                if (str[i] == '?') {
                    str[i] = 'f';
                }
            }
            FS.pt.println(str);
        } else {
            FS.pt.println("NO");
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
