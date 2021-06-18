#include <bits/stdc++.h>

#define ll long long

using namespace std;

vector<pair<ll, ll>> minimumAbsDifference(vector<ll> &input, ll size)
{
    sort(input.begin(), input.end());
    ll min_abs_diff = LONG_LONG_MAX;
    vector<pair<ll, ll>> result;
    for(ll i = 0; i < size - 1; i++) {
      min_abs_diff = min(min_abs_diff, abs(input[i] - input[i+1]));
    }
    for(ll i = 0; i < size - 1; i++) {
        if(abs(input[i] - input[i+1]) == min_abs_diff){
            result.push_back({input[i], input[i+1]});
        }
    }
    return result;
}

void solve() {
  ll n;
  cin >> n;
  vector<ll> v(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
  }
  std::vector<pair<ll, ll>> good = minimumAbsDifference(v, n);
  pair<ll, ll> best;
  ll minn = LONG_LONG_MAX;
  for (int i = 0; i < good.size(); i++) {
    if (good[i].first < minn) {
      minn = good[i].first;
      best = good[i];
    }
  }

  vector<ll> ans, ans2;
  for( std::vector<ll>::iterator iter = v.begin(); iter != v.end(); ++iter ){
      if( *iter == best.first ) {
          v.erase( iter );
          break;
      }
  }
  for( std::vector<ll>::iterator iter = v.begin(); iter != v.end(); ++iter ){
      if( *iter == best.second ){
          v.erase( iter );
          break;
      }
  }
  ll prev = best.first;
  for (int i = 0; i < v.size(); i++) {
    if (v[i] >= best.first) {
      ans.push_back(v[i]);
    } else {
      ans2.push_back(v[i]);
    }
  }

  cout << best.first << " ";
  for (int i = 0; i < ans.size(); i++) {
    cout << ans[i] << " ";
  }
  for (int i = 0; i < ans2.size(); i++) {
    cout << ans2[i] << " ";
  }
  cout << best.second << endl;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    freopen("input.txt", "r", stdin);
    ll t;
    cin >> t;
    while (t-- > 0) solve();
}
