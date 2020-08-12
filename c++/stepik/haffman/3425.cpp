#include <bits/stdc++.h>

//https://stepik.org/lesson/13239/step/5?unit=3425

using namespace std;

int main() {
    string n;
    cin >> n;

    string res = "";


    std::map<char, int> tt;

    int k = 0;
    for (int i = 0; i < n.size(); ++i) {
        tt.insert(make_pair(n[i], ++k));
    }

    int max = 0;
    char key;
    for (auto a = tt.begin(); a != tt.end(); a++) {
        if (a->second > max) {
            max = a->second;
            key = a->first;
        }
    }


    std::map<char, string> wordMap;

    string ins = "0";
    k = 0;
    for (int i = 0; i < n.size(); ++i) {
        if (wordMap.find(n[i]) == wordMap.end()) {
            if (key == n[i] && max != 1) {
                ins = ins.substr(0, ins.size() -1);
            } else if (max == 1) {
                ins = "0";
            }
            wordMap.insert(make_pair(n[i], ins));
            ins = string("1").append(ins);
            k++;
        }

        auto v = wordMap.find(n[i])->second;
        res = res.append(v);
    }

    cout << k << " " << res.size() << endl;
    for (auto a = wordMap.begin(); a != wordMap.end(); a++) {
        cout << a->first << ": " << a->second << "\n";
    }

    cout << res;
    return 0;
}