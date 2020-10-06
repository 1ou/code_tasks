package codeforces.archieve.с1407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
7
2
2 5
4
1 8 2 3
3
3 8 9
5
64 25 75 100 50
1
42
6
96 128 88 80 52 7
5
2 4 8 16 17

1
5
64 25 75 100 50
 */
public class B {
    public static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return Math.max(a, b);
    }

    static void solve() {
        int n = FS.nextInt();
        int[] arr = FS.readArray(n);
        int[] res = new int[n];
        int max = arr[0];
        int maxI = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxI = i;
            }
        }
        res[0] = max;
        int next = 1;
        int maxN = Integer.MIN_VALUE;
        int maxGCD = Integer.MIN_VALUE;
        arr[maxI] = -1;
        int maxT = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == -1) {
                    continue;
                }
                int gcd = gcd(max, arr[i]);
                if (gcd > maxGCD || (gcd >= maxGCD && arr[i] > maxT)) {
                    maxGCD = gcd;
                    maxN = i;
                    maxT = arr[i];
                }
            }
            if (next < n) {
                res[next++] = arr[maxN];
                max = arr[maxN];
                arr[maxN] = -1;
                maxGCD = Integer.MIN_VALUE;
                maxN = Integer.MIN_VALUE;
                maxT = Integer.MIN_VALUE;
            }
        }
        FS.printArr(res);
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
