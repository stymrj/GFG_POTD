/*
You are given 5 integers - N,A,B,C,D.
Let us say all the integers of length N, having only A or B in their decimal representation are good integers. Also, among all the good integers, all those integers whose sum of digits contains only C and D are best integers.
Find the number of best integers of length N. Since the number of best integers can be huge, print it modulo 109+7.
 

Example 1:

Input:
N = 2, A = 1, B = 2, C = 3, D = 5
Output: 
2
Explanation: 
The following are good integers:- 
{ 12 , 22 , 11 , 21 }
And the following are best integers:- 
{ 12, 21 } because sum of digits of 11,22
are 2 and 4, they are not equal to C or D.
Example 2:

Input:
N = 1, A = 1, B = 1, C = 2, D = 3
Output: 
0
Explanation: 
The following are good integers: - { 1 }
Since sum of digits is 1 which is not equal to
C or D, therefore, answer is 0.
Your Task:
The task is to complete the function solve() which takes five integers N,A,B,C and D as input parameters and returns the number of best integers modulo 109+7.

Expected Time Complexity: O(NlogN)
Expected Space Complexity: O(N)

Constraints:
1 ≤ A, B, C, D ≤ 9
1 ≤ N ≤ 105

*/

class Solution{
	static int N = (int)1e5+5;
	static int M = (int)1e9+7;
	long binpow(long a,long b,long p){
	    if(b == 0)
	    	return 1;
	    long t = binpow(a,b/2,p);
	    if(b%2 != 0)
	    	return (((a*t)%p)*t)%p;
	    else 
	    	return ((t*t)%p);
	}
	 
	long [] fact;
	long [] invfact;
	void init(){
	    fact[0] = 1;
	    for(int i = 1;i < N; i++)
	    {
	    	fact[i] = i*fact[i-1]%M;
	    }
	    invfact[N-1]=binpow(fact[N-1],M-2,M);
	    for(int i=N-2;i>=0;i--){
	        invfact[i] = (i+1)*invfact[i+1]%M;
	    }
	}
	long ncr(int n, int r, long p){
	    return (((fact[n]*invfact[n-r])%p)*invfact[r])%p;
	}
	static boolean f;
	int bestNumbers(int n, int a, int b, int c, int d) {
        fact = new long[N];
        invfact = new long[N];
        f = false;
        if(!f)
        {
            f = true;
            init();
        }
        long ans = 0;
        for(int i=0; i<=n; i++)
        {
            int sum = i*a+(n-i)*b;
            boolean good = true;
            while(sum>0)
            {
                if(sum%10!=c && sum%10!=d)
                {
                    good = false;
                    break;
                }
                sum /= 10;
            }
            if(good)
            {
                ans += ncr(n,i,M);
                ans %= M;
            }
        }
        return (int)ans;
    }
}
