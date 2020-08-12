#include <bits/stdc++.h>

//https://codeforces.com/contest/1230/problem/A

using namespace std;

int main() {
    //freopen("/home/toxa/Work/codeforces/1228/input.txt", "r", stdin);

    long l, x = -1, r;
    cin >> l >> r;

    while (l <= r) {
        std::map<char, int> map;
        string s = to_string(l);
        bool f = false;
        for (int i = 0; i < s.size(); ++i) {
            if (map.find(s[i]) == map.end()) {
                map.insert(make_pair(s[i], true));
            } else {
                f = true;
                break;
            }
        }
        if (!f) {
            cout << s;
            return 0;
        }
        l++;
    }

    cout << x;
    return 0;
}