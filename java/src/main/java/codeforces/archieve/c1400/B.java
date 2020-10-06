package codeforces.archieve.c1400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
3
33 27
6 10
5 6
100 200
10 10
5 5
1 19
1 3
19 5
 */
public class B {

    static void solve() {
        long p, f;
        p = FS.nextLong();
        f = FS.nextLong();
        int ctnW, ctnS;
        ctnS = FS.nextInt();
        ctnW = FS.nextInt();
        long s, w;
        s = FS.nextLong();
        w = FS.nextLong();

        int ss = 0;

        while (p >= 0 && f >= 0 && (ctnS != 0 || ctnW != 0)) {
            if (s <= w && ctnS >= 0) {
                p -= s;
                f -= s;
                ctnS-=2;
                ss+= 2;
                continue;
            }
            if (ctnW >= 0) {
                p -= w;
                f -= w;
                ctnW-=2;
                ss += 2;
            }
        }

        if (p < 0 && f <= 0) {
            ss-=2;
        }

        if (p < 0 || f <= 0) {
            ss--;
        }

        if (ctnS < 0) {
            ss -= ctnS * (-1);
        }

        if (ctnW < 0) {
            ss -= ctnW * (-1);
        }
        FS.pt.println(ss);
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
