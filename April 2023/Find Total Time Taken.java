/*

You are given an array arr of size n, containing the values in between 1 to n, you are asked to determine the total time taken in order to pick all the array elements from left to right but there is a condition, you are also given an another array time again of size n, time[element] ( 1 <= element <= n ) represents the time after which you can again pick element, For clearity, while moving from left to right if you have once picked element, then you can again pick element only after time[element] sec.

NOTE:
1. It takes 1 sec to move from index i to i+1 (1 <= i < n).
2. There is no extra time needed to pick an element.
3. 1-based indexing.

Example 1:

Input:
n = 4
arr = {1, 2, 3, 3}
time = {1, 2, 3, 4}
Output:
5
Explanation:
-> You start from index 1, and pick arr[1] 
   i.e. 1 in no time.
-> In 1 sec you move from index 1 to 2, and pick arr[2]
   i.e. 2, total time = 1.
-> In next 1 sec you move from index 2 to 3, and pick 
   arr[3] i.e. 3, total time = 2.
-> In next 1 sec you move from index 3 to 4, and arr[4] 
   is 3, which you have taken already at time 2, hence 
   you need to wait for time[arr[i]] sec to again pick 
   arr[i], time[arr[i]] = time[3] = 3, hence in 1 sec you 
   moved from index 3 to 4, and waited for next 2 sec,
   and finally picked arr[4], total time = 5.
Example 2:

Input:
n = 4
arr = {1, 2, 3, 4}
time = {1, 2, 3, 4}
Output:
3
Explanation:
All the array elements are different hence, you do not 
have to wait for any arr[i] before picking it, hence 
the total time will be 3, which is the time required 
to traverse the array.
Your Task:
You don't need to read input or print anything. Your task is to complete the function totalTime() which takes three variables n, arr, time, as explained in the problem statement, and returns the total time taken to pick all the elements.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 10^5
1 <= arr[i] <= n
1 <= time[i] <= 10^5

*/

class Solution {
    public static long totalTime(int n, int[] arr, int[] time) {
        long[] a = new long[n];
        Arrays.fill(a, -1);
        long curr = 0;
        for (int i = 0; i < n; i++) {
            if (a[arr[i] - 1] == -1) {
                a[arr[i] - 1] = curr;
            } else {
                if (curr < a[arr[i] - 1] + time[arr[i] - 1]) {
                    curr = a[arr[i] - 1] + time[arr[i] - 1];
                }
                a[arr[i] - 1] = curr;
            }
            curr++;
        }
        return curr - 1;
    }
}
