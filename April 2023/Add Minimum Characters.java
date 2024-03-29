/*
Given a string str, find the minimum characters to be added at front of the string to make it a palindrome.


Example 1:

Input:
str = ABCD
Output: 3
Explanation: The resultant string 
after adding 3 characters is DCBABCD.
The minimum possible answer is 3.
Example 2:

Input:
str = ABA
Output: 0
Explanation: The given string
is already a palindrome.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function addMinChar() which takes the string str as input parameters and returns the minimum number of characters to be added to make it a palindrome.


Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)


Constraints:
1 ≤  |str| ≤ 105
str contains only uppercase english alphabets

*/


class Solution
{
	public static int addMinChar(String str){
		//code here
	int n = str.length();
        StringBuilder sb = new StringBuilder(str);
        String rev = sb.reverse().toString();
        sb.reverse();
        String s = str + "#" + rev;
        int m = s.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        int palindromeLen = lps[m - 1];
        return n - palindromeLen;
    }
}
