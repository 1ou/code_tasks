#include <bits/stdc++.h>

using namespace std;

int main() {
//    freopen("input.txt", "r", stdin);
    long long t, n, sum, tot, cnt;
    cin >> t;

    while (t-- > 0) {
        sum = tot = cnt = 0;
        cin >> n;
        vector<long long> a(n);
        for (int i = 0; i < n; i++) {
            cin >> a[i];
            sum ^= a[i];
        }
        if (sum > 0) {
            for (int i = 0; i < n; i++) {
                tot ^= a[i];
                if (tot == sum) {
                    tot = 0;
                    cnt++;
                }
            }
            if (cnt <= 1) cout << "NO\n";
            else {
                if (cnt & 1)cout << "YES\n";
                else cout << "NO\n";
            }
        } else {
            cout << "YES\n";
        }
    }
}
