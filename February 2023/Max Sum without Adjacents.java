/*
Given an array Arr of size N containing positive integers. Find the maximum sum of a subsequence such that no two numbers in the sequence should be adjacent in the array.
Example 1:
Input:
N = 6
Arr[] = {5, 5, 10, 100, 10, 5}
Output: 110
Explanation: If you take indices 0, 3
and 5, then Arr[0]+Arr[3]+Arr[5] =
5+100+5 = 110.
Example 2:
Input:
N = 4
Arr[] = {3, 2, 7, 10}
Output: 13
Explanation: 3 and 10 forms a non
continuous  subsequence with maximum
sum.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findMaxSum() which takes the array of integers arr and n as parameters and returns an integer denoting the answer. It is guaranteed that your answer will always fit in the 32-bit integer.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ N ≤ 106
1 ≤ Arri ≤ 107
*/

class Solution {
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    int findMaxSum(int arr[], int n) {
        // code here
        // int[] dp = new int[n];
        int ans=0,max=0,max1=0;
        // max -> it Store maximum sebsequence sum before of before current index.
	    // max1 -> it store maximum sebsequence sum before current index.
        for(int i=0;i<n;i++) {
            // dp[i]=arr[i];
            // for(int j=0;j<i-1;j++) {
            //     dp[i] = Math.max(dp[i],dp[j]+arr[i]);
            // }
            // ans=Math.max(ans,dp[i]);
            int val = arr[i]+max;
            max = Math.max(max,max1);
            max1 = Math.max(max1,val);
            ans = Math.max(ans,val);
        }
        return ans;
    }
}
