/*
Menu


Count Binary Strings With No Consecutive 1s
HardAccuracy: 73.76%Submissions: 4K+Points: 8
Finding a high paying job is easier than today's problem! Attend Job Fair 2023
 

Given an integer N. Your task is to find the number of binary strings of length N having no consecutive 1s.
As the number can be large, return the answer modulo 10^9+7.

Example 1:

Input:
N = 3
Output:
5
Explanation:
All the binary strings of length 3 having
no consecutive 1s are "000", "001", "101",
"100" and "010".
Example 2:

Input: 
N = 2
Output:
3
Explanation: 
All the binary strings of length 2 having no 
consecutive 1s are "10", "00" and "01".
Your Task:
You dont need to read input or print anything. Complete the function countStrings() which takes the integer N as the input parameter, and returns the number of binary strings of length N with no consecutive 1s.

Expected Time Complexity: O(log(N))
Expected Auxiliary Space: O(Height of the recursive call stack)

Constraints:
1 ≤ N ≤ 1018



*/



class Solution {
    static int mod= 1000000007;
    public int countStrings(long N) {
        return fib(N+2);
    }
    static int fib(long n) {
        long F[][] = new long[][]{{1,1},{1,0}};
        if (n == 0) return 0;
        power(F, n-1);
        return (int)F[0][0];
    }
    static void power(long F[][], long n) {
        if( n == 0 || n == 1) return;
        long M[][] = new long[][]{{1,1},{1,0}};
        power(F, n/2);
        multiply(F, F);
        if (n%2 != 0) multiply(F, M);
    }
    static void multiply(long F[][], long M[][]) {
        long x =  ((F[0][0]*M[0][0])%mod + (F[0][1]*M[1][0])%mod)%mod;
        long y =  ((F[0][0]*M[0][1])%mod + (F[0][1]*M[1][1])%mod)%mod;
        long z =  ((F[1][0]*M[0][0])%mod + (F[1][1]*M[1][0])%mod)%mod;
        long w =  ((F[1][0]*M[0][1])%mod + (F[1][1]*M[1][1])%mod)%mod;
        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
}
