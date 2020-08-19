#include <bits/stdc++.h>

#define ll long long
using namespace std;

/*
10
6 10 4 10 2 8 9 2 7 7
*/
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    vector<ll> arr(n);
    ll s = 0;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    for (int i = 0; i < n - 1; i++) {
        ll diff = arr[i+1] - arr[i];
        if (diff < 0) {
            arr[i+1] = arr[i];
            s += diff * -1;
        }
    }


    cout << s << "\n";
}
