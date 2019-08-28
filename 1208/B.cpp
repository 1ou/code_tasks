#include <bits/stdc++.h>

//https://codeforces.com/contest/1208/problem/B

using namespace std;


int main() {
    freopen("/home/toxa/Work/codeforces/1208/input.txt", "r", stdin);

    int t;
    cin >> t;

    vector<long> v(t);
    for (int i = 0; i < t; ++i) {
        cin >> v[i];
    }

    int l = - 1, r = -1;
    for (int i = 0; i < t - 1; i++) {
        if (v[i] == v[i+1]) {
            if (l == -1) l = i + 1;
            else r = i + 1;
        }
    }

    if (l == -1 && r == -1)
        cout << "0";
    else
        if (v[r] == v[l]) cout << to_string(r - l + 1); else cout << to_string(r - l);

    return 0;
}