#include <bits/stdc++.h>

using namespace std;

int n, k;

int main() {
//    freopen("input.txt", "r", stdin);
    cin >> k;

    while (k-- > 0) {
        cin >> n;

        bool t = true;
        for (int i = 0; i < n; i++) {
            int a;
            cin >> a;
            int tmp = sqrt(a);
            if (tmp * tmp != a) {
                t = false;
            }
        }
        if (t) {
            cout << "NO\n";
        } else {
            cout << "YES\n";
        }
    }
}
