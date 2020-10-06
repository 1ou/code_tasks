package codeforces.archieve.c1393;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
6
1 1 1 2 1 1
6
+ 2
+ 1
- 1
+ 2
- 1
+ 2
 */
public class B {

    static void solve() {
        int n = FS.nextInt();
        int d[] = new int[10000000];
        int kv = 0, pr = 0;
        for (int i = 0; i < n; ++i) {
            int x = FS.nextInt();
            kv -= d[x] / 4;
            pr -= d[x] / 2;
            d[x]++;
            kv += d[x] / 4;
            pr += d[x] / 2;
        }
        int q = FS.nextInt();
        for (int i = 0; i < q; i++) {
            char c = FS.next().charAt(0);
            int x = FS.nextInt();
            kv -= d[x] / 4;
            pr -= d[x] / 2;

            if (c == '+') {
                d[x]++;
            }
            if (c == '-') {
                d[x]--;
            }

            kv += d[x] / 4;
            pr += d[x] / 2;

            if (kv >= 1 && pr >= 4) {
                FS.pt.println("YES");
            } else {
                FS.pt.println("NO");
            }
        }
    }


    public static void main(String[] args) {
//        int T = FS.nextInt();
//        for (int tt = 0; tt < T; tt++) {
        solve();
//        }
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

        static Integer nextIntBox() {
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
