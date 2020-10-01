package codeforces.contest.c1408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/*
https://codeforces.com/problemset/problem/1408/B
1
11 3
0 1 2 2 3 3 3 4 4 4 4

1
4 1
0 0 0 1

6
4 1
0 0 0 1
3 1
3 3 3
11 3
0 1 2 2 3 3 3 4 4 4 4
5 3
1 2 3 4 5
9 4
2 2 3 5 7 11 13 13 17
10 7
0 1 1 2 3 3 4 5 5 6

1
11 3
0 1 2 2 3 3 3 4 4 4 4
 */
public class B {

    static void solve() {
        int n = FS.nextInt();
        int k = FS.nextInt();
        int[] arr = FS.readArray(n);
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> pairs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
            pairs.put(arr[i], i);
        }
        if (set.size() > k) {
            int j = 2;
            int lastWorked = 0;
            while (true) {
                Set<Integer> used = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    boolean found = false;
                    for (int o = 0; o < used.size(); o++) {
                        for (int oo = 0; oo < used.size(); oo++) {
                            if (o + oo == arr[i]) {
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        used.add(arr[i]);
                        if (used.size() > k) {
                            if (lastWorked == 0) {
                                FS.pt.println("-1");
                                return;
                            } else {
                                FS.pt.println(lastWorked);
                                return;
                            }
                        }
                    }
                }
                lastWorked = j;
                j++;
            }
        } else {
            FS.pt.println(1);
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
