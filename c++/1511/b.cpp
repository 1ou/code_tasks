#include <bits/stdc++.h>

using namespace std;

int n, k;
int cur[26];
vector<int> path;

void dfs(int v) {
  while (cur[v] < k) {
    int u = cur[v]++;
    dfs(u);
    path.push_back(u);
  }
}

int main() {
  freopen("input.txt", "r", stdin);

  cin >> n >> k;
  dfs(0);
  cout << "a";
  for (int i = 0; i < n - 1; ++i) {
    cout << (char) (path[i % path.size()] + 'a');
  }
}
