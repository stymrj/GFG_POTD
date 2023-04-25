/*
Elena is the topper of the class. Once her teacher asked her a problem. He gave Elena an array of integers of length n. He calls a subset of array arr good if its product can be represented as a product of one or more distinct prime numbers. He asked her to find the number of different good subsets in arr modulo 109 + 7.

As a good friend of Elena help her to solve the problem.

Example 1:

Input:
N: 4
arr: {1,2,3,4}
Output: 6
Explanation: 
The good subsets are:
- [1,2]: product is 2, which is the product of distinct
prime 2.
- [1,2,3]: product is 6, which is the product of 
distinct primes 2 and 3.
- [1,3]: product is 3, which is the product of distinct
prime 3.
- [2]: product is 2, which is the product of distinct
 prime 2.
- [2,3]: product is 6, which is the product of distinct
primes 2 and 3.
- [3]: product is 3, which is the product of distinct
prime 3.
Example 2:

Input:
N : 3
arr : {2, 2, 3}
Output: 5
Explanantion:
The good subsets are : {2}, {2}, {2, 3}, {2, 3}, {3}
Your Task:
The task is to complete the function goodSubsets() which takes an integer n and an array arr as the input parameters and should return the number of different good subsets.

Expected Time Complexity: O(NlogN)
Expected Space Complexity: O(N)

Constraints:

1 <= N <= 105
1< = arr[i] <= 30

*/

class Solution {

    static int mod = (int)1e9 + 7;
    static int[] map = new int[31];
    static {
        int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int i = 2; i <= 30; ++i) {
            // If num is a multiple of 4/9/25, adding it to any subset will make
            // it bad
            if (0 == i % 4 || 0 == i % 9 || 25 == i) continue;
            int mask = 0;
            for (int j = 0; j < 10; ++j) {
                if (0 == i % prime[j]) mask |= 1 << j;
            }
            map[i] = mask;
        }
    }

    public int goodSubsets(int[] arr, int n) {

        int one = 0;
        // dp[set_of_primes] represents the number of times set_of_primes can be
        // formed (set_of_primes === mask)
        // Since there are 10 possible prime numbers, there are 2^10 possible
        // set_of_primes
        int[] dp = new int[1024], cnt = new int[31];
        dp[0] = 1;
        for (int i : arr) {
            if (i == 1)
                one++;
            else if (map[i] != 0)
                cnt[i]++;
        }
        for (int i = 0; i < 31; ++i) {
            if (cnt[i] == 0) continue;
            for (int j = 0; j < 1024; ++j) {
                if (0 != (j & map[i])) continue;
                dp[j | map[i]] =
                    (int)((dp[j | map[i]] + dp[j] * (long)cnt[i]) % mod);
            }
        }
        long res = 0;
        for (int i : dp) res = (res + i) % mod;
        res--;
        if (one != 0) res = res * pow(one) % mod;
        return (int)res;
    }

    public long pow(int n) {
        long res = 1, m = 2;
        while (n != 0) {
            if (1 == (n & 1)) res = (res * m) % mod;
            m = m * m % mod;
            n >>= 1;
        }
        return res;
    }
}
