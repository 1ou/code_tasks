#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
    //freopen("input.txt", "r", stdin);
//
    ll t, n, k;

    cin >> t;
    while (t-- > 0) {
        cin >> n >> k;
        string s;
        cin >> s;
        int f = s.find_first_of('*');
        int l = s.find_last_of('*');
        if (l == f) {
            cout << "1\n";
            continue;
        }

        s[f] = 'x';
        s[l] = 'x';
        int numb = 2;
        for (int i = f; i < l; i++) {
            int c = 0;
            while (i + k < l && c < k && s[i + k - c] != '*') {
                c++;
            }
            if (l - i <= k) {
                break;
            }
            s[i + k - c] = 'x';
            i = i + k - c - 1;
            numb++;
        }
//        cout << s << endl;
        cout << numb << endl;
    }
}
