/* Given a binary string S consists only of 0s and 1s. The task is to calculate the number of substrings that have more 1s than 0s.

Example 1:

Input:
S = "011"
Output: 4
Explanation: There are 4 substring which 
has more 1s than 0s. i.e "011","1","11" and "1"
Example 2:

Input:
S = "0000"
Output: 0
Explanation: There is no substring
which has more 1s than 0s
Your Task:  
You dont need to read input or print anything. Complete the function countSubstring() which takes the string S as input parameter and returns the number of substring which has more 1s than 0s.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

Constraints:
1 < |S| < 105
|S| denotes the length of the string S */

// Solution Here .....

public class Solution {
    long countSubstring(String S){
    long count = 0, numOfZeroes = 0;
    int zeroIndex = S.length();

    int frequency[] = new int[2 * S.length() + 5];

    int currentCount=zeroIndex;

    for(int i = 0; i < S.length(); i++){
        if(S.charAt(i) == '0')
            currentCount--;
        else
            currentCount++;

        if(currentCount <= zeroIndex){
            numOfZeroes++;
        }
        frequency[currentCount]++;
    }

   
    for(int i = 0; i < S.length(); i++){
        count += (S.length() - i - numOfZeroes) * 1l;

        if(S.charAt(i) == '1'){
            frequency[zeroIndex+1]--;
            zeroIndex++;
            numOfZeroes += frequency[zeroIndex];
        }
        else{
            frequency[zeroIndex-1]--;
            zeroIndex--;
            numOfZeroes--;
            numOfZeroes -= frequency[zeroIndex+1];
        }
    }

    return count;
}
}

