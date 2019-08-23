#include <bits/stdc++.h>

//https://codeforces.com/contest/1207/problem/A

using namespace std;


int main() {
//#ifdef _DEBUG
//	freopen("/home/toxa/Work/codeforces/1207/input.txt", "r", stdin);
//	freopen("/home/toxa/Work/codeforces/1207/output.txt", "w", stdout);
//#endif
	
	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		int b, f, p;
		cin >> b >> p >> f;

		int h, c;
		cin >> h >> c;

		long sum = 0;

		if (h >= c && b >= 2) {
		    if (b / 2 > p) {
                sum += min(b / 2, p) * h;
                b -= p * 2;
                sum += min(b / 2, f) * c;
            } else {
		        sum += b / 2 * h;
		    }
		} else if (h < c && b >= 2){
		    if (b / 2 > f) {
                sum += f * c;
                b -= f * 2;
                sum += min(b / 2, p) * h;
            } else {
		        sum += b / 2 * c;
		    }
		}

		cout << sum << endl;

	}

	return 0;
}
