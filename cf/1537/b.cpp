#include <bits/stdc++.h>

#define ll long long

using namespace std;

ll path(pair<ll, ll> x, pair<ll, ll> y) {
  return abs(x.first - y.first) + abs(x.second - y.second);
}

void solve() {
  ll n, m, i, j;
  cin >> n >> m >> i >> j;
  vector<pair<ll, ll>> pairs = {{1, 1}, {n, 1}, {1, m}, {n, m}};
  ll maxx = 0;
  ll x1, x2, y1, y2;
  for (int i = 0; i < pairs.size(); i++) {
    for (int j = 0; j < pairs.size(); j++) {
        pair<ll, ll> anton = {i, j};
        ll max_path = path(anton, pairs[i]) + path(pairs[i], pairs[j]) + path(pairs[j], anton);
        if (max_path > maxx) {
          x1 = pairs[i].first;
          y1 = pairs[i].second;
          x2 = pairs[j].first;
          y2 = pairs[j].second;
          maxx = max(maxx, max_path);
        }
    }
  }
  cout << x1 << " " << y1 << " " << x2 << " " << y2 << endl;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    // freopen("input.txt", "r", stdin);
    ll t;
    cin >> t;
    while (t-- > 0) solve();
}
