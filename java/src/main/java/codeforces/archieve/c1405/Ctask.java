package codeforces.archieve.c1405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
9
6 4
100110
3 2
1?1
3 2
1?0
4 4
????
7 4
1?0??1?
10 10
11??11??11
4 2
1??1
4 4
?0?0
6 2
????00

1
5 2
1??10

1
3 2
1?0

1
12 6
11?00?0?1010

1
7 4
1?0??1?
 */
public class Ctask {

    static void solve() {
        int n = FS.nextInt();
        int k = FS.nextInt();
        char[] c = FS.next().toCharArray();
        for (int i = 0; i < k; i++) {
            char set = 0;
            for (int j = i; j < n; j += k) {
                if (set != 0) {
                    if (c[j] != set && c[j] != '?') {
                        FS.pt.println("NO");
                        return;
                    }
                } else {
                    if (c[j] != '?')
                        set = c[j];
                }
            }
            if (set != 0) {
                for (int j = i; j < n; j += k) {
                    c[j] = set;
                }
            }
        }

        int sum = 0;
        int other = 0;
        for (int i = 0; i < k; i++) {
            if (c[i] == '1')
                sum++;
            else if (c[i] == '0')
                sum--;
            else
                other++;
        }

        if (Math.abs(sum) > other) {
            FS.pt.println("NO");
            return;
        }

        FS.pt.println("YES");
        return;
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

        static long[] readArrayL(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
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
