#include <bits/stdc++.h>

//https://codeforces.com/contest/1230/problem/A

using namespace std;

int main() {
    //freopen("/home/toxa/Work/codeforces/1230/input.txt", "r", stdin);

    vector<int> v(4);

    cin >> v[0] >> v[1] >> v[2] >> v[3];
    sort(v.begin(), v.end());

    if (v[0] + v[3] == v[1] + v[2]) {
        cout << "YES";
        return 0;
    } else if (v[0] == v[1] + v[2] + v[3]){
        cout << "YES";
        return 0;
    } else if (v[0] + v[1] + v[2] == v[3]){
        cout << "YES";
        return 0;
    } else {
        cout << "NO";
        return 0;
    }
}