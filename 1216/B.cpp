#include <bits/stdc++.h>

//https://codeforces.com/contest/1216/problem/B

using namespace std;

int main() {
    freopen("/home/toxa/Work/codeforces/1216/input.txt", "r", stdin);

    int t;
    cin >> t;
    vector<long> v(t);
    map <int,int> map;
    for (int i = 0; i < t; ++i) {
        cin >> v[i];
    }

    vector<pair<int, int> > vp;
    for (int i = 0; i < t; ++i) {
        vp.push_back(make_pair(v[i], i));
    }

    sort(vp.begin(), vp.end(), std::greater<>());
    string answ = "";

    long x = 0, res = 0;
    for (int i = 0; i < t; ++i) {
        res += x * vp[i].first + 1;
        answ +=  to_string(vp[i].second + 1) + " ";
        x++;
    }

    cout << res << endl;
    cout << answ << endl;

    return 0;
}