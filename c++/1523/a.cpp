#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
//    freopen("input.txt", "r", stdin);

    ll t, n, m;

    cin >> t;
    while (t-- > 0) {
        cin >> n >> m;
        string str;
        cin >> str;
        while (m-- > 0) {
            string tmp = str;
            ll numberOfChanges = 0;
            for (int i = 0; i < n; i++) {
                if (str[i] == '0') {
                    if ((i - 1 >= 0 && str[i - 1] == '1') && (i + 1 < n && str[i + 1] == '0')) {
                        tmp[i] = '1';
                        numberOfChanges++;
                    } else if ((i - 1 >= 0 && str[i - 1] == '0') && (i + 1 < n && str[i + 1] == '1')) {
                        tmp[i] = '1';
                        numberOfChanges++;
                    } else if (i - 1 < 0 && (i + 1 < n && str[i + 1] == '1')) {
                        tmp[i] = '1';
                        numberOfChanges++;
                    } else if (i + 1 >= n && (i - 1 >= 0 && str[i - 1] == '1')) {
                        tmp[i] = '1';
                        numberOfChanges++;
                    } else {
                        tmp[i] = '0';
                    }
                } else {
                    tmp[i] = '1';
                }
            }
            str = tmp;
            if (numberOfChanges == 0) break;
        }
        cout << str << endl;
    }
}
