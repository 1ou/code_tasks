package codeforces.contest.c1451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/*
https://codeforces.com/problemset/problem/1451/C
4
3 3
abc
bcd
4 2
abba
azza
2 1
zz
aa
6 2
aaabba
ddddcc

 */
public class TaskC_1451 {

    static class Pair {
        int f;
        int s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    static void solve() {
        int n = FS.nextInt();
        int k = FS.nextInt();
        char[] a = FS.next().toCharArray();
        char[] b = FS.next().toCharArray();

        // key - uchastok, v - Map<Integer, Int> // k - index, v - int(char)
        Map<Integer, List<Pair>> mapAA = new HashMap<>();
        Map<Integer, List<Pair>> mapBB = new HashMap<>();

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                List<Pair> uchA = mapAA.get(i);
                if (uchA == null) {
                    uchA = new ArrayList<>();
                }
                uchA.add(new Pair(i * k + j, a[i * k + j]));
                mapAA.put(i, uchA);

                List<Pair> uchB = mapBB.get(i);
                if (uchB == null) {
                    uchB = new ArrayList<>();
                }
                uchB.add(new Pair(i * k + j, b[i * k + j]));
                mapBB.put(i, uchB);
            }
        }

        for (Map.Entry<Integer, List<Pair>> itA : mapAA.entrySet()) {
            for (int i = 0; i < itA.getValue().size(); i++) {
                for (Map.Entry<Integer, List<Pair>> itB : mapBB.entrySet()) {

                    int prevDiff = (int) b[itB.getValue().get(0).f] - (int) a[itA.getValue().get(i).f];

                    boolean t = true;
                    for (int j = 1; j < itB.getValue().size(); j++) {
                        int diff = (int) b[itB.getValue().get(j).f] - (int) a[itA.getValue().get(i).f + j];
                        if (diff <= 0 || prevDiff != diff) {
                            t = false;
                            break;
                        }
                    }
                    if (t) {
                        for (int u = itA.getValue().get(i).f; u < itA.getValue().get(i).f + itA.getValue().size(); u++) {
                            a[u] = b[u];
                        }
                    }
                }

            }
        }
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Integer aa = mapA.get((int) a[i]);
            if (aa == null) {
                aa = 1;
            } else {
                aa++;
            }
            mapA.put((int) a[i], aa);

            Integer bb = mapB.get((int) b[i]);
            if (bb == null) {
                bb = 1;
            } else {
                bb++;
            }
            mapB.put((int) b[i], bb);
        }

        for (Map.Entry<Integer, Integer> it : mapA.entrySet()) {
            Integer bCount = mapB.get(it.getKey());
            if (bCount == null || it.getValue() != bCount) {
                FS.pt.println("NO");
                return;
            }
        }
        FS.pt.println("YES");
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
}
