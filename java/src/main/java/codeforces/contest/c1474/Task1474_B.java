package codeforces.contest.c1474;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/*
https://codeforces.com/problemset/problem/1474/B
1
2

9
1
2
3
4
5
7
9
20
10000
 */
public class Task1474_B {
    static List<Integer> firstPrimeNumbers(int d, int n) {
        List<Integer> primeNumbers = new ArrayList<>();
        int num = 1;
        int prev = -100000;
        while (primeNumbers.size() < n) {
            boolean flag = false;
            int i = 2;
            while (i <= num / 2) {
                // condition for nonprime number
                if (num % i == 0) {
                    flag = true;
                    break;
                }

                ++i;
            }
            if (!flag) {
                if (num - prev >= d) {
                    primeNumbers.add(num);
                    prev = num;
                }
                num += d;
            } else {
                num++;
            }
        }
        return primeNumbers;
    }

    static void solve() {
        long d = FS.nextLong();
        List<Integer> primes = firstPrimeNumbers((int) d, 3);
        FS.pt.println(NumberTheory.lcm(primes.get(1), primes.get(2)));
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

        static List<Integer> sieveOfEratosthenes(int n) {
            boolean prime[] = new boolean[n + 1];
            Arrays.fill(prime, true);
            for (int p = 2; p * p <= n; p++) {
                if (prime[p]) {
                    for (int i = p * 2; i <= n; i += p) {
                        prime[i] = false;
                    }
                }
            }
            List<Integer> primeNumbers = new LinkedList<>();
            for (int i = 2; i <= n; i++) {
                if (prime[i]) {
                    primeNumbers.add(i);
                }
            }
            return primeNumbers;
        }

        static List<Integer> firstPrimeNumbers(int n) {
            List<Integer> primeNumbers = new ArrayList<>();
            int num = 1;
            while (primeNumbers.size() < n) {
                boolean flag = false;
                int i = 2;
                while (i <= num / 2) {
                    // condition for nonprime number
                    if (num % i == 0) {
                        flag = true;
                        break;
                    }

                    ++i;
                }
                if (flag) {
                    primeNumbers.add(num);
                } else {
                    num++;
                }
            }
            return primeNumbers;
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
