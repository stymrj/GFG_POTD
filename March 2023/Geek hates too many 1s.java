/*
Given an non-negative integer n. You are only allowed to make set bit unset. You have to find the maximum possible value of query so that after performing the given operations, no three consecutive bits of the integer query are set-bits. 

Example 1:

Input:
n = 2
Output: 
2
Explanation: 
2's binary form is 10, no 3 consecutive set bits are here. 
So, 2 itself would be answer.
Example 2:

Input:
n = 7
Output: 
6
Explanation: 
7's binary form is .....00111.We can observe that 3
consecutive bits are set bits. This is not allowed.
So, we can perfrom the operation of changing set 
bit to unset bit. Now, the number 
becomes 6 that is .....00110. It satifies the 
given condition. Hence, the maximum possible 
value is 6.

Your Task:   You don't need to read input or print anything. Your task is to complete the function noConseBits(), which takes integer n as input parameter and returns the maximum value possible so that it satifies the given condition.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
0 ≤ n ≤ 109
*/

class Solution {
    public static int noConseBits(int n) {
        int c=0;
        String a=Integer.toBinaryString(n);
        char arr[]=a.toCharArray();
        for(int i=0;i<arr.length-2;i++){
            if(arr[i]=='1' && arr[i+1]=='1' && arr[i+2]=='1'){
                arr[i+2]='0';
            }
        }
        String b=String.valueOf(arr);
        return Integer.parseInt(b,2);
    }
}
