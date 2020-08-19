#include <bits/stdc++.h>

#define ll long long

using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    ll t;
    cin >> t;
    ll s = 0;
    for (int i =0; i < t - 1; i++) {
        ll k;
        cin >> k;
        s += k;
    }
    cout << (t * (t + 1) / 2) - s << "\n";
}
