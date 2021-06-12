#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
   // freopen("input.txt", "r", stdin);

    int t, n;

    cin >> t;
    while (t-- > 0) {
    	ll l, r;
    
        cin >> n >> l >> r;
        vector<ll> v(n);


        for (int i = 0; i < n; i++) {
        	cin >> v[i];
        }

	ll ans = 0;
	sort(v.begin(), v.end());
	// 3 4 7
	// 1 2 5
	
        for (int i = 0; i < n; i++) {
        	ll left = l - v[i];
        	ll right = r - v[i];
		ll lower_left = lower_bound(v.begin() + i + 1, v.end(), max(left, v[i])) - v.begin();
		ll upper_right = upper_bound(v.begin() + i + 1, v.end(), right) - v.begin();

		ans += max(0ll, (upper_right - lower_left));
        }
        cout << ans << endl;
    }
}
