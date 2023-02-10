/*
Bob is very fond of balloons. Once he visited an amusement park with his mother. The mother told Bob that she would buy him a balloon only if he answer her problem right. She gave Bob a string S [contains only lowercase characters] and asked him to use the characters of string to form as many instances of the word "balloon" as possible. Return the maximum number of instances that can be formed.

Help Bob to solve the problem.

Note: You can use each character in the string at most once.

Example 1:

Input:
S: nlaebolko
Output: 1
Explanation:
Here, the number of occurence of 'b' = 1
of occurence of 'a' = 1
of occurence of 'l' = 2
of occurence of 'o' = 2
of occurence of 'n' = 1
So, we can form 1 "balloon" using the letters.
 
Example 2: 

Input:
S: loonbalxballpoon
Output: 2
Explanation:
Here, the number of occurence of 'b' = 2
of occurence of 'a' = 2
of occurence of 'l' = 4
of occurence of 'o' = 4
of occurence of 'n' = 2
So, we can form 2 "balloon" using the letters.
 

Your Task:
The task is to complete the function maxInstance() which takes a string as the only input parameter and should return the maximum instances that can be formed of the word "balloon" using the given string.

Expected Time Complexity: O(n), n is size of the given string.
Expected Auxiliary Space: O(26).

Constraints:
1 <= s.length <= 106
*/

class Solution {
    public int maxInstance(String s) {
        // Code here

        int count_b=0;
        int count_a=0;
        int count_l=0;
        int count_o=0;
        int count_n=0;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='b'){
            count_b++;
            } if(s.charAt(i)=='a'){
                count_a++;
            } if(s.charAt(i)=='l'){
                count_l++;
            } if(s.charAt(i)=='o'){
                count_o++;
            } if(s.charAt(i)=='n'){
                count_n++;
            }
            }

            int result=0;
            result=count_b;
            result=Math.min(count_a,result);
            result=Math.min(count_l/2,result);
            result=Math.min(count_o/2,result);
            result=Math.min(count_n,result);
            return result;
    }
}
