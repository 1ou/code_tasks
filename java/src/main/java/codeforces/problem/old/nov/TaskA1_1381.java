package codeforces.problem.old.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/1381/A1
 */
public class TaskA1_1381 {

    static void swap(char[] arr, int pos) {
        for (int i = 0; i <= pos; i++) {
            if (arr[i] == '1') {
                arr[i] = '0';
            } else {
                arr[i] = '1';
            }
        }

        if (pos > 0) {
            for (int i = 0; i <= pos / 2; i++) {
                char tmp = arr[i];
                arr[i] = arr[pos - i];
                arr[pos - i] = tmp;
            }
        }
    }

    static void solve() {
        int n = FS.nextInt();
        String a = FS.next();
        String b = FS.next();

        List<Integer> ans = new ArrayList<>();
        char[] arr = a.toCharArray();

        int r = n - 1;
        while (!String.valueOf(arr).equals(b) && r >= 0) {
            if(arr[r] != b.charAt(r)) {
                if (arr[0] != b.charAt(r)) {
                    swap(arr, r);
                    ans.add(r + 1);
                } else {
                    swap(arr, 0);
                    ans.add(1);

                    swap(arr, r);
                    ans.add(r + 1);
                }
            }
            r--;
        }
        if (String.valueOf(arr).equals(b)) {
            FS.pt.print(ans.size() + " ");
            for (int i = 0; i < ans.size(); i++) {
                FS.pt.print(ans.get(i) + " ");
            }
        } else {
            FS.pt.print(0);
        }
        FS.pt.println();
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