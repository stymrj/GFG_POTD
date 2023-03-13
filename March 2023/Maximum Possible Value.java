/*
Given two arrays A[] and B[] of same length N. There are N types of sticks of lengths specified. Each stick of length A[i] is present in B[i] units (i=1 to N). You have to construct the squares and rectangles using these sticks. Each unit of a stick can be used as length or breadth of a rectangle or as a side of square. A single unit of a stick can be used only once.

Let S be the sum of lengths of all sticks that are used in constructing squares and rectangles. The task is to calulate the maximum possible value of S.

Example 1:

Input:
N = 4
A[] = {3,4,6,5}
B[] = {2,3,1,6}
Output: 
38
Explanation: 
There are 2 sticks of length 3.
There are 3 sticks of length 4.
There is a 1 stick of length 6.
There are 6 sticks of length 5.
One square can be made using 4 sticks of
4th kind (5*4=20)
A rectangle can be made using 2 sticks of 
4th kind and 2 sticks of 2nd kind (5*2+4*2=18)
S = 20 + 18 = 38

Example 2:

Input:
N = 1
A[] = {3}
B[] = {2}
Output: 
0
Explanation: 
There are only 2 sticks of length 3 which are 
not enough to make the square or rectangle.
Your Task: 
You don't need to read input or print anything. Complete the function maxPossibleValue( ) which takes the integer N , the array A[], and the array B[] as input parameters and returns the maximum possible value of S. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 106
1 ≤ A[] ≤ 109
1 ≤ B[] ≤ 103
*/

class Solution 
{ 
    long maxPossibleValue(int n, int len[] ,int qty[]) { 
       int min = Integer.MAX_VALUE;
       long sum = 0;
       for(int i = 0;i<n;i++){
           if(qty[i] >=4 ){
               min = Math.min(min, len[i]);
               sum += (qty[i]/4)*len[i]*4;
               qty[i] %= 4;
           }
       }
      int count = 0;
      for(int i = 0;i<n;i++){
          if(qty[i] >=2 ){
              min = Math.min(min, len[i]);
              count += 1;
              sum += len[i]*2;
              qty[i] %= 2;
          }
      }
      if(count%2 != 0) sum -= min*2;
        return sum;
    }
} 
