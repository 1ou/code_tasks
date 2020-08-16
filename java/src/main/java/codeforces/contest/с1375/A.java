package codeforces.contest.с1375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
5
3
-2 4 3
5
1 1 1 1 1
5
-2 4 7 -6 4
9
9 7 -4 -2 1 -3 9 -4 -5
9
-4 1 9 4 8 9 5 1 -9
 */
public class A {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            int n = fs.nextInt();
            int ar[] = fs.readArray(n);
            for (int i = 0; i < n; i++) {
                if (ar[i] < 0) {
                    ar[i] *= -1;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                if (i % 2 == 0 && ar[i + 1] < ar[i]) {
                    ar[i] *= -1;
                } else if (i % 2 == 1 && ar[i + 1] > ar[i]) {
                    ar[i + 1] *= -1;
                }
            }
            fs.printArr(ar);
        }
        fs.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        PrintWriter pt = new PrintWriter(System.out);

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        void printArr(int[] arr) {
            for (int value : arr) {
                pt.print(value);
                pt.print(" ");
            }
            pt.println();
        }

        void close() {
            pt.close();
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
