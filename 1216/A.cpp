#include <bits/stdc++.h>

//https://codeforces.com/contest/1216/problem/A

using namespace std;


int main() {
    // freopen("/home/toxa/Work/codeforces/1216/input.txt", "r", stdin);

    int t;
    cin >> t;
    string v;
    cin >> v;

    int y = 0;
    for (int i = 0; i < t - 1; i += 2) {
        if (v[i] == v[i+1]) {
            if (v[i] == 'a') {
                v[i] = 'b';
                y++;
            } else {
                v[i] = 'a';
                y++;
            }
        }
    }

    cout << y << endl;
    cout << v << endl;
    return 0;
}