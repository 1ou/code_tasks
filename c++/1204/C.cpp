#include <bits/stdc++.h>

using namespace std;

/*
 * https://codeforces.com/contest/1204/problem/C
 */

void print(int *a, int size) {
    for(int i = 0; i < size; ++i) {
        if (a[i] != 0) {
            cout << a[i] << " ";
        }
    }
}

void print(int **a, int size) {
    for(int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

int main() {
//#ifdef DEBUG
	freopen("/home/toxa/Work/codeforces/1204/input.txt", "r", stdin);
	freopen("/home/toxa/Work/codeforces/1204/output.txt", "w", stdout);
//#endif

	int n;
	cin >> n;
	int** a = new int*[n];
	for(int i = 0; i < n; ++i)
		a[i] = new int[n];

	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;

		for (int k = 0; k < s.size(); k++) {
            int v = (int) s[k] - 48;
		    a[i][k] = v == 0 ? INT16_MAX : v;
		}
	}

	int k;
	cin >> k;
	int *v = new int[k];
	for (int i = 0; i < k; ++i) cin >> v[i];

	//print(a, n);
	for (int k = 0; k < n; ++k)
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				a[i][j] = min(a[i][j], a[i][k] + a[k][j]);
   // print(a, n);

    int *answ = new int[k];
    for (int i = 0; i < k; ++i) answ[i] = 0;
    answ[0] = v[0];

    int p = 0;
    int last_index = 0;
    for (int i = 1; i < k; ++i) {
        int Ai = v[last_index]-1;
        int Aj = v[i]-1;
        int Aij = a[Ai][Aj]; // distance

        int Kij = 0, Ki = -1, Kj = -1; // distance
        for (int u = last_index; u < i; u++) {
            Ki = v[u]-1;
            Kj = v[u+1]-1;
            Kij += a[Ki][Kj];
        }

        if (v[last_index] == Kj + 1 || Aij < Kij) {
            answ[++p] = v[i-1];
            last_index = i-1;
        }
    }

    answ[++p] = v[k-1];
    int nz = 0;
    for (int i = 0; i < k; ++i)
        if (answ[i] != 0) nz += 1;

    cout << nz << endl;
    print(answ, k);

	return 0;
}
