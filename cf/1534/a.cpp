#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
    //freopen("input.txt", "r", stdin);

    ll t, n, m;

    cin >> t;
    while (t-- > 0) {
        cin >> n >> m;
        vector<vector<char>> v(n, vector<char>(m, ' '));
        vector<vector<char>> f(n, vector<char>(m, ' '));
        vector<vector<char>> s(n, vector<char>(m, ' '));
        // vector<vector<bool>> vis(n, vector<bool>(m, false));
        for (int i = 0; i < n; i++) {
          string s;
          cin >> s;
          for (int j = 0; j < m; j++) {
            v[i][j] = s[j];
          }
        }
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            if (v[i][j] == '.') {
              if ((i + j) % 2 == 0) {
                f[i][j] = 'W';
                s[i][j] = 'R';
              } else {
                  f[i][j] = 'R';
                  s[i][j] = 'W';
              }
            } else {
              f[i][j] = v[i][j];
              s[i][j] = v[i][j];
            }
          }
        }

        // cout << endl;
        //           for (int i = 0; i < n; i++) {
        //             for (int j = 0; j < m; j++) {
        //               cout << f[i][j];
        //             }
        //             cout << endl;
        //           }
        //
        //           cout << endl;
        //                     for (int i = 0; i < n; i++) {
        //                       for (int j = 0; j < m; j++) {
        //                         cout << s[i][j];
        //                       }
        //                       cout << endl;
        //                     }
        //                     cout << endl;

        bool t1 = true;
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            if (i > 0 && f[i - 1][j] == f[i][j]) {
              t1 = false;
            }
            if (i < n - 1 && f[i + 1][j] == f[i][j]) {
              t1 = false;
            }
            if (j > 0 && f[i][j - 1] == f[i][j]) {
              t1 = false;
            }
            if (j < m - 1 && f[i][j + 1] == f[i][j]) {
              t1 = false;
            }
          }
        }
        bool t2 = true;
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            if (i > 0 && s[i - 1][j] == s[i][j]) {
              t2 = false;
            }
            if (i < n - 1 && s[i + 1][j] == s[i][j]) {
              t2 = false;
            }
            if (j > 0 && s[i][j - 1] == s[i][j]) {
              t2 = false;
            }
            if (j < m - 1 && s[i][j + 1] == s[i][j]) {
              t2 = false;
            }
          }
        }
        if (t1 || t2) {
          cout << "YES" << endl;

          if (t1) {
            for (int i = 0; i < n; i++) {
              for (int j = 0; j < m; j++) {
                cout << f[i][j];
              }
              cout << endl;
            }
          } else if (t2) {
              for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                  cout << s[i][j];
                }
                cout << endl;
              }
          }
        } else {
          cout << "NO\n";
        }
    }
}
