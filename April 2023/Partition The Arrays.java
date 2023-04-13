/*

Given an array A[] of N integers. The task is to partition the array into four non-empty contiguous subarrays P, Q, R, and S such that each element of the array A[] should be present in any subarray.
Let W, X, Y, and Z be the sum of the elements in P, Q, R, and S respectively.
Find the smallest absolute difference between the maximum and the minimum among W, X, Y, and Z.

Example 1:

Input:
N = 5
A[] = [4,2,2,5,1]
Output: 4
Explanation: let partition the array 
P,Q,R,S = [4],[2,2],[5],[1]
W = 4, X = 4, Y = 5, Z = 1 
Differnce = max(W,X,Y,Z)-min(W,X,Y,Z)= 5-1 = 4 
Example 2:

Input:
N = 4
A[] = {4,4,4,4}
Output: 0
Explanation: 
There is only one way to partition 
the array. P,Q,R,S = [4],[4],[4],[4]
Your Task:
You don't need to read input or print anything. The task is to complete the function minDifference() which takes the integer N and the array A[] as inputs and returns the smallest absolute difference.

Expected Time Complexity: O(NLogN)
Expected Auxiliary Space: O(N)

Constraints:
4 < N < 105
1 < A[i] < 109

*/
class Solution {

	ArrayList<long []> help(int [] a){                int n=a.length;

                long [] p = new long[n+1];

                for(int i=0;i<n;i++){

                       p[i]=a[i];

                    if(i>0){

                       p[i]+=p[i-1];

                 }

           }

        ArrayList<long []> tmp = new ArrayList<>();

        long arr[] = {0,0};

        tmp.add(arr);

        for(int i=1;i<n;i++){

            int l=1,h=i;

            long dif = (long)2e18;

            long [] t = new long[2];

            while(l<=h){

                int mid=(l+h)/2;

                long x=p[mid-1];

                long y=p[i]-x;

                

                if(Math.abs(x-y)<dif){

                dif=Math.abs(x-y);

                t[0] = x; t[1] = y;

                }

                if(x>y){

                  h=mid-1;

                }

                else{

                  l=mid+1;

                }

            }

            tmp.add(t);

        }

        return tmp;

        }

	void reverse(int a[]){

		int n = a.length;

                int i, k, t;

                for (i = 0; i < n / 2; i++) {

                    t = a[i];

                    a[i] = a[n - i - 1];

                    a[n - i - 1] = t;

                }

            }    

	long minDifference(int N, int A[]) { 

		long ans = (long)2e18;

		ArrayList<long []> x = help(A);

		reverse(A);

        ArrayList<long []> y = help(A);

        Collections.reverse(y);

        for(int i=1;i+2<N;i++) {

          ans=Math.min(ans, Math.max(Math.max(x.get(i)[0],x.get(i)[1]), Math.max(y.get(i+1)[0],y.get(i+1)[1])) - Math.min(Math.min(x.get(i)[0],x.get(i)[1]), Math.min(y.get(i+1)[0],y.get(i+1)[1])));

        }

		return ans;

	}

} 
