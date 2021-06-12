#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
   // freopen("input.txt", "r", stdin);

    int t, n;

    cin >> t;
    while (t-- > 0) {
        cin >> n;
        vector<ll> v(n);
        ll sum = 0;
        for (int i = 0; i < n; i++) {
        	cin >> v[i];
        	sum += v[i];
        }
        if (sum % n != 0) {
        	cout << "-1\n";
        } else {
        	int ans = 0;
       	ll d = sum / n;
        	for (int i = 0; i < n; i++) {
        		if (v[i] > d) {
        			ans++;
        		}
        	}
        	cout << ans << endl;
        }
    }
}
