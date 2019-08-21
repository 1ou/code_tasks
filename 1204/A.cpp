#include <bits/stdc++.h>

using namespace std;

int main() {
#ifdef _DEBUG
	freopen("input.txt", "r", stdin);
//	freopen("output.txt", "w", stdout);
#endif
	
	string bin;
    cin >> bin;
   
    unsigned long long v = bitset<64>(bin).to_ullong();

    // cout << "v " << v << endl;
    if (v <= 1) {cout << "0"; return 0;}
    if (v <= 3) {cout << "1"; return 0;}
    long h = static_cast<long>(std::log(v) / std::log(4));
    if (v != pow(4, h)) h++;
    cout << h;
	
	return 0;
}
