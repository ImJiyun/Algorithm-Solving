#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

int N, cnt, maxCnt;
vector<int> adj[10001];  // 인접 리스트
bool visited[10001];

void dfs(int node) {
    visited[node] = true;

    for (int next : adj[node]) {
        if (!visited[next]) {
            cnt++;
            dfs(next);
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int M;
    cin >> N >> M;

    for (int i = 0; i < M; i++) {
        int to, from;
        cin >> to >> from;
        adj[from].push_back(to);
    }

    maxCnt = 0;
    vector<int> result;

    for (int i = 1; i <= N; i++) {
        memset(visited, false, sizeof(visited));
        cnt = 0;
        dfs(i);

        if (cnt > maxCnt) {
            maxCnt = cnt;
            result.clear();
            result.push_back(i);
        } else if (cnt == maxCnt) {
            result.push_back(i);
        }
    }

    for (int node : result) {
        cout << node << " ";
    }

    return 0;
}
