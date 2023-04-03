/*
Given a big positive number x represented as string, find value of x % 11 or x mod 11. Output is expected as an integer.

Example 1:

Input: x = 1345
Output: 3
Explanation: 1345 % 11 = 3 
Example 1:

Input: x = 231456786543567898765
Output: 1
Explanation: 231456786543567898765 % 11 = 1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function xmod11() which takes string x as the input parameter and returns the integer value of x%11.

Expected Time Complexity: O(length of string x)
Expected Space Complexity: O(1)

Constraints:
1 ≤ length of string x ≤ 100000

*/

class Solution 
{ 
    static int xmod11(String s)
	{    
        char[] ch = s.toCharArray();
        int even = 0, odd = 0;
        for(int i=0;i<ch.length;i++){
            if(i%2==0)even += ch[i] - '0';
            else odd += ch[i] - '0';
        }

        return ((odd-even)%11 + 11)%11;
        
	}
} 
