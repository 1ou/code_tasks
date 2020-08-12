#include <bits/stdc++.h>

//https://codeforces.com/contest/1316/problem/A

using namespace std;
#define ll long long int

int main() {
//    freopen("/home/toxa/Work/codeforces/1316/input.txt", "r", stdin);

    ll test;
    cin >> test;
    while (test--) {
        ll n, m;
        cin >> n >> m;
        ll s = 0;
        for (ll i = 0; i < n; ++i) {
            ll x;
            cin >> x;
            s = s + x;
        }
        cout << min(s, m) << "\n";
    }
    return 0;
}