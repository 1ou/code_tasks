#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
//    freopen("input.txt", "r", stdin);

    ll n;

    cin >> n;
    vector<ll> v(n);

    int first = -1;
    for (int i = 0; i < n; i++) {
        cin >> v[i];
        if (v[i] >= 0 && first == -1) {
            first = i;
        }
    }

    if (first == -1) {
        cout << "0\n";
        return 0;
    }
    unordered_map<ll, ll> mp;
    mp[first + 1] = v[first];

    for (int i = first + 1; i < n; i++) {
        mp[i + 1] = LONG_LONG_MIN;

        unordered_map<ll, ll> new_mp(mp);
        for (auto &[k, vv]: mp) {
            auto it = mp.find(k + 1);
            if (it != mp.end()) {
                if (vv + v[i] > it->second && vv >= 0) {
//                    mp[k + 1] = vv + v[i];
                    new_mp[k + 1] = vv + v[i];
                }
            }
        }
        mp = new_mp;
//        for (auto[k, v]: mp) {
//            cout << "[" << k << ", " << v << "] ";
//        }
//        cout << endl;
    }

    ll maxx = LONG_LONG_MIN;
    for (auto[k, v]: mp) {
        if (k > maxx && v >= 0) {
            maxx = k;
        }
    }
    cout << max(0ll, maxx - first) << endl;
}
