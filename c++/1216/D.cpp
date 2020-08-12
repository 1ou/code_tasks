#include <bits/stdc++.h>

//https://codeforces.com/contest/1216/problem/C

using namespace std;

long long gcd(const vector<long long>& num){
    if (num.size() == 0)
        return 0;
    if (num.size() == 1)
        return num[0];
    long long res = gcd(num[0],num[1]);
    for (auto i=2;i<num.size() && res!=1;i++)
        res = gcd(res,num[i]);
    return res;
}

int main() {
    //freopen("/home/toxa/Work/codeforces/1216/input.txt", "r", stdin);

    int n;
    cin >> n;
    vector<long long> a(n);
    long long min = LONG_LONG_MAX;
    long long max = LONG_LONG_MIN;

    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        if (a[i] > max) {
            max = a[i];
        }
        if (a[i] < min) {
            min = a[i];
        }
    }

    long long g = gcd(a);
    long long y = 0;
    long long z = 0;

    if (g < min) {
        z = 0;
    } else {
        z = g;
    }

    for (int i = 0; i < n; ++i) {
        if (g < min) {
            if (a[i] != max) {
                y++;
                z += max - a[i];
            }
        } else {
            if (a[i] != max) {
                if (a[i] % g == 0) {
                    y += (max - a[i]) / g;
                }
            }
        }
    }

    cout << y << " " << z;
    return 0;
}