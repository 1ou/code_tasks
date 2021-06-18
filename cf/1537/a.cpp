#include <bits/stdc++.h>

#define ll long long

using namespace std;

void solve() {
  ll n;
  cin >> n;
  vector<ll> v(n);
  ll sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> v[i];
    sum += v[i];
  }

  if (sum < n) {
      cout << "1\n";
  } else if (sum == n) {
    cout << "0\n";
  }
  else {
    cout << sum - n << endl;
  }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    // freopen("input.txt", "r", stdin);
    ll t;
    cin >> t;
    while (t-- > 0) solve();
}
