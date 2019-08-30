#include <bits/stdc++.h>

//https://codeforces.com/contest/1213/problem/A

using namespace std;


int main() {
//    freopen("/home/toxa/Work/codeforces/1213/input.txt", "r", stdin);

    int t;
    cin >> t;

    for (int k = 0; k < t; ++k) {
        int n;
        cin >> n;
        vector<long> v(n);

        int bad_days = 0;
        for (int i = 0; i < n; ++i) {
            cin >> v[i];
        }

        long max = -INT32_MAX;
        long min = INT32_MAX;

        for (int i = n - 1; i >= 0; --i) {
            if (v[i] > max) {
                max = v[i];
            }
            if (v[i] > min) {
                bad_days++;
            }
            if (v[i] < min) min = v[i];
        }

        cout << bad_days << endl;
    }

    return 0;
}