#include <bits/stdc++.h>
#include <algorithm>

using namespace std;

int main() {
#ifdef _DEBUG
	freopen("input.txt", "r", stdin);
//	freopen("output.txt", "w", stdout);
#endif
	
	int n;
	cin >> n;
	
	long sum = 0;
	for (int i = 1; i <= 2*n; i++) {
		sum += i;
	}
	
	//cout << "sum = " << sum << endl;	
	if (sum % 2 == 0) {
		cout << "NO" << endl;
		return 0;
	} 
	
	cout << "YES" << endl;
	vector<int> a(n*2+1);
	for (int i = 1; i <= 2*n; ++i) {
		if (i <= n) {
			if (i % 2 != 0) a[i] = 2*i-1;
			else a[i] = 2 * i;
		} else {
			if (i % 2 != 0) a[i] = 2*i - 2*n - 1;
			else a[i] = 2*i - 2*n;
		}
	}		
	
	for (int i = 1; i <= 2*n; i++)
		cout << a[i] << " ";
	
	return 0;
}
