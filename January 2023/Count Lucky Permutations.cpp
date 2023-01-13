#include<iostream>
#include<vector>
using namespace std;

// User function Template for C++

class Solution {
  public:
    long long int luckyPermutations(int N, int M, vector<int> arr,
                                    vector<vector<int>> graph) {
       vector<vector<long long int>> dp(N, vector<long long int>(1 << N, 0));

        for (int i = 0; i < N; i++) {

            dp[i][1 << i] = 1;

        }

        vector<vector<int>> adj(N, vector<int>(N, 0));

        for (vector<int> edge : graph) {

            adj[edge[0] - 1][edge[1] - 1] = 1;

            adj[edge[1] - 1][edge[0] - 1] = 1;

        }

        for (int b = 1; b < (1 << N); b++) {

            for (int i = 0; i < N; i++) {

                if ((1 & (b >> i))) {

                    for (int j = 0; j < N; j++) {

                        if (j != i && arr[j] != arr[i] &&

                            (1 & (b >> j)) && adj[arr[i]-1][arr[j] - 1]) {

                            dp[i][b] += dp[j][b ^ (1 << i)];

                        }
                    }
                }
            }
        }
        long long int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += dp[i][(1 << N) - 1];
        }

        return ans;
    }
};
