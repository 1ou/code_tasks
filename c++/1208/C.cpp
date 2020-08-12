#include <bits/stdc++.h>

//https://codeforces.com/contest/1208/problem/C

using namespace std;

void print(vector<vector<long>> v) {
    for (int i = 0; i < v.size(); ++i) {
        for (int j = 0; j < v[i].size(); ++j) {
            cout << v[i][j] << " ";
        }
        cout << "\n";
    }
}

int main() {
    //freopen("/home/toxa/Work/codeforces/1208/input.txt", "r", stdin);

    int n;
    cin >> n;

    vector<vector<long>> v(n);
    for (int i = 0; i < n; ++i) {
        v[i] = vector<long>(n);
    }

    int q = n*n / 4 - 1;

    int fill = 0;
    for(int i = 0; i < n/2; i++){
        for(int j = 0; j < n/2; j++){

            v[i][j]              = 4*fill + 1;   // 1st quadrant
            v[i][j + n/2]        = 4*fill + 2;   // 2nd quadrant
            v[i + n/2][j]        = 4*fill + 3;   // 3rd quadrant
            v[i + n/2][j + n/2]  = 4*fill;       // 4th quadrant

            fill++;

        }
    }

    print(v);
    return 0;
}
// 0, 1 = 0
// 2, 3 = 1
// 4, 5 = 2
// 6, 7 = 3

// 0