package codeforces.contest.c1417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/*
https://codeforces.com/problemset/problem/14217/B
1
4 4
3 3
3 1
3 3
1 3
1 3
3 3
3 1
3 3

6
3 4
1 2
5 6
5 7
7 4
8 9
9 8
2 5
1 1
1 1
2 2
2 2
1 100
10 10
10 10
1 2
4 5
8 4
2 2
1 1
1 1
1 2
3 4
1 2
1 1
1 1

 */
public class B {

    static void solve() {
        int n = FS.nextInt();
        int m = FS.nextInt();
        int sim = 0;
        int simFull = 0;
        int triple = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < n; k++) {
            int x = FS.nextInt();
            int y = FS.nextInt();
            int x2 = FS.nextInt();
            int y2 = FS.nextInt();

            if (x == y && y == x2 && x2 == y2) {
                simFull++;
                continue;
            }
            if (x == y2 && y == x2) {
                sim++;
                continue;
            }
            if (x == y && y == x2) {
                Integer i = map.get(x);
                if (i == null) {
                    i = 1;
                } else {
                    i++;
                }
                map.put(x, i);
                continue;
            }

            if (x == y && y == y2) {
                Integer i = map.get(x);
                if (i == null) {
                    i = 1;
                } else {
                    i++;
                }
                map.put(x, i);
                continue;
            }

            if (x == x2 && x2 == y2) {
                Integer i = map.get(x);
                if (i == null) {
                    i = 1;
                } else {
                    i++;
                }
                map.put(x, i);
                continue;
            }

            if (y == x2 && x2 == y2) {
                Integer i = map.get(y);
                if (i == null) {
                    i = 1;
                } else {
                    i++;
                }
                map.put(y, i);
            }
        }
        if (m % 2 == 1) {
            FS.pt.println("NO");
            return;
        }
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() == 4) {
                triple = 1;
                break;
            }
        }
        if ((sim > 0 || triple == 1) && m % 4 == 0) {
            FS.pt.println("YES");
        } else if (simFull > 0) {
            FS.pt.println("YES");
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

        static void printArrL(long[] arr) {
            for (long value : arr) {
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
