#include <bits/stdc++.h>

//https://codeforces.com/contest/1230/problem/B

using namespace std;

int main() {
    //freopen("/home/toxa/Work/codeforces/1230/input.txt", "r", stdin);

    int n, k;
    cin >> n >> k;
    string s;
    cin >> s;

    if (k == 0) {
        cout << s;
        return 0;
    }

    if (n == k && n == 1) {
        cout << "0";
        return 0;
    }

    int i = 1;
    if (s[0] != '1') {
        k--;
        s[0] = '1';
    }

    while (k != 0 && i < n) {
        if (s[i] != '0') {
            k--;
            s[i] = '0';
        }
        i++;
    }

    cout << s;
    return 0;
}