/*

Given two strings s1 and s2, The task is to convert s1 into a palindrome such that s1 contain s2 as a substring in a minimum number of operation.
In a single operation, we can replace any word of s1 with any character.

Note: If it is not possible to convert s1 such that it is a palindrome as well as contains substring of s2, then return -1.

Example 1:

Input:
s1="abaa" s2="bb"
Output: 1
Explanation:
we can replace s1[2]='a' with 'b'.
So the new s1 will be like "abba",
having s2 as a substring.
Example 2:

Input:
s1="abbd" s2="mr"
Output: 4
Explanation:
1st: s1="mrbd" --> 2 operations (this is the 
minimum operation to make s2 a substring of s1) 
2nd: s1="mrrm" --> 2 operations 
(this is the minimum operation to make s1 palindrome)
Your Task: 
You don't need to read input or print anything. Complete the function specialPalindrome() which takes the two strings s1 and s2 as input parameters. Return the minimum number of operations needs to convert s1 such that it is a palindrome and having s2 as a substring in s1.

Expected Time Complexity: O(N*M) [N: size of s1 and M: size of s2]
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ |s2| ≤ |s1| ≤  1000
*/

class Solution{
    public  static int specialPalindrome(String a, String b){
       //Code Here
       char s1[] = a.toCharArray(), s2[] = b.toCharArray();
       int l1 = s1.length, l2 = s2.length, ans = Integer.MAX_VALUE;
       for(int i=0 ; i<l1-l2+1 ; i++){
           char temp[]=(a.substring(0,i)+b+a.substring(i+l2)).toCharArray();
           int cost=0;
            // calculate cost to place s2
            for(int j=i ; j<i+l2 ; j++){
                if(s1[j]!=temp[j])
                    cost++;
            }
            int z=0;
            for(int j=0 ; j<Math.ceil(l1/2.0) ; j++){
    
                if((j<i || j>=i+l2) && temp[j]!=temp[l1-j-1]) // if s2 is in the first half of new string
                    cost++;
                else if(temp[j]!=temp[l1-j-1] && (l1-j-1<i || l1-j-1>=i+l2)) // if s2 is in the second half of new string
                    cost++;
                else if(temp[j]!=temp[l1-j-1]){ // if s2 is in both halves
                    z=1;
                    break;
                }
            }
            if(z==0)
                ans=Math.min(ans,cost);
       }
       if(ans == Integer.MAX_VALUE){
          return -1;
        }
        return ans;
    }
}
