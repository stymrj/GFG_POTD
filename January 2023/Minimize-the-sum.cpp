class Solution {
public:
    int minimizeSum(int N, vector<int> arr) {
        // code here
        int sum = 0;
        multiset< int > st;
        for(int i = 0; i< N; i++) st.insert(arr[i]);
        while(st.size() >= 2){
         int mx1 =  *st.begin();
         st.erase(st.begin());
         int  mx2 = *(st.begin());
         st.erase(st.begin());
         sum+=(mx1+mx2);
         st.insert(mx1+mx2);
        }
        return sum;
    }
};
