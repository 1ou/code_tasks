#include <bits/stdc++.h>

//https://codeforces.com/contest/1213/problem/A

using namespace std;


int main() {
    freopen("/home/toxa/Work/codeforces/1213/input.txt", "r", stdin);

    int t;
    cin >> t;
    vector<long> v(t);

    long long ct = 0;
    for (int i = 0; i < t; ++i) {
        cin >> v[i];
        if(v[i] & 1) ct++;
    }

    cout << min(ct, t - ct) << endl;

    return 0;
}