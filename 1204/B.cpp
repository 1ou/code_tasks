#include <bits/stdc++.h>
#include <algorithm>

using namespace std;

int main() {
#ifdef _DEBUG
	freopen("input.txt", "r", stdin);
//	freopen("output.txt", "w", stdout);
#endif
	
	int n, r, l;
	cin >> n >> l >> r;
	int *arr = new int[n];
	
	long min = 0;
	long koef = 1;
	for (int i = 0; i < n; i++) {
		if (l <= n - i) { /*cout << min;*/ min += 1; }
		else {
			min += pow(2, koef);
			//cout << " koef " << koef << " min " << min;
			koef++;
		}
		//cout << endl;
	}
	
	int k = 0, i = n;
	long max = 0;
	while (r > 0 || i > 0) {
		if (r > 0) { max += pow(2, k); /* cout << " MAX " << max << " k " << k << endl;*/ k++; }
		else { max += pow(2, k - 1); /* cout << max << endl; */}
		r--;
		i--;
	}
	
	cout << min << " " << max;
	
	return 0;
}
