package codeforces.archieve.c1440;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/1440/C
 */
public class TaskC_1440 {

    static void solve() {
        int n = FS.nextInt();
        int m = FS.nextInt();
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = FS.next();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = 0;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        int last = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = 0;
                last += 1;
                ans.add(new ArrayList<>());

                if (mat[i][j] == 1) {
                    ans.get(last).add(i + 1);
                    ans.get(last).add(j + 1);
                    mat[i][j] = 0;
                    cnt++;
                }

                if (i + 1 < n && mat[i+1][j] == 1) {
                    ans.get(last).add(i + 2);
                    ans.get(last).add(j + 1);
                    mat[i+1][j] = 0;
                    cnt++;
                }

                if (j + 1 < m && mat[i][j+1] == 1) {
                    ans.get(last).add(i + 1);
                    ans.get(last).add(j + 2);
                    mat[i][j+1] = 0;
                    cnt++;
                }

                if (cnt < 3) {
                    if (i + 1 < n && j + 1 < m && mat[i + 1][j + 1] == 1) {
                        ans.get(last).add(i + 2);
                        ans.get(last).add(j + 2);

                        mat[i+1][j+1] = 0;
                        cnt++;
                    }
                } else {
                    if (i + 1 < n && j + 1 < m && mat[i + 1][j + 1] == 1) {
                        last++;
                        ans.add(new ArrayList<>());

                        mat[i+1][j+1] = 0;
                        ans.get(last).add(i + 2);
                        ans.get(last).add(j + 2);
                    }
                }

                if (ans.get(last).size() > 0 && ans.get(last).size() < 0) {

                }

                if (ans.get(last).size() == 0) {
                    ans.remove(last);
                    last--;
                }
            }
        }

        FS.pt.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                FS.pt.print(ans.get(i).get(j) + " ");
            }
            FS.pt.println();
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
