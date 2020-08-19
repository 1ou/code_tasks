#include <bits/stdc++.h>

#define ll long long
using namespace std;

/*
10
6 10 4 10 2 8 9 2 7 7
*/
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    if (n == 1) {
        cout << "1\n";
    }
    if (n <= 3) {
        cout << "NO SOLUTION\n";
    } else {
        ll odd = 0, even = 0;
        if (n % 2 != 0) odd = 1;
        if (n % 2 == 0) even = 1;
        for (ll i = 1; i <= (n + even) / 2 ; i++) {
            cout << i * 2 << " ";
        }

        for (ll i = 1; i <= (n + odd) / 2 ; i++) {
            cout << i * 2 - 1 << " ";
        }
    }
}
