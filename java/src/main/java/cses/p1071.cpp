#include <bits/stdc++.h>

#define ll long long
using namespace std;

/*
10
6 10 4 10 2 8 9 2 7 7
*/
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    while (n-- > 0) {
        ll y, x, d;
        cin >> y >> x; // 2, 3
        ll z = max(y, x); // 3
        ll z2 = (z-1)*(z-1); // 4
        if (z%2) {
            if (z == y) {
                d = z2+x;
            } else {
                d = z2 + 2 * z - y;
            }
        } else {
            if (z == x) { // no
                d = z2 + y;
            } else {
                d = z2 + 2 * z - x; // 4 + 2 * 3 - 2 = 8
            }
        }
        cout << d << endl;
    }
}
