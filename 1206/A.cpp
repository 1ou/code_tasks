#include <bits/stdc++.h>
#include <algorithm>

using namespace std;

bool contains(vector<int> v, int x) {
	return std::find(v.begin(), v.end(), x) != v.end();
}

int main() {
#ifdef _DEBUG
	freopen("input.txt", "r", stdin);
//	freopen("output.txt", "w", stdout);
#endif
	
	int n;
	cin >> n;
	vector<int> a(n);
	for (int i = 0; i < n; ++i) {
		cin >> a[i];
	}
	int m;
	cin >> m;
	vector<int> b(m);
	for (int i = 0; i < m; ++i) {
		cin >> b[i];
	}
	
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			int number = a[i] + b[j];
			if (!contains(a, number) && !(contains(b, number))) {
				cout << a[i] << " " << b[j] << endl;
				return 0;
			} 
		}
	}
	
	return 0;
}
