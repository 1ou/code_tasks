package codeforces.contest.c1400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3
101110
2
01
1
110
1

2
01
1
110
1

1
110
1
 */
public class C {

    static void solve() {
        int x;
        String s = FS.next();
        x = FS.nextInt();
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            boolean f = true;
            if (i + 1 > x && s.charAt(i) == '1') {
                arr[i - x] = '1';
            } else {
                if (i + 1 > x) {
                    if (s.charAt(i) == '0' && arr[i - x] == '1') {
                        FS.pt.println(-1);
                        return;
                    }
                }
                f = false;
            }
            if (i + 1 + x <= s.length() && s.charAt(i) == '1') {
                arr[i + x] = '1';
            } else {
                if (!f) {
                    if (i + 1 + x <= s.length()) {
                        if (s.charAt(i) == '0' && arr[i + x] == '1') {
                            FS.pt.println(-1);
                            return;
                        }
                    }
                    if (i + 1 + x <= s.length()) {
                        arr[i + x] = '0';
                    }
                    if (i + 1 > x) {
                        arr[i - x] = '0';
                    }
                } else {
//                    FS.pt.println(-1);
//                    return;
                }
            }
        }
//        int one = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != '1') {
//                arr[i] = '0';
//            } else {
//                one++;
//            }
//        }

//        if (one == arr.length) {
//            FS.pt.println(-1);
//        } else {
        FS.pt.println(arr);
//        }
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
