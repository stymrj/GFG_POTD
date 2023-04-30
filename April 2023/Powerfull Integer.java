/*
Your are given an 2D integer array  intervals whose length is n where intervals[i]=[start,end] means all integers from start to  end inclusive start and end are also present and also we are given an integer k . We have to return the Powerfull Integer.Powerfull Integer is that integer that occurs at least k times and if multiple integers  have at least k  occurences we have to return the maximum integer out of all those elements . 

Note: If no integer occurs at least k times return -1 in that case .

Example 1:

Input :
n=3
intervals={{1,3},{4,6},{3,4}}
k=2
Output: 4
Explanation:
As we can see that 3 and 4 are the 2 integers 
that have 2 occurences(2>=k) so we have 4 
in this case as the Powerfull integer as it 
is the maximum element which satisfies the condition.
Example 2:

Input :
n=4
intervals={{1,4},{12,45},{3,8},{10,12}}
k=3
Output: -1
Explanation:
As we can see that no integer occurs 
3 times so in that case we have to 
return -1 (see Note).

Your Task:
You don't need to read input or print anything. Your task is to complete the function powerfullInteger() which takes an integer n, a 2d array intervals  and an integer k respectively and you have to return powerfull Integer if it exists else return -1.

Expected Time Complexity: O(NlogN)
Expected Space Complexity: O(N)

Constraints:
1<=n<=105
1<=intervals[i][0]<=intervals[i][1]<=109
1<=k<=105
The sum of n over all test cases won't exceed 106

*/

//User function Template for Java
class Solution{
    public static int powerfullInteger(int n,int interval[][],int k)
    {
       TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(int i=0;i<n;i++){
            tm.put(interval[i][0],tm.getOrDefault(interval[i][0],0)+1);
            tm.put(interval[i][1]+1,tm.getOrDefault(interval[i][1]+1,0)-1);
        }
        int temp=0;
        int ans=0;
        for(Map.Entry<Integer,Integer> e:tm.entrySet()){
            int key=e.getKey();
            int value=e.getValue();
            if(value>=0){
                temp+=value;
                if(temp>=k){
                    ans=key;
                }
            }else if(value<0){
                if(temp>=k){
                    ans=key-1;
                }
                temp+=value;
            }
        }
        return (ans==0?-1:ans);
    }
}
