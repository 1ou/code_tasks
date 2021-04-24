#include <bits/stdc++.h>
#define ll long long
using namespace std;

ll n, t;

ll gcd(ll x, ll y) {
    ll max = std::max(x, y);
    ll min = std::min(x, y);
    while (max != 0 && min != 0) {
        ll tmp = min;
        min = max % min;
        max = tmp;
    }
    return max;
}
int main() {
//    freopen("input.txt", "r", stdin);

    cin >> t;
    while (t-- > 0) {
        cin >> n;
        while(true) {
            ll sum = 0;
            ll tmp = n;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (gcd(n, sum) != 1) {
                cout << n << endl;
                break;
            }

                n++;
        }
    }
}
