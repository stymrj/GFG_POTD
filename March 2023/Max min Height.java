/*

Max min Height

You have a garden with n flowers lined up in a row. The height of ith flower is ai units. You will water them for k days. In one day you can water w continuous flowers (you can do this only once in a single day). Whenever you water a flower its height increases by 1 unit. You need to maximize the height of the smallest flower all the time.

Example 1:

Input:
N=6
K=2
W=3
a[]={2,2,2,2,1,1}
Output:
2
Explanation:
Water last three flowers for first day & 
first three flowers for second day.The 
new heights will be {3,3,3,3,2,2}
Example 2:

Input:
N=2
K=5
W=1
a[]={5,8}
Output:
9
Explanation:
For the first four days water the first flower then
water the last flower once.
Your Task: 
You don't need to read input or print anything. Your task is to complete the function maximizeMinHeight() which takes the array a[], its size N, integer K, and an integer W as input parameters and returns the maximum height possible for the smallest flower.

Expected Time Complexity: O(NLogN)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
1<=w<=N
1<=K<=105
1 <= a[i] <= 109
*/

class Solution{
    boolean isOK(int[] arr, int days, int cs, long h){
        int n = arr.length;
        long[] waterSupply = new long[n];
        if (arr[0] < h){
            waterSupply[0] = h - arr[0];
            days -= h - arr[0];
        }
        if (days < 0){
            return false;
        }
        for (int i = 1; i < n; i++){
            waterSupply[i] = waterSupply[i - 1];
            int actualHeight = arr[i];
            if (i >= cs){
                actualHeight += waterSupply[i] - waterSupply[i - cs];
            } else {
                actualHeight += waterSupply[i];
            }
            if (actualHeight < h){
                waterSupply[i] += h - actualHeight;
                days -= h - actualHeight;
            }
            if (days < 0){
                return false;
            }
        }
        return true;
    }
    
	long maximizeMinHeight(int N, int K, int W,int [] a)
    {
        long res = -1;
        long mnHeight = Arrays.stream(a).min().getAsInt();
        long mxHeight = Integer.MAX_VALUE / 2;
        while (mnHeight <= mxHeight){
            long guessHeight = (mxHeight + mnHeight) / 2;
            if (isOK(a, K, W, guessHeight)){
                res = guessHeight;
                mnHeight = guessHeight + 1;
            } else {
                mxHeight = guessHeight - 1;
            }
        }
        return res;
    }
}
