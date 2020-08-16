
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/*
1
3 3
RRD
DDR
RRC
 */

import java.lang.*;


public class B {
    public static void main(String[] args) {
        try {
            FastScanner fs = new FastScanner();
            PrintWriter pt = new PrintWriter(System.out);

            int T = fs.nextInt();

            for (int tt = 0; tt < T; tt++) {
                int n = fs.nextInt();
                int m = fs.nextInt();
                char[][] arr = new char[n][m];
                int c = 0;
                for (int i = 0; i < n; ++i) {
                    arr[i] = fs.next().toCharArray();
                }
                for (int i = 0; i < m - 1; ++i) {
                    if (arr[n-1][i] != 'R') c++;
                }

                for (int i = 0; i < n - 1; ++i) {
                    if (arr[i][m-1] != 'D' ) c++;
                }
                pt.println(c);
            }
            pt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

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

        char nextChar() {
            return next().charAt(0);
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
