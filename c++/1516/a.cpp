#include <bits/stdc++.h>

using namespace std;

int t, n, k;

int main() {
    freopen("input.txt", "r", stdin);
    cin >> t;

    while (t-- > 0) {
        cin >> n >> k;
        std::vector<int> v(n);
        for (int i = 0; i < n; i++) {
            cin >> v[i];
        }
        int last = n - 1;
        int pos = 0;
        while (k > 0) {
            while (pos < n && v[pos] == 0) {
                pos++;
            }
            if (pos == last + 1) break;
            if (v[pos] > 0) {
                v[pos]--;
                v[last]++;
                k--;
            }
        }

        for (int i = 0; i < n; i++) {
            cout << v[i] << " ";
        }
        cout << endl;
    }
}
