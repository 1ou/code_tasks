#include <bits/stdc++.h>
#include <unordered_map>
#include <iterator>

using namespace std;

/*
5
5
1 4 3 7 10
3
1 1 1
4
6 2 5 3
2
2 4
1
1

1
3
1 1 1

1
4
6 2 5 3

*/
void solve() {
    int n;
    cin >> n;
    long long a[n];
	std::unordered_map<long long,int> freq;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        std::unordered_map<long long,int>::iterator it = freq.find(a[i]);
	    if (it != freq.end()) {
			it->second++;	// increment map's value for key 'c'
		}
		// key not found
		else {
			freq.insert(std::make_pair(a[i], 1));
		}
    }
    long long sum[n];
    sum[0] = a[0];

    long long ans = 0;
    for (int i = 1; i < n; i++) {
        sum[i] = sum[i-1] + a[i];
        //cout << sum[i] << " ";
    }
    //cout << "sum end" << endl;
    for (int i = 0; i < n - 1; i++) {
            if ((sum[i] & sum[i+1]) >= (sum[i] ^ sum[i+1])) {
              //  cout << a[i] << " " << a[i+1] << endl;
                ans++;
            }
    }

	for (auto &e: freq) {
	    if (e.second >= 2) {
            //cout << e.second << " ";
	        //ans+=e.second;
	    }
	}
    cout << endl << ans << '\n';
}

int main() {
    int t;
    cin >> t;
    while (t--)
        solve();
    return 0;
}
