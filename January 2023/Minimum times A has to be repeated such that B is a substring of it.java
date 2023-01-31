/*
Given two strings A and B. Find minimum number of times A has to be repeated such that B is a Substring of it. If B can never be a substring then return -1.

 

Example 1:

Input:
A = "abcd"
B = "cdabcdab"
Output:
3
Explanation:
Repeating A three times (abcdabcdabcd),
B is a substring of it. B is not a substring
of A when it is repeated less than 3 times.
Example 2:
Input:
A = "ab"
B = "cab"
Output :
-1
Explanation:
No matter how many times we repeat A, we can't
get a string such that B is a substring of it.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function minRepeats() which takes 2 strings A, and B respectively and returns the minimum number of times A has to be repeated such that B is a substring of it. Return -1 if it's not possible.


Expected Time Complexity: O(|A| * |B|)
Expected Auxiliary Space: O(|B|)


Constraints:
1 ≤ |A|, |B| ≤ 103
String A and B consists of lower case alphabets
*/

class Solution {
    // Function to check if a number  
    // is a substring of other or not 
    static boolean issubstring(String str2,  
                               String rep1) 
    { 
        int M = str2.length(); 
        int N = rep1.length(); 
      
        // Check for substring from starting  
        // from i'th index of main string 
        for (int i = 0; i <= N - M; i++)  
        { 
            int j; 
      
            // For current index i,  
            // check for pattern match 
            for (j = 0; j < M; j++) 
                if (rep1.charAt(i + j) != str2.charAt(j)) 
                    break; 
      
            if (j == M) // pattern matched 
                return true; 
        } 
      
        return false; // not a substring 
    } 
    
    static int minRepeats(String A, String B) {
        // To store minimum number of repetations 
        int ans = 1; 
          
        // To store repeated string 
        String S = A; 
          
        // Untill size of S is less than B 
        while(S.length() < B.length()) 
        { 
            S += A; 
            ans++; 
        } 
          
        // ans times repetation makes required answer 
        if (issubstring(B, S)) return ans; 
          
        // Add one more string of A  
        if (issubstring(B, S + A))  
            return ans + 1; 
              
        // If no such solution exits  
        return -1; 
    }
};
