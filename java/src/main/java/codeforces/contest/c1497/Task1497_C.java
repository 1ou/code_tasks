package codeforces.contest.c1497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/*
https://codeforces.com/problemset/problem/1497/C
4
20 4
9 5
11 3
20 20
 */
public class Task1497_C {

    static void solve() {
        long n = FS.nextLong();
        int k = FS.nextInt();
        StringBuilder sb = new StringBuilder();
        while (k > 3) {
            sb.append(1).append(" ");
            n--;
            k--;
        }
        if (n % 4 == 0) {
            sb.append(n / 4).append(" ").append(n / 4).append(" ").append(n / 2).append(" ");
        } else if (n % 4 == 1) {
            sb.append(1).append(" ");
            n--;
            sb.append(n / 2).append(" ").append(n / 2).append(" ");
        } else if (n % 4 == 2) {
            sb.append(2).append(" ");
            n -= 2;
            sb.append(n / 2).append(" ").append(n / 2).append(" ");
        } else {
            sb.append(1).append(" ");
            n--;
            sb.append(n / 2).append(" ").append(n / 2).append(" ");
        }
        FS.pt.println(sb);
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

        public static long nextPrime(long num) {
            num++;
            for (long i = 2; i < num; i++) {
                if (num % i == 0) {
                    num++;
                    i = 2;
                }
            }
            return num;
        }

        public static long prevPrime(long num) {
            num--;
            for (long i = 2; i < num; i++) {
                if (num % i == 0) {
                    num--;
                    i = 2;
                }
            }
            return num;
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
