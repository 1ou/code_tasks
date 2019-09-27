#include <bits/stdc++.h>

//https://codeforces.com/contest/1230/problem/C

using namespace std;

void print (vector<vector<int>> a) {
    for (int i = 0; i < a.size(); ++i) {
        for (int j = 0; j < a[i].size(); ++j) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

int main() {
   // freopen("/home/toxa/Work/codeforces/1230/input.txt", "r", stdin);

    int n, m;
    cin >> n >> m;
    vector<vector<int>> adj(static_cast<unsigned long>(n+1));

    if (n <= 6 || m == 0) {
        cout << m; return 0;
    }

    for (int i = 0; i < m; ++i) {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    int sum = 0;
    for (int i = 1; i < 7; i++)
    {
        for (int j = i + 1; j <= 7; j++)
        {
            vector<bool> vis(8, false);
            int cnt = 0, u = 0, v = 0;
            for (; u < adj[i].size(); u++)
                vis[adj[i][u]] = true;
            for (; v < adj[j].size(); v++)
                if (!vis[adj[j][v]])
                    vis[adj[j][v]] = true;
            for (int k = 1; k <= 7; k++)
                if (vis[k])
                    cnt++;
            sum = max(sum, m - u - v + cnt);
        }
    }
    cout << sum << endl;
    return 0;
}