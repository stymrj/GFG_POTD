/*
Given a string S. In one operation, you can remove the substring "pr" from the string S and get amount X or you can remove the substring "rp" and get the amount Y. 
Find the maximum amount you can get if you perform zero or more such operations optimally. 

Note : 

Substring of a string S is defined as a continuous sequence of characters in S.
After removing pr or rp, the order of remaining letters should remain the same.

Example 1:

Input:
X = 5, Y = 4
S = "abppprrr"
Output: 15
Explanation: 
Here, S = "abppprrr" 
X= 5, Y=4.
Remove "pr", new string S = "abpprr".
Remove "pr", new string S = "abpr".
Remove "pr", new string S = "ab".
In total, we removed "pr" 3 times, 
so total score is 3*X + 0*Y = 3*5 =15.
 

 

Example 2:

Input:
X = 7, Y = 7
S = "prpptppr"
Output: 14
Explanation: 
Here, S = "prpptppr" 
X= 7, Y=7.
As both have the same amount we can first 
remove either pr or rp. Here we start with pr
Remove "pr", new string S = "pptppr".
Remove "pr", new string S = "pptp".
In total, we removed "pr" 2 times, 
so total score is 2*X + 0*Y = 2*7 =14.

Your Task: 
You don't need to read input or print anything. Your task is to complete the function solve() which takes the X ,Y and string S as input parameters and returns the maximum amount you can get after performing the above operations.


Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)


Constraints:
1 ≤ |S| ≤ 105
1 ≤ X,Y ≤ 105
S contains lowercase English letters only.
*/

class Solution 
{ 
    static long solve(int X,int Y, String S)
	{    
	    // code here
	     // x//- pr(s1) , Y -rp(s2)
        String s1="pr" ; String s2="rp";
        if(X<Y)
        {
            int temp = X; X=Y; Y=temp;
	       
	       String t =s1; s1=s2; s2=t;
        }
        long ans=0;
        // //now we know X has larger cost in any case and has string associated named s1.
        Stack<Character> st = new Stack<>();
	   for(int i =S.length()-1; i>=0; i--)
	   {
	       Character curr= S.charAt(i), first=s1.charAt(0), second = s1.charAt(1);
	       if(st.size()>0 && curr ==first && st.peek()==second)
	       {
	           st.pop();
	           ans+=X;
	       }
	       else
	       st.push(curr);
	   }
	   
	    //step -2
	    StringBuilder rem = new StringBuilder();
	   while(st.size()>0)
	   rem.append(st.pop());
	   
	    S = rem.toString();
	   //in rem string check for the other cost Y, if any instances present , remove them now
	  
	   for(int i =S.length()-1; i>=0; i--)
	   {
	       Character curr= S.charAt(i), first=s2.charAt(0), second = s2.charAt(1);
	       if(st.size()>0 && curr ==first && st.peek()==second)
	       {
	           st.pop();
	           ans+=Y;
	       }
	       else
	       st.push(curr);
	   }
	   return ans;
	} 
}
	   
	   
