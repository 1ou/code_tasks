#include <bits/stdc++.h>

//https://codeforces.com/contest/1207/problem/C

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
//#ifdef _DEBUG
    freopen("/home/toxa/Work/codeforces/1207/input.txt", "r", stdin);
	freopen("/home/toxa/Work/codeforces/1207/output.txt", "w", stdout);
//#endif
	
	int t;
	cin >> t;

    for (int i = 0; i < t; ++i) {
        long n, a, b;
        string s;
        cin >> n >> a >> b;
        cin >> s;

        int floor = 1;
        int stolb = 1;
        int gaz = 0;

        for (int k = 0; k < n; k++) {
            if (a <= b) { // up
                if (s[k] == '0') {
                    stolb += floor;
                    gaz += floor == 1 ? 1 : 2;
                    floor = 1;
                } else {
                    gaz += floor == 2 ? 1 : 2;
                    stolb += 2;
                    floor = 2;
                }
            } else { // down

            }
        }

        if (a <= b) {
            stolb += 1;
            gaz += 2;
        }

        int y = 0;
    }

    return 0;
}
