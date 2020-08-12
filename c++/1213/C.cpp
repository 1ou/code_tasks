#include <bits/stdc++.h>

//https://codeforces.com/contest/1213/problem/A

using namespace std;

int main() {
    freopen("/home/toxa/Work/codeforces/1213/input.txt", "r", stdin);

    int t;
    cin >> t;

    for (int k = 0; k < t; ++k) {
        long long n, m;
        cin >> n >> m;

        long long div = n / m;

        for (int i = 1; i <= 10; i++) {
            long long digit = m * i % 10;
            long long count = div / 10 + (numbers % 10 >= i ? 1 : 0);
            sum += count * digit;
        }
        cout << sum << endl;
    }

    return 0;
}