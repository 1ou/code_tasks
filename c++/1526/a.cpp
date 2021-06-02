#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
//    freopen("input.txt", "r", stdin);

    ll t, n;

    cin >> t;
    while (t-- > 0) {
        cin >> n;
        vector<ll> v(n * 2);
        for (int i = 0; i < n * 2; i++) {
            cin >> v[i];
        }
        sort(v.begin(), v.end());
        int l = 0;
        int r = n * 2 - 1;
        while (l <= r) {
            cout << v[l] << " " << v[r] << " ";
            l++;
            r--;
        }
        cout << endl;
    }
}
