#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {

//    freopen("input.txt", "r", stdin);

    ll t, n;

    cin >> t;
    while (t-- > 0) {
        cin >> n;
        vector<ll> v(n);
        for (int i = 0; i < n; i++) {
            cin >> v[i];
        }
        string ans;
        ll cnt = 6 * n / 2;
        for (int i = 0; i < n; i+=2) {
            ans += "1 " + std::to_string(i + 1) + " " + std::to_string(i + 2) + "\n";
            ans += "2 " + std::to_string(i + 1) + " " + std::to_string(i + 2) + "\n";
            ans += "1 " + std::to_string(i + 1) + " " + std::to_string(i + 2) + "\n";
            ans += "2 " + std::to_string(i + 1) + " " + std::to_string(i + 2) + "\n";
            ans += "1 " + std::to_string(i + 1) + " " + std::to_string(i + 2) + "\n";
            ans += "2 " + std::to_string(i + 1) + " " + std::to_string(i + 2) + "\n";
        }

        cout << cnt << endl;
        cout << ans;
    }
}
