#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
  //  freopen("input.txt", "r", stdin);

    ll t, n;

    cin >> t;
    while (t-- > 0) {
        cin >> n;
        vector<ll> v(n + 2);
        v[0] = 0;
        v[n + 1] = 0;
        for (int i = 1; i <= n; i++) {
          cin >> v[i];
        }

        ll ans = 0;
        for (int i = 1; i <= n; i++) {
          if (v[i] > v[i - 1] && v[i] > v[i + 1]) {
            ans -= min(v[i] - v[i - 1], v[i] - v[i + 1]);
          }
        }

        for (int i = 0; i < n + 1; i++) {
          ans += abs(v[i + 1] - v[i]);
        }

        // for (int i = 0; i < n + 2; i++) {
        //   cout << v[i] << " ";
        // }
        // cout << endl;
        cout << ans << endl;
    }
}
