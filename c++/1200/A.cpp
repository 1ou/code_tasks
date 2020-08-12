#include <bits/stdc++.h>
#include <algorithm>

using namespace std;

int main() {
#ifdef _DEBUG
	freopen("input.txt", "r", stdin);
//	freopen("output.txt", "w", stdout);
#endif

	int *arr = new int[10];
	for (int i = 0; i < 10; ++i) arr[i] = 0;
	int n;
	cin >> n;
	
	char s[n];
	cin >> s;
	//cout << "str " << s << endl;
	
	for (int i = 0; i < n; ++i) {
		if (s[i] == 'L') {
			int j = 0;
			while (arr[j] != 0 && j < 10) j++;
			arr[j] = 1;
		} else if (s[i] == 'R') {
			int j = 9;
			while (arr[j] != 0 && j >= 0) j--;
			arr[j] = 1;
		} else {
			//cout << endl << "GET INT - " << (int) s[i] - 48 << endl; 
			arr[(int) s[i] - 48] = 0;
		}
		//cout << endl << s[i] << endl;
		//for (int i = 0; i < 10; ++i) cout << arr[i];
	}
	//cout << endl;
	for (int i = 0; i < 10; ++i) cout << arr[i];
	
	return 0;
}
