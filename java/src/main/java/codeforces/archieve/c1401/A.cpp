#include <bits/stdc++.h>

#define ll long long
using namespace std;

/*
6
4 0
5 8
0 1000000
0 0
1 0
1000000 1000000
*/
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int a;
    cin >> a;
    for (int i = 0; i < a; ++i) {
        ll n, k;
        cin >> n >> k;
        if (n == k) {
            cout << endl << n - k << endl;
        } else {
            if (n >= k / 2) {
                cout << k << endl;
            } else {
                cout << k - n << endl;
            }
        }
    }
}
