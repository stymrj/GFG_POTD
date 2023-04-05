/*
You are given an array arr[ ] of size N consisting of only positive integers. Your task is to find the count of special numbers in the array. A number is said to be a special number if it is divisible by at least 1 other element of the array.

Example 1:

Input:
N = 3
arr[] = {2, 3, 6}
Output:
1
Explanation:
The number 6 is the only special number in the
array as it is divisible by the array elements 2 
and 3. Hence, the answer is 1 in this case.
Example 2:

Input: 
N = 4
arr[] = {5, 5, 5, 5}
Output:
4
Explanation: 
All the array elements are special. Hence, 
the answer is 4 in this case.
Your Task:
You don't need to read input or print anything. Complete the function countSpecialNumbers() which takes the integer N and the array arr[ ] as the input parameters, and returns the count of special numbers in the array. 


Expected Time Complexity: O(N*M) where M = max(arr[i])
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105 
1 ≤ arr[i] ≤ 106 

*/

class Solution {
    public int countSpecialNumbers(int N, int arr[]) {
        // Code here
        HashMap<Integer,Integer>hm=new HashMap<>();
        int ans=0;
        for(int i=0;i<N;i++){
            
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i],1);
            }
            else{
                hm.put(arr[i],hm.get(arr[i])+1);
            }
            
        }
        for(int i=0;i<N;i++){
            
            int temp=arr[i];
            for(int j=1;j*j<=temp;j++){
                if(temp%j==0){
                    // System.out.println(j);
                    if(temp!=j && hm.containsKey(j)){
                        
                        ans++;
                        break;
                    }
                    else if(temp==j &&  hm.get(j)>1){
                        ans++;
                        break;
                        
                    }
                    if(temp/j!=j){
                        // System.out.println(temp/j);
                        if(temp!=temp/j && hm.containsKey(temp/j)){
                            ans++;
                            break;
                        }
                        else if(temp==temp/j &&  hm.get(temp/j)>1){
                            ans++;
                            break;
                            
                        }
                    }
                }
            }
            
        }
       
        return ans;
    }
}
