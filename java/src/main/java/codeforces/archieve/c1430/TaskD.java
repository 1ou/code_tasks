package codeforces.archieve.c1430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/1430/D
2
3
000
3
100

1
6
010000

1
12
111101000101
 */
public class TaskD {

    static void solve() {
        int n = FS.nextInt();
        char[] str = FS.next().toCharArray();
        int prev = 0;
        int cnt = 0;
        while (str.length > 1) {
            for (int i = 1; i < str.length; i++) {
                if (str[i] == str[prev]) {
                    while (i + 1 < str.length && str[++i] == str[prev]) {
                    }
                    if (i == str.length - 1 && str[prev] == str[i]) {
                        str = new char[0];
                        cnt++;
                        break;
                    }
                    char[] tmp = new char[str.length - i];
                    int k = 0;
                    while (i < str.length) {
                        tmp[k++] = str[i];
                        i++;
                    }
                    str = tmp;
                    cnt++;
                    break;
                } else {
                    while (i + 1 < str.length && str[++i] == str[i-1]) {}
                    char[] tmp = new char[str.length - i];
                    int k = 0;
                    while (i < str.length) {
                        tmp[k] = str[i];
                        i++;
                        k++;
                    }
                    if (str.length == 2 && tmp.length == 1) {
                        str = new char[0];
                    } else {
                        str = tmp;
                    }
                    cnt+=1;
                }
            }
        }
        if (str.length == 1) {
            cnt++;
        }
        FS.pt.println(cnt);
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
