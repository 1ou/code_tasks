#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
    //freopen("input.txt", "r", stdin);

    int t, n;

    cin >> t;
    while (t-- > 0) {
        cin >> n;
        vector<ll> v(n);
        int minn = INT_MAX;
        int maxx = INT_MIN;
        int max_i = 0;
        int min_i = 0;
        for (int i = 0; i < n; i++) {
        	cin >> v[i];
        	if (v[i] < minn) {
        		minn = v[i];
        		min_i = i + 1;
        	}
        	if (v[i] > maxx) {
        		maxx = v[i];
        		max_i = i + 1;
        	}
        }
        // 4 2 3 1 8 6 7 5
        
        // 2 1 3 4 5 6 8 7
        
        // 2 3 1 4
       // cout << min_i << " " << max_i << endl;
        int ans1 = min(n - min(min_i, max_i) + 1, max(min_i, max_i));
        int ans2 = min(n - max_i + 1 + min_i, n - min_i + 1 + max_i);
       // cout << ans1 << " " << ans2 << endl;
        cout << min(ans1, ans2) << endl;
        //cout << endl;
    }
}
