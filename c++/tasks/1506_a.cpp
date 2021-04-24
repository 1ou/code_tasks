#include <bits/stdc++.h>

using namespace std;

int t;

int main() {
//    freopen("input.txt", "r", stdin);

    cin >> t;
    while (t-- > 0) {
        long long n, m, x;
        cin >> n >> m >> x;
        long long column = (x - 1) / n + 1;
        long long row = (x % n);
        if (row == 0) row = n;
//        cout << "x - " << x << " column - " << column << " row - " << row << endl;
        cout << (row - 1) * m + column << endl;
    }
}
