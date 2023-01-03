class Solution {
  public:
    int removeStudents(int H[], int N) {
        vector<int> dp;
        dp.push_back(H[0]);
        for(int i = 1; i < N; i++){
            if(dp.back() < H[i]){
                dp.push_back(H[i]);
            }
            else{
                auto it = lower_bound(dp.begin(), dp.end(), H[i]) - dp.begin();
                dp[it] = H[i];
            }
        }
        return N - dp.size();
    }
};
