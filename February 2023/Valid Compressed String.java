/*
A special compression mechanism can arbitrarily delete 0 or more characters and replace them with the deleted character count.
Given two strings, S and T where S is a normal string and T is a compressed string, determine if the compressed string  T is valid for the plaintext string S. 


Example 1:

Input:
S = "GEEKSFORGEEKS"
T = "G7G3S"
Output:
1
Explanation:
We can clearly see that T is a valid 
compressed string for S.

Example 2:

Input:
S = "DFS"
T = "D1D"
Output :
0
Explanation:
T is not a valid compressed string.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function checkCompressed() which takes 2 strings S and T as input parameters and returns integer 1 if T is a valid compression of S and 0 otherwise.


Expected Time Complexity: O(|T|)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ |S| ≤ 106
1 ≤ |T| ≤ 106
All characters are either capital or numeric.
*/

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        int i = 0, j = 0;  //initialize two pointer 
        while (i < S.length() && j < T.length()) {  
            if (S.charAt(i) == T.charAt(j)) {  
                i++;j++;
            } else if (Character.isDigit(T.charAt(j))) {  // If the current character in T is a digit, 
            //parse the integer value and skip that many characters in S
                int count = 0;
                while (j < T.length() && Character.isDigit(T.charAt(j))) {
                     // Parse the digit character and add it to the count variable
                    count = count * 10 + T.charAt(j) - '0'; 
                    j++;
                }
                i += count;
            } else {  
                // If the curr char in T i is neither digit nor matches 
                return 0;
            }
        }
        return (i == S.length() && j == T.length()) ? 1 : 0;
    }
}
