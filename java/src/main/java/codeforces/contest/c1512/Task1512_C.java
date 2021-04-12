//package codeforces.contest.c1512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/1512/C
1
4 1
00?00
 */
public class Task1512_C {

    static void solve() {
        long a = FS.nextLong();
        long b = FS.nextLong();
        long tmpA = a;
        long tmpB = b;

        char[] ar = FS.next().toCharArray();
        int l = 0;
        int r = ar.length - 1;
        int cnt0 = 0;
        int cnt1 = 0;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == '0') {
                cnt0++;
                a--;
            }
            if (ar[i] == '1') {
                cnt1++;
                b--;
            }
        }

        while (l < r) {
            if (ar[l] != '?' && ar[r] == '?') {
                if (ar[l] == '0' && a > 0) {
                    ar[r] = '0';
                    cnt0++;
                    a--;
                } else if (ar[l] == '1' && b > 0) {
                    ar[r] = '1';
                    cnt1++;
                    b--;
                } else {
                    FS.pt.println(-1);
                    return;
                }
            } else if (ar[l] == '?' && ar[r] != '?') {
                if (ar[r] == '0' && a > 0) {
                    ar[l] = '0';
                    cnt0++;
                    a--;
                } else if (ar[r] == '1' && b > 0) {
                    ar[l] = '1';
                    cnt1++;
                    b--;
                } else {
                    FS.pt.println(-1);
                    return;
                }
            }
            l++;
            r--;
        }

        l = 0;
        r = ar.length - 1;
        while (l < r) {
            if (ar[l] == '?' && ar[r] == '?') {
                if (a > 1 && cnt0 <= tmpA - 2) {
                    ar[l] = '0';
                    ar[r] = '0';
                    cnt0 += 2;
                    a -= 2;
                } else if (b > 1 && cnt1 <= tmpB - 2) {
                    ar[l] = '1';
                    ar[r] = '1';
                    b -= 2;
                    cnt1 += 2;
                } else {
                    FS.pt.println(-1);
                    return;
                }
            }
            l++;
            r--;
        }

        if (ar[l] == '?') {
            if (a > 0) {
                ar[l] = '0';
                cnt0++;
            } else if (b > 0) {
                ar[l] = '1';
                cnt1++;
            } else {
                FS.pt.println(-1);
                return;
            }
        }

        if (cnt0 != tmpA && cnt1 != tmpB) {
            FS.pt.println(-1);
            return;
        }
        boolean palindrom = true;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != ar[ar.length - 1 - i]) {
                palindrom = false;
                break;
            }
        }

        if (!palindrom) {
            FS.pt.println(-1);
            return;
        }

        for (int i = 0; i < ar.length; i++) {
            FS.pt.print(ar[i]);
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

        static double nextDouble() {
            return Double.parseDouble(next());
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
                    a[i][j] = nextLong();
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
            for (int i = 0; i < n; i++) a[i] = nextLong();
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

    static class Mat {
        public static long pow(long a, long exp) {
            return (long) Math.pow(a, exp);
        }
    }

    static class NumberTheory {
        public static boolean isPrime(long n) {
            if (n <= 1) return false;
            if (n < 4) return true;
            if (n % 2 == 0) return false;
            if (n % 3 == 0) return false;

            for (int i = 5, next = 2; i * i <= n; i += next, next = 6 - next)
                if (n % i == 0) return false;

            return true;
        }

        public static long gcd(long a, long b) {
            while (b != 0) {
                long tmp = a % b;
                a = b;
                b = tmp;
            }
            return a;
        }

        public static long lcm(long a, long b) {
            return a * b / gcd(a, b);
        }

        public static List<Long> primeFactors(long n) {
            List<Long> ans = new ArrayList<>();
            while (n % 2 == 0) {
                ans.add(2L);
                n /= 2;
            }

            // n must be odd at this point.  So we can
            // skip one element (Note i = i + 2)
            for (long i = 3; i <= Math.sqrt(n); i += 2) {
                // While i divides n, print i and divide n
                while (n % i == 0) {
                    ans.add(i);
                    n /= i;
                }
            }

            // This condition is to handle the case when
            // n is a prime number greater than 2
            if (n > 2) {
                ans.add(n);
            }
            return ans;
        }

        static long fact(long n) {
            if (n == 0 || n == 1) return 1L;
            long r = 1;
            for (int i = 1; i <= n; i++) {
                r *= i;
            }
            return r;
        }

        static long fact(long n, long mod) {
            if (n <= 1) return 1;
            long ans = 1;
            for (int i = 1; i <= n; i++) {
                ans = (ans * i) % mod;
            }
            return ans;
        }

        static long fastExp(long x, long n, long mod) {
            long ans = 1;
            while (n > 0) {
                if (n % 2 == 1) ans = (ans * x) % mod;
                x = (x * x) % mod;
                n /= 2;
            }
            return ans;
        }
    }

    static class BinarySearch {
        public static int lowerBound(int[] arr, int key) {
            int low = 0;
            int high = arr.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] >= key) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public static int lowerBound(long[] arr, long key) {
            int low = 0;
            int high = arr.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] >= key) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public static <T extends Comparable<T>> int lowerBound(List<T> arr, T key) {
            int low = 0;
            int high = arr.size() - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (arr.get(mid).compareTo(key) >= 0) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public static int upperBound(int[] arr, int key) {
            int low = 0;
            int high = arr.length - 1;
            while (low < high) {
                int mid = low + (high - low + 1) / 2;
                if (arr[mid] <= key) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

        public static int upperBound(long[] arr, long key) {
            int low = 0;
            int high = arr.length - 1;
            while (low < high) {
                int mid = low + (high - low + 1) / 2;
                if (arr[mid] <= key) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

        public static <T extends Comparable<T>> int upperBound(List<T> arr, T key) {
            int low = 0;
            int high = arr.size() - 1;
            while (low < high) {
                int mid = low + (high - low + 1) / 2;
                if (arr.get(mid).compareTo(key) >= 0) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }
    }

    static class Pair<T, K> {
        T first;
        K second;

        public Pair(T first, K second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
