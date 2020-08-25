#include <bits/stdc++.h>

#define ll long long
using namespace std;

/*
10
6 10 4 10 2 8 9 2 7 7
*/
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    ll n;
    cin >> n;
    ll s = n * ( 2 * 1 + (n - 1)) / 2;

//    cout << s << endl;
    map<ll, int> m;
    for (int i = 1; i <= n ; i++) {
           if (s % i == 0) {
                double foobar = ((s / i - i + 1) / 2.0);
//                cout << "n " << i << "f " << foobar << " " << endl;
                if (floor(foobar) == foobar && foobar != 0) {
//                    cout << "i " << i << endl;
                    m.insert(pair<ll,int>(i, 1));
                }
           }
    }
    if (m.size() > 0) {
        cout << "YES\n";
        map<ll, int>::iterator itr;
        cout << m.size() << endl;

        for (itr = m.begin(); itr != m.end(); ++itr) {
            cout << itr->first << " ";
        }
        cout << endl;

        cout << n - m.size() << endl;
        for (int i = 1; i <= n; i++) {
            if (m.find(i) == m.end()) {
                cout << i << " ";
            }
        }
    } else {
        cout << "NO";
    }
}
