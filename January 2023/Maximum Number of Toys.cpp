class Solution{
public:
    int solve(vector<int>& q, vector<long long>& sum, vector<vector<int>>& arr, unordered_map<int,int>& newInd) {
        long long val=q[0];
        int cnt=0, s=0, e=sum.size()-1;
        while(s<=e) {
            int mid = s+(e-s)/2;
            if(sum[mid] <= val) {
                cnt = mid+1;
                s = mid+1;
            }
            else e = mid-1;
        }
        int ans=0;
        unordered_set<int> st;
        long long curSum=val-sum[cnt-1];
        for(int i=2;i<q.size();i++) {
            if(newInd[q[i]]<=cnt){
                curSum+=arr[newInd[q[i]]-1][0];
                ans--;
            } 
            st.insert(newInd[q[i]]);
        }
        for(int i=cnt;i<arr.size();i++){
            if(arr[i][0]>curSum) break;
            if(st.count(i+1)) continue;
            ans++;
            curSum-=arr[i][0];
        }
       return ans+cnt;
    } 
  vector<int> maximumToys(int N,vector<int> A,int Q,vector<vector<int>> q){
      // code here
      vector<vector<int>> arr;
      for(int i=0;i<A.size();i++) {
          arr.push_back({A[i], i});
      }
      sort(arr.begin(), arr.end());
      unordered_map<int,int> newInd;
      vector<long long> preSum(N);
      
      preSum[0] = arr[0][0];
      newInd[arr[0][1]+1] = 1;
      for(int i=1;i<N;i++) {
          preSum[i] = preSum[i-1] + arr[i][0];
          newInd[arr[i][1]+1] = i+1;
      }
      vector<int> ans(q.size());
      for(int i=0;i<q.size();i++) {
          int cnt = solve(q[i], preSum, arr, newInd);
          ans[i] = cnt;
      }
      return ans;
  }
};
