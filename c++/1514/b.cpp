#include <bits/stdc++.h>

using namespace std;

int t, n, k, mod = 1000000007;;

int main() {
//    freopen("input.txt", "r", stdin);
    cin >> t;

    while (t-- > 0) {
        cin >> n >> k;
        long long ans = 1;
        for (int i = 1; i <= k; i++) {
            ans = (ans * n) % mod;
        }
        cout << ans << endl;
    }
}
