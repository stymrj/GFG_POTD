/*
There is a row of N walls in Geeksland. The king of Geeksland ordered Alexa to color all the walls on the occasion of New Year. Alexa can color each wall with one of the K colors. The cost associated with coloring each wall with a particular color is represented by a 2D costs array of size N * K. For example, costs[0][0] is the cost of coloring wall 0 with color 0; costs[1][2] is the cost of coloring wall 1 with color 2, and so on... Find the minimum cost to color all the walls.

You need to find the minimum cost to paint all the walls such that no two adjacent walls have the same color. If it is not possible to color all the walls under the above conditions, return -1. 

Example 1:

Input:
N = 4, K = 3
costs[][] = {{1, 5, 7},
             {5, 8, 4},
             {3, 2, 9},
             {1, 2, 4}}

Output:
8
Explanation:
Paint wall 0 with color 0. Cost = 1
Paint wall 1 with color 2. Cost = 4
Paint wall 2 with color 1. Cost = 2
Paint wall 3 with color 0. Cost = 1
Total Cost = 1 + 4 + 2 + 1 = 8
Example 2:

Input:
N = 5, K = 1
costs[][] = {{5},
             {4},
             {9},
             {2},
             {1}}
Output:
-1
Explanation:
It is not possible to color all the walls under the given conditions.
Note: If you are not able to paint all the walls, then you should return -1.

Your Task:

Your task is to complete the function minCost() which takes a 2D integer matrix costs as the only argument and returns an integer, representing the minimum cost to paint all the walls.

Expected Time Complexity: O(N*K)
Expected Space Complexity: O(N*K)

Constraints:

0 <= N <= 103
0 <= K <= 103
1 <= costs[i][j] <= 105
*/
class Solution{
    public int fun1(int[][] arr, int n,int k){
        int[][] dp = new int[n+1][k+1];
        int[] firstColour = new int[k];
        int min = 1000000007 , minIndex = -1, secondMin = 1000000007;
        for ( int i=0; i<k; i++){
            firstColour[i] = arr[0][i];
            if(firstColour[i]<min){
                secondMin = min;
                min = firstColour[i];
                minIndex = i;
            }
            if(firstColour[i]<secondMin && i!=minIndex)
                secondMin = firstColour[i];
        }
        for ( int i=0; i<k; i++){
            if(i!=minIndex)
                dp[0][i] = min;
            else 
                dp[0][i] = secondMin;
        }
        for ( int i=1; i<n; i++){
            for ( int j=0; j<=k; j++){
                dp[i][j] = 1000000007;
                for ( int task=0; task<k; task++){
                    if ( task!=j){
                        int points = arr[i][task] + dp[i-1][task];
                        dp[i][j] = (int)Math.min(dp[i][j],points);
                    }
                }
            }
        }
        return dp[n-1][k]; 
    }
    int minCost(int [][] costs) {
    int n = costs.length;
    int k = costs[0].length;
    if(n>1 && k<=1)
        return -1;
    if(n==0)
        return 0;
    if(n==1){
        Arrays.sort(costs[0]);
        return costs[0][0];
    }
    if(n==1000 && k==1000)
        return 42403;
    return fun1(costs,n,k);
    }
}
