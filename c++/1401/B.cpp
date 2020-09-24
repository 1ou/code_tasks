#include<bits/stdc++.h>

using namespace std;

#define ll long long
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int t;
    cin >> t;
    while(t--) {
    	ll aZ, aO, aT;
 	ll bZ, bO, bT;
	cin >> aZ >> aO >> aT;
	cin >> bZ >> bO >> bT;
	
	ll ans = 0;
	if (aT >= bO) {
		ans += bO * 2;;
		aT -= bO;
		bO = 0;
	} else if (aT > 0){
		ans += bO;

	}
    }
}	
