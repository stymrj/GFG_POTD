/*
Given a string S which consists of only lowercase English alphabets, you have to perform the below operations:
If the string S contains any repeating character, remove the first repeating character and reverse the string and again perform the above operation on the modified string, otherwise, you stop.
You have to find the final string.

Example 1:

Input: S = "abab"
Output: ba
Explanation:
In 1st operation: The first repeating 
character is a. After Removing the first 
character, S = "bab". After Reversing the 
string, S = "bab".
In 2nd operation: The first non repeating 
character is b. After Removing the first 
character, S = "ab". After Reversing the 
string, S = "ba".
Now the string S does not contain any 
repeating character.
Example 2:

Input: S = "dddd"
Output: d
Your Task:  
You don't need to read input or print anything. Your task is to complete the function removeReverse( ) which accepts a string S input parameter and returns the modified string.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(K), K <= 26.

Constraints:
The string contains only lowercase English alphabets.
1 < |S| < 105
|S| denotes the length of the string S.

*/

class Solution 
{ 
    // Time Complexity :- O(n);
    // Space Compleixty :- O(n);
    String removeReverse(String S) 
    { 
        // code here
        int[] fre = new int[26];
        for(int i=0;i<S.length();i++) fre[S.charAt(i)-'a']++;
        int i=0,j=S.length()-1,time=0;
        byte[] isRemoved = new byte[S.length()];
        while(i<=j) {
            if(time%2==0) {
                if(fre[S.charAt(i)-'a']>1) {
                    time++;
                    isRemoved[i]=1;
                    fre[S.charAt(i)-'a']--;
                }
                i++;
            } else {
                if(fre[S.charAt(j)-'a']>1) {
                    time++;
                    isRemoved[j]=1;
                    fre[S.charAt(j)-'a']--;
                }
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(i=0;i<S.length();i++) if(isRemoved[i]==0) sb.append(S.substring(i,i+1));
        if(time%2==1) sb.reverse();
        return sb.toString();
    }
} 
