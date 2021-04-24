#include <bits/stdc++.h>
#include <algorithm>
#include <vector>

#define ll long long

using namespace std;

int main() {
    //freopen("input.txt", "r", stdin);

    ll t;
    cin >> t;
    while (t-- > 0) {
        int n, m;
        cin >> n >> m;
        vector<vector<ll>> matrix(n, vector<ll>(m, 0));
        vector<pair<ll, int>> v;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ll tok;
                cin >> tok;
                v.emplace_back(tok, i);
            }
        }

        sort(v.begin(), v.end());
        vector<ll> itr(n, 0);
        for (int i = 0; i < m; i++) {
            matrix[v[i].second][i] = v[i].first;
        }

        for (int i = m; i < v.size(); i++) {
            while(matrix[v[i].second][itr[v[i].second]] != 0) {
                itr[v[i].second]++;
            }
            matrix[v[i].second][itr[v[i].second]] = v[i].first;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cout << matrix[i][j] << " ";
            }
            cout << endl;
        }
    }
}
