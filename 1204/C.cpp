#include <bits/stdc++.h>
#include <algorithm>

using namespace std;

int main() {
//#ifdef _DEBUG
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
//#endif

	int n;
	cin >> n;
	cout << n << endl;
	int** a = new int*[n];
	for(int i = 0; i < n; ++i)
		a[i] = new int[n];

	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		for (int k = 0; k < s.size(); k++) a[i][k] = (int) s[k] - 48;
	}
		
	/*for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << a[i][j];
		}
		cout << endl;
	}*/
	
	int k;
	cin >> k;
	int *v = new int[k];
	for (int i = 0; i < k; ++i) cin >> v[i];
	
	for (int i = 0; i < k - 1; ++i) {
		if (a[v[i+1]-1][v[i+1]-1] == 1) v[i+1] = 0;
	}
	
	int s = 0;
	for (int i = 0; i < k; i++) {
		if (v[i] != 0) { s++; cout << v[i] << " "; }
	}
	return 0;
}
