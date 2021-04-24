#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
    //freopen("input.txt", "r", stdin);

    ll t, n;

    cin >> t;
    while (t-- > 0) {
        string a, b;
        cin >> a >> b;
        int maxx = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                int cnt = 0;
                while (a[i + cnt] == b[j + cnt] && i + cnt < a.size() && j + cnt < b.size()) cnt++;
                maxx = max(maxx, cnt);
            }
        }
        cout << a.size() + b.size() - 2 * maxx << endl;
    }
}
