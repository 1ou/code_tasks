#include <bits/stdc++.h>

#define ll long long

using namespace std;

ll t;

int main() {
//    freopen("input.txt", "r", stdin);

    cin >> t;
    while (t-- > 0) {
        ll n;
        cin >> n;
        if (n < 2050 || n % 2050 != 0) {
            cout << "-1\n";
            continue;
        } else {
            int ans = 0;
            while (n > 0) {
                ll next = 2050;
                while (next <= n) {
                    next *= 10;
                }
                next /= 10;
                n -= next;
                ans++;
            }
            cout << ans << endl;
        }
    }
}
