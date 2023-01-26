/*
Given a string S consisting of only uppercase and lowercase characters. The task is to sort uppercase and lowercase letters separately such that if the ith place in the original string had an Uppercase character then it should not have a lowercase character after being sorted and vice versa.

Example 1:

Input:
N = 12
S = defRTSersUXI
Output: deeIRSfrsTUX
Explanation: Sorted form of given string
with the same case of character as that
in original string is deeIRSfrsTUX
Example 2:

Input:
N = 6
S = srbDKi
Output: birDKs
Explanation: Sorted form of given string
with the same case of character will
result in output as birDKs.
Your Task:
You only need to complete the function caseSort that takes a string str and length of the string n and returns sorted string.

Expected Time Complexity: O(Nlog(N)).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 105
*/

class Solution
{
    //Function to perform case-specific sorting of strings
    
    public static String caseSort(String str)
    {
        // Your code here
        
        char[] tempString = str.toCharArray();
        
        int lowerCount = 0;
        int upperCount = 0;
        
        //counting number of lowercase and uppercase characters
        for (char ch: tempString) 
        {
            if (Character.isUpperCase(ch))
                upperCount++;
            else
                lowerCount++;
        }
        
        //create two arrays to storing character differently- lowerCase, upperCase
        
        char[] lowerChArr = new char[lowerCount];
        char[] upperChArr = new char[upperCount];
        
        lowerCount = 0;
        upperCount = 0;
        
        //storing uppercase and lowercase characters in two separate arrays 
        for (char ch: tempString) 
        {
            if (Character.isUpperCase(ch))
                upperChArr[upperCount++] = ch;
            else
                lowerChArr[lowerCount++] = ch;
        };

        //sorting both the arrays
        
        Arrays.sort(upperChArr);
        Arrays.sort(lowerChArr);
        
        lowerCount = 0;
        upperCount = 0;
        
        //iterating over the given string
        
        for (int i = 0; i < tempString.length; i++){
            
            //if current character is in uppercase then we pick character from the list containing uppercase characters and add it to result
		    
            if (Character.isUpperCase(tempString[i])){
                
                tempString[i] = upperChArr[upperCount++];
            }
            
            //else we pick the character from the sorted list containing lowercase characters and add it to result
		    
            else{
                
                tempString[i] = lowerChArr[lowerCount++];
            }
        }
        
        String ansString = new String(tempString);
    
        return ansString;
        
    }
}
