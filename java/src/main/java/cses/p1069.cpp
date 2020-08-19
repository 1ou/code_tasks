#include <bits/stdc++.h>

#define ll long long
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    string s;
    cin >> s;
    char prev = s[0];
    int c = 1;
    int max = 0;
    for (int i = 1; i < s.length(); i++) {
        if (prev == s[i]) {
            max = std::max(max, ++c);
        } else {
            c = 1;
        }
        prev = s[i];
    }
    if (max == 0) max = 1;
    cout << max << "\n";
}
