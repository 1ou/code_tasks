#include <bits/stdc++.h>
#include <algorithm>

using namespace std;


int main() {
//#ifdef _DEBUG
//	freopen("/home/toxa/Work/codeforces/1203/input.txt", "r", stdin);
//	freopen("/home/toxa/Work/codeforces/1203/output.txt", "w", stdout);
//#endif
	
	int q;
	cin >> q;

	for (int k = 0; k < q; ++k) {
		int n;
		cin >> n;
		vector<int> a(static_cast<unsigned long>(4*n));

		for (int i = 0; i < 4*n; ++i) {
			cin >> a[i];
		}

        sort(a.begin(), a.end());

        long area = a[0] * a[4*n-1];
		bool f = true;
		for (int i = 1; i <= n; ++i) {
			if (!(a[2*i - 2] == a[2*i - 1] &&
				a[4*n - 2*i + 1] == a[4*n - 2*i] &&
				a[2*i - 2] * a[4*n -2*i + 1] == area)) {
				f = false;
				break;
			}
		}

		if (f)
		    cout << "YES" << endl;
		else
            cout << "NO" << endl;
	}

	return 0;
}
