#include <bits/stdc++.h>

//https://codeforces.com/contest/1208/problem/A

using namespace std;


int main() {
    //freopen("/home/toxa/Work/codeforces/1208/input.txt", "r", stdin);

    int t;
    cin >> t;

    for (int i = 0; i < t; ++i) {
        unsigned long a, b, n;
        cin >> a >> b >> n;

        if (n % 3 == 0) {
            cout << a << "\n";
        }

        if (n % 3 == 1) {
            cout << b << "\n";
        }

        if (n % 3 == 2) {
            cout << to_string(a ^ b) << "\n";
        }
    }

    return 0;
}