#include <cmath>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool isRectangular(vector<double> v) {
    sort(v.begin(), v.end());
    return (v[2] == sqrt(v[1]*v[1] + v[0]*v[0]));
}

double distance(pair<long, long> p1, pair<long, long> p2) {
    return sqrt(pow(p1.first - p2.first, 2) + pow(p1.second - p2.second, 2));
}

int main() {
    freopen("/home/toxa/Work/codeforces/vlada/input.txt", "r", stdin);

    int n;
    cin >> n;
    vector<pair<long, long>> points(n);

    for (int i = 0; i < n; ++i) {
        long x, y;
        cin >> x >> y;
        points[i] = make_pair(x, y);
    }

    int answer = 0;

    // amount of compare size - 2, with first,size - 2 - 1, with second...
    int k1 = 0;
    int k2 = 1;
    int k3 = 2;

    while (!points.empty()) {
        cout << "l" << endl;
        pair<long, long> a = points[k1];
        pair<long, long> b = points[k2];
        pair<long, long> c = points[k3];

        vector<double> v;
        v.push_back(distance(a, b));
        v.push_back(distance(a, c));
        v.push_back(distance(b, c));

        if (isRectangular(v)) {
            answer++;
        }

        k3++;

        if (k3 == points.size()) {
            k2++;
            k3 = k2 + 1;
            if (k2 == points.size() - 1) {
                k1++;
                k2 = k1 + 1;
                k3 = k2 + 1;
                if (k1 == points.size() - 2) {
                    break;
                }
            }
        }
    }

    cout << answer;

    return 0;
}