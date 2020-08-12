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
	vector<long long> a(n);
	for (int i = 0; i < n; ++i) {
		cin >> a[i];
	}
	
	long long sum = 0;
	int amount_minus = 0;
	int amount_zero = 0;
	for (int i = 0; i < n; ++i) {
		if (a[i] > 0) {
			sum += a[i] - 1;
		}
		else if (a[i] < 0) {
			sum += -1 - a[i];
			amount_minus += 1;
		} else if (a[i] == 0) {
			amount_zero += 1;
		}
	}
	//cout << "zero " << amount_zero << endl;
	//cout << "sum " << sum << endl;
	//cout << "amount_minus " << amount_minus << endl;

	if (amount_zero > 0) {
		sum += amount_zero;
	} else {
		if (amount_minus % 2 != 0) sum += 2;
	}
	
	cout << sum;
	
	return 0;
}
