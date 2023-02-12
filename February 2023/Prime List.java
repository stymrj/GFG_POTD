/*
You are given the head of a linked list. You have to replace all the values of the nodes with the nearest prime number. If more than one prime number exists at an equal distance, choose the smallest one.

Example 1:

Input:
2 → 6 → 10
Output:
2 → 5 → 11
Explanation:
The nearest prime of 2 is 2 itself.
The nearest primes of 6 are 5 and 7,
since 5 is smaller so, 5 will be chosen.
The nearest prime of 10 is 11.
 

Example 2:

Input:
1 → 15 → 20
Output:
2 → 13 → 19
Explanation:
The nearest prime of 1 is 2.
The nearest primes of 15 are 13 and 17,
since 13 is smaller so, 13 will be chosen.
The nearest prime of 20 is 19.
Your Task:
The task is to complete the function primeList() which contains a reference to the head as the only argument. This function should return the head of the modified linked list.

Expected Time Complexity: O(number of nodes * sqrt(value of node)).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ Number of Nodes ≤ 104
1 ≤ Value on Node ≤ 104
*/

class Solution
{
    int PrimeCheck(int data){
        int p1=0,p2=0;
        
        if(data == 1){
            return 2;
        }
        
        for(int i=data;i>1;i--){
            if(isPrime(i)){
                p1=i;
                break;
            }
        }
        
        for(int i=data;i<data*data;i++){
            if(isPrime(i)){
                p2=i;
                break;
            }
        }
        if(Math.abs(p1-data) != Math.abs(p2-data)){
            return Math.abs(p1-data) < Math.abs(p2-data) ? p1:p2; 
        }
        else{
            return p1>p2 ? p2:p1;
        }
    }
    
    boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    Node primeList(Node head){
        //code here
        
        if(head == null){
            return head; 
        }
        
        Node temp = head;
        
        while(temp!=null){
            if(!isPrime(temp.val)){
                int newVal = PrimeCheck(temp.val);
                temp.val = newVal;
            }
            temp = temp.next;
        }
        return head;
    }
}
