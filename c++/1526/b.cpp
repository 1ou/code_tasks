#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
//    freopen("input.txt", "r", stdin);

    ll t, n;

    cin >> t;
    while (t-- > 0) {
        cin >> n;

        if (n >= 1111) {
            cout << "YES\n";
            continue;
        }

        bool t = false;
        for (int i = 0; i <= 101; i++) {
            for (int j = 0; j <= 100; j++) {
                if (11 * i + 111 * j == n) {
                    t = true;
                    break;
                }
            }
            if (t) break;
        }

        if (t) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }
}
