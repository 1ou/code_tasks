package codeforces.contest.c1454;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/*
https://codeforces.com/problemset/problem/1454/B
 */
public class TaskB_1454 {

    static void solve() {
        int n = FS.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int p = FS.nextInt();
            a[i] = p;
            Integer val = map.get(p);
            if (val == null) {
                val = 1;
            } else {
                val++;
            }
            map.put(p, val);
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (value == 1) {
                min = Math.min(key, min);
                cnt++;
            }
        }

        if (cnt == 0) {
            FS.pt.println(-1);
        } else {
            for (int i = 0; i < n; i++) {
                if (a[i] == min) {
                    FS.pt.println(i + 1);
                    return;
                }
            }
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

        static int[][] read2Array(int n, int m) {
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = nextInt();
                }
            }
            return a;
        }

        static long[][] read2ArrayL(int n, int m) {
            long[][] a = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
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

        static void print2Arr(int[][] arr, int n, int m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    pt.print(arr[i][j]);
                    pt.print(" ");
                }
                pt.println();
            }
            pt.println();
        }

        static void print2Arr(long[][] arr, int n, int m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    pt.print(arr[i][j]);
                    pt.print(" ");
                }
                pt.println();
            }
            pt.println();
        }

        static List<Long> readListLong(int n) {
            List<Long> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(nextLong());
            }
            return list;
        }

        static List<Integer> readListInt(int n) {
            List<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(nextInt());
            }
            return list;
        }

        static <T> void printList(List<T> list) {
            for (T value : list) {
                pt.print(value);
                pt.print(" ");
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

    static class Pair<T> {
        T first;
        T second;

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }
}
