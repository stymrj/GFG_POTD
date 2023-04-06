/*
Given an array A of n positive numbers. The task is to find the first index in the array such that the sum of elements before it is equal to the sum of elements after it.

Note:  Array is 1-based indexed.

Example 1:

Input: 
n = 5 
A[] = {1,3,5,2,2} 
Output: 3 
Explanation: For second test case 
at position 3 elements before it 
(1+3) = elements after it (2+2). 
 

Example 2:

Input:
n = 1
A[] = {1}
Output: 1
Explanation:
Since its the only element hence
it is the only point.
Your Task:
The task is to complete the function equalSum() which takes the array and n as input parameters and returns the point. Return -1 if no such point exists.

Expected Time Complexily: O(N)
Expected Space Complexily: O(1)

Constraints:
1 <= n <= 106
1 <= A[i] <= 108


*/


class Solution{
    int equalSum(int [] A, int N) {
        int sum=0;
        for(int i=0;i<N;i++) 
        sum+=A[i];
        int aheadSum=sum,prevSum=0;
        for(int i=0;i<N;i++){
            aheadSum-=A[i];
            if(prevSum==aheadSum) 
            return i+1;
            prevSum+=A[i];
        }
        return -1;
    }
}

