#include <bits/stdc++.h>

//https://codeforces.com/contest/1230/problem/B

using namespace std;

void print (vector<vector<int>> a) {
    for (int i = 0; i < a.size(); ++i) {
        for (int j = 0; j < a[i].size(); ++j) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

int main() {
    freopen("/home/toxa/Work/codeforces/1228/input.txt", "r", stdin);

    long h, w;
    cin >> h >> w;
    vector<long> r(h);
    for (int i = 0; i < h; ++i) {
        cin >> r[i];
    }

    vector<long> c(w);
    for (int i = 0; i < w; ++i) {
        cin >> c[i];
    }

    vector<vector<int>> v(h);

    for (int i = 0; i < h; ++i) {
        v[i] = vector<int>(w);
        for (int j = 0; j < w; ++j)
            v[i][j] = -1;
    }

    int sum = 1;
    for (int i = 0; i < h; ++i) {
        for (int j = 0; j < w; ++j) {
            if (i <= r[i] || j <= c[j]) {
                v[i][j] = 1;
            } else {
                sum *= 2;
                sum %= 1000000007;
            }
        }
    }
    print(v);

    cout << endl << sum << endl;

    return 0;
}