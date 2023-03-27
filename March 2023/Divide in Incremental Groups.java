/*
Given two integers N and K, the task is to count the number of ways to divide N into K groups of positive integers such that their sum is N and the number of elements in groups follows a non-decreasing order (i.e. group[i] <= group[i+1]).

Example 1:

Input:
N = 8
K = 4
Output:
5
Explanation:
There are 5 groups such that their sum is 8 
and the number of positive integers in each 
group is 4. The 5 groups are [1, 1, 1, 5], 
[1, 1, 2, 4], [1, 1, 3, 3], [1, 2, 2, 3] and 
[2, 2, 2, 2].
Example 2:

Input: 
N = 4
K = 3
Output:
1
Explanation: 
The only possible grouping is {1, 1, 2}. Hence,
the answer is 1 in this case.
Your Task:
Complete the function countWaystoDivide() which takes the integers N and K as the input parameters, and returns the number of ways to divide the sum N into K groups.

Expected Time Complexity: O(N2*K)
Expected Auxiliary Space: O(N2*K)

Constraints:
1 ≤ K ≤ N ≤ 100

*/

class Solution {
    public int calculate(int pos, int prev, int left, int K, int[][][] dp) {
        if (pos == K) {
            if (left == 0)
                return 1;
            else
                return 0;
        }
        if (left == 0) return 0;
        if (dp[pos][prev][left] != -1) return dp[pos][prev][left];

        int answer = 0;
        for (int i = prev; i <= left; i++) {
            answer += calculate(pos + 1, i, left - i, K, dp);
           
        }

        return dp[pos][prev][left] = answer;
    }
    int countWaystoDivide(int N, int K) {
        int dp[][][] = new int[K + 1][N + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return calculate(0, 1, N, K, dp);
    }
};
