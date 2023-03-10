/*
Given an array arr of size n, the task is to find the maximum triplet product in the array.


Example 1:

Input:
n = 4
arr[] = {1, 2, 3, 5}
Output:
30
Explanation:
5*3*2 gives 30. This is the maximum possible
triplet product in the array.
Example 2:

Input:
n = 7
arr[] = {-3, -5, 1, 0, 8, 3, -2} 
Output:
120
Explanation: 
-3*-5*8 gives 120. This is the maximum possible triplet product in the array.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxTripletProduct() which takes an integer n and an array arr and returns the maximum triplet product in the array.


Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)


Constraints:
3 ≤ N ≤ 5*105
-106 ≤ A[i] ≤ 106
*/

class Solution {
Long maxTripletProduct(Long arr[], int n)
{
    if (n < 3)
        return -1l;
    long maxA = Integer.MIN_VALUE,
        maxB = Integer.MIN_VALUE,
        maxC = Integer.MIN_VALUE;
    long minA = Integer.MAX_VALUE,
        minB = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++)
    {
        if (arr[i] > maxA)
        {
            maxC = maxB;
            maxB = maxA;
            maxA = arr[i];
        }
        else if (arr[i] > maxB)
        {
            maxC = maxB;
            maxB = arr[i];
        }
        else if (arr[i] > maxC)
            maxC = arr[i];
        if (arr[i] < minA)
        {
            minB = minA;
            minA = arr[i];
        }
        else if(arr[i] < minB)
            minB = arr[i];
    }
   
    return Math.max(minA * minB * maxA,
                    maxA * maxB * maxC);
}
}
