/*
You are given a 2D integer array ranges whose length is n where ranges[i]=[starti, end,coinsi] means all integers from starti to endi inclusive starti and endi are present and we get coinsi amount of coins when we select this ith range. You can select at most two intervals so as to collect maximum coins but if you select two ranges then those two ranges should not intersect or overlap but can touch each other.

Note: You can select at max 2 ranges and they should not intersect with each other but they can touch themselves.

Example 1:

Input :
n=3
ranges={{1,3,4},{2,3,5},{3,4,2}}
Output: 7
Explanation:
We can see that we can take 2nd and 
3rd ranges as they are not intersecting
(only touching) we get maximum Coins by 
taking these ranges(5+2=7).
Example 2:

Input :
n=5
ranges={{1,3,4},{2,3,5},{3,4,2},{5,8,9},{2,8,10}}
Output: 14
Explanation:
We can see that we can take 2nd and 
4th ranges as they are not intersecting 
we get maximum Coins(5+9=14) by taking 
these ranges.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxCoins() which takes an integer n(length of ranges), integer 2D integer array ranges, and you have to return the maximum number of coins you got after selecting at most two ranges that are not intersecting.

Expected Time Complexity: O(nlogn)
Expected Space Complexity: O(n)

Constraints:
1<=n<=105
0<=ranges[i][0]<=ranges[i][1]<=109
0<=ranges[i][2](coins)<=106
The sum of n over all test cases won't exceed 106

*/


class Solution{
    static int dp[][];
    public static int maxCoins(int n,int ranges[][])
    {
        Arrays.sort(ranges,new Comparator<int[]>(){
            public int compare(int first[],int second[]){
                if(first[0]==second[0])
                return first[1]-second[1];
                else
                return first[0]-second[0];
            }
        });
        dp=new int[n+1][3];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(ranges,0,0);
    }
    public static int fun(int ranges[][],int i,int taken)
    {
        
        if(i>=ranges.length || taken>1) return 0;
        if(dp[i][taken]!=-1){
            return dp[i][taken];
        }
        int ans=fun(ranges,i+1,taken);
        int new_idx=(int)(1e9),l=i+1,r=ranges.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(ranges[mid][0]>=ranges[i][1]){
                new_idx=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        ans=Math.max(ans,fun(ranges,new_idx,taken+1)+ranges[i][2]);
        return dp[i][taken]=ans;
    }
}
