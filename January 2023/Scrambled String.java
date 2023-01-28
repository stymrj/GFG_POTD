/*
Given two strings S1 and S2 of equal length, the task is to determine if S2 is a scrambled form of S1.

Scrambled string: Given string str, we can represent it as a binary tree by partitioning it into two non-empty substrings recursively.
Below is one possible representation of str = coder:
 
To scramble the string, we may choose any non-leaf node and swap its two children. 
Suppose, we choose the node co and swap its two children, it produces a scrambled string ocder.
Similarly, if we continue to swap the children of nodes der and er, it produces a scrambled string ocred.

Note: Scrambled string is not the same as an Anagram.

Print "Yes" if S2 is a scrambled form of S1 otherwise print "No".

Example 1:

Input: S1="coder", S2="ocder"
Output: Yes
Explanation: ocder is a scrambled 
form of coder.

    ocder
   /    \
  oc    der
 / \    
o   c  

As "ocder" can represent it 
as a binary tree by partitioning 
it into two non-empty substrings.
We just have to swap 'o' and 'c' 
to get "coder".
Example 2:

Input: S1="abcde", S2="caebd" 
Output: No
Explanation: caebd is not a 
scrambled form of abcde.
Your Task:
You don't need to read input or print anything. You only need to complete the function isScramble() which takes two strings S1 and S2 as input and returns a boolean value.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)

Constrains: 

S1.length = S2.length
S1.length<=31
S1 and S2 consist of lower-case English letters.
View Bookmarked Problems 
*/
class Solution{
    static HashMap<String,Boolean> hm;
    static boolean isScramble(String S1,String S2)
    {
        //code here
        hm=new HashMap<>();
        return fun(S1,S2);
    }
    static boolean fun(String S1,String S2)
    {
        if(S1.equals(S2)){
            hm.put(S1+" "+S2,true);
            return true;
        }
        if(hm.containsKey(S1+" "+S2)){
            return hm.get(S1+" "+S2);
        }
        if(S1.length()==S2.length()){
            int n=S1.length();
            for(int i=1;i<n;i++){
                if(fun(S1.substring(0,i),S2.substring(0,i)) && fun(S1.substring(i,n),S2.substring(i,n))){
                    hm.put(S1+" "+S2,true);
                    return true;
                }
                if(fun(S1.substring(0,i),S2.substring(n-i,n)) && fun(S1.substring(i,n),S2.substring(0,n-i))){
                    hm.put(S1+" "+S2,true);
                    return true;
                }
            }
        }
        hm.put(S1+" "+S2,false);
        return false;
    }
}
