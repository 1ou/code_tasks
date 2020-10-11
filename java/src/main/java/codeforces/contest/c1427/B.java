package codeforces.contest.c1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Stream;

/*
https://codeforces.com/problemset/problem/?/?
8
5 2
WLWLL
6 5
LLLWWL
7 1
LWLWLWL
15 5
WWWLLLWWWLLLWWW
40 7
LLWLWLWWWLWLLWLWWWLWLLWLLWLLLLWLLWWWLWWL
1 0
L
1 1
L
6 1
WLLWLW

1
6 1
WLLWLW

 */
public class B {
    static class Obj {
        int left;
        int right;

        public Obj(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static void solve() {
        int n = FS.nextInt();
        int k = FS.nextInt();
        char[] str = FS.next().toCharArray();
        List<Obj> otr = new ArrayList<>();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == 'W') {
                cnt++;
            } else {
                if (cnt > 0) {
                    Obj obj = new Obj(i - cnt, i - 1);
                    otr.add(obj);
                }
                cnt = 0;
            }
            if (i == n - 1 && cnt > 0) {
                Obj obj = new Obj(i - cnt + 1, i);
                otr.add(obj);
            }
        }

        int used = 0;
        TreeMap<Integer, List<Obj>> mm = new TreeMap<>();
        while (used < k && otr.size() > 1) {
            mm.clear();
            for (int i = 0; i < otr.size(); i++) {
                for (int j = i + 1; j < otr.size(); j++) {
                    int dis = otr.get(j).left - otr.get(i).right - 1;
                    if (dis <= k - used) {
                        int size1 = otr.get(i).right - otr.get(i).left + 1;
                        int size2 = otr.get(j).right - otr.get(j).left + 1;
                        List<Obj> arr = mm.get(size1 + size2 - (otr.get(j).left - otr.get(i).right - 1));
                        if (arr == null) {
                            arr = new ArrayList<>();
                        }
                        arr.add(new Obj(i, j));
                        mm.put(size1 + size2 - (otr.get(j).left - otr.get(i).right - 1), arr);
                    }
                }
            }
            if (mm.size() == 0) break;
            int last = mm.lastKey();
            List<Obj> val = mm.get(last);
            Obj left = otr.get(val.get(0).left);
            Obj right = otr.get(val.get(0).right);
            used += right.left - left.right - 1;
            for (int i = left.right + 1; i < right.left; i++) {
                str[i] = 'W';
            }
            left.right = right.right;
            otr.remove(val.get(0).right);
        }


        if (used < k) {
            otr.clear();
            cnt = 0;
            for (int i = 0; i < n; i++) {
                if (str[i] == 'W' && i != n - 1) {
                    cnt++;
                } else {
                    if (str[i] == 'W' && i == n - 1) cnt++;
                    if (cnt > 0) {
                        Obj obj = new Obj(i - cnt, i);
                        otr.add(obj);
                    }
                    cnt = 0;
                }
            }
            if (otr.size() > 0) {
                int max = Integer.MIN_VALUE;
                int maxI = 0;
                for (int i = 0; i < otr.size(); i++) {
                    if (max < (otr.get(i).right - otr.get(i).left)) {
                        max = otr.get(i).right - otr.get(i).left;
                        maxI = i;
                    }
                }
                Obj y = otr.get(maxI);
                int l = y.left;
                while (used < k && l - 1 >= 0 && str[l - 1] != 'W') {
                    str[l - 1] = 'W';
                    l--;
                    used++;
                }
                int r = y.right;
                while (used < k && r < n && str[r] != 'W') {
                    str[r] = 'W';
                    r++;
                    used++;
                }
            } else {
                FS.pt.println(k * 2 - 1);
                return;
            }
        }
//        FS.print2Arr(matrix, otr.size(), otr.size());
//        int used = 0;
//        for (Map.Entry<Integer, List<Obj>> entry : map.entrySet()) {
//            Integer key = entry.getKey();
//            List<Obj> value = entry.getValue();
//            if (key <= k) {
//                int i = 0;
//                while (used < k && i <= value.size() - 1) {
//                    Obj obj = value.get(i);
//                    for (int j = obj.left; j < obj.right && obj.right < n; j++) {
//                        str[j+1] = 'W';
//                        used += 1;
//                    }
//                    if (k <= used) break;
//                    for (int j = obj.left; j > 0 && obj.right < n; j++) {
//                        str[j+1] = 'W';
//                        used += 1;
//                    }
//                    value.remove(i);
//                }
//            }
//        }
//
        FS.pt.println(String.format("Update str = %s", String.copyValueOf(str)));
        cnt = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == 'W') {
                if (cnt > 0) {
                    cnt = 2;
                } else {
                    cnt = 1;
                }
            } else {
                cnt = 0;
            }
            ans += cnt;
        }
        FS.pt.println(ans);
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

        static void close() {
            pt.close();
        }

        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}
