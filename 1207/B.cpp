#include <bits/stdc++.h>

//https://codeforces.com/contest/1207/problem/B

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
//    freopen("/home/toxa/Work/codeforces/1207/input.txt", "r", stdin);
//	freopen("/home/toxa/Work/codeforces/1207/output.txt", "w", stdout);
//#endif
	
	int x, y;
	cin >> x >> y;
    vector<vector<int>> a(x);
    vector<string> s(static_cast<unsigned long>(x * y));

    int k = 0;

    for (int i = 0; i < x; ++i) {
        a[i] = vector<int>(y);
    }

    vector<vector<int>> b(x);

    for (int i = 0; i < x; ++i) {
        b[i] = vector<int>(y);
        for (int j = 0; j < b[i].size(); ++j) b[i][j] = 0;

    }

    for (int i = 0; i < x; ++i)
        for (int j = 0; j < y; ++j) {
            cin >> a[i][j];
        }

    //print(a);
   // print(b);

    for (int px = 0; px < x - 1; px++) {
        for (int py = 0; py < y - 1; py++) {
            if (a[px][py] != 0 &&
                a[px+1][py] != 0 &&
                a[px][py+1] != 0 &&
                a[px+1][py+1] != 0) {
                b[px][py] = 1;
                b[px+1][py] = 1;
                b[px][py+1] = 1;
                b[px+1][py+1] = 1;
//                px += 2;
                s[k] = to_string(px + 1) + " " + to_string(py + 1);
                k++;
            }
        }
    }

    for (int i = 0; i < x; ++i) {
        for (int j = 0; j < y; ++j) {
            if (a[i][j] != b[i][j]) {
                cout << "-1";
                return 0;
            }
        }
    }
    cout << k << endl;
    for (int i = 0; i < s.size(); i++) {
        if (s[i].size() > 0)
            cout << s[i] << endl;
    }

    return 0;
}
