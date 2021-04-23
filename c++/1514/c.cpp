#include <bits/stdc++.h>

using namespace std;

int n;

int gcd(int x, int y) {
    int max = std::max(x, y);
    int min = std::min(x, y);
    while (max != 0 && min != 0) {
        int tmp = min;
        min = max % min;
        max = tmp;
    }
    return max;
}

int main() {
    //  freopen("input.txt", "r", stdin);
    cin >> n;
    std::vector<int> vec;
    long long p = 1;
    for (int i = 1; i < n; i++) {
        if (gcd(i, n) == 1) {
            p = p * i % n;
            vec.push_back(i);
        }
    }
    if (p == 1) {
        cout << vec.size() << endl;
        for (int i = 0; i < vec.size(); i++) {
            cout << vec[i] << " ";
        }
        cout << endl;
    } else {
        cout << vec.size() - 1 << endl;
        for (int i = 0; i < vec.size(); i++) {
            if (vec[i] != p) {
                cout << vec[i] << " ";
            }
        }
        cout << endl;
    }
}
