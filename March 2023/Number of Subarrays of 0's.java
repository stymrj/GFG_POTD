/*
You are given an array arr  of length N of 0's and 1's. Find the total number of subarrays of 0's

Example 1:

Input:
N = 4
arr[] = {0, 0, 1, 0}
Output:
4
Explanation:
Following are the subarrays of
length 1: {0}, {0}, {0} - 3
length 2: {0, 0} - 1
Total Subarrays: 3 + 1 = 4
Example 2:

Input:
N = 4
arr[] = {0, 0, 0, 0}
Output:
10
Explanation:
Following are the subarrays of
length 1: {0}, {0}, {0}, {0} - 4
length 2: {0, 0}, {0, 0}, {0, 0} - 3
length 3: {0, 0, 0}, {0, 0, 0} - 2
length 4: {0, 0, 0, 0} - 1
Total Subarrays: 4 + 3 + 2 + 1 = 10
Your Task:

Your task is to complete the function no_of_subarrays(), which takes an integer N and an integer array arr as the input parameters and returns an integer denoting the total number of subarrays of 0's.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:

1 <= N <= 106
0 <= arr[i] <= 1
*/

class Solution{
	long no_of_subarrays(int N, int [] arr) {
		long ans=0;
		long cnt=0;
		for(var in:arr)
		{
		    if(in==0)
		    {
		        cnt++;
		    }
		    else
		    {
		        ans+=((long)(cnt*(cnt+1))/2);
		        cnt=0;
		    }
		}
		if(cnt!=0)
		{
		    ans+=((long)(cnt*(cnt+1))/2);
		}
		    return ans;
	}
}
