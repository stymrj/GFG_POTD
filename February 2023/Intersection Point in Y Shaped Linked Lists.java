/*
Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

 

Example 1:

Input:
LinkList1 = 3->6->9->common
LinkList2 = 10->common
common = 15->30->NULL
Output: 15
Explanation:
Y ShapedLinked List
Example 2:

Input: 
Linked List 1 = 4->1->common
Linked List 2 = 5->6->1->common
common = 8->4->5->NULL
Output: 8
Explanation: 
    4              5
    |              |
    1              6
     \             /
      8   -----  1 
      |
      4
      |
      5
      |
    NULL       
Your Task:
You don't need to read input or print anything. The task is to complete the function intersetPoint() which takes the pointer to the head of linklist1(head1) and linklist2(head2) as input parameters and returns data value of a node where two linked lists intersect. If linked list do not merge at any point, then it should return -1.
Challenge : Try to solve the problem without using any extra space.
Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ N + M ≤ 2*105
-1000 ≤ value ≤ 1000
*/

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	static int intersectPoint(Node head1, Node head2)
    {
        int n1=0, n2=0;
        Node temp=null;
        
        //finding length of list1.
        for(temp = head1; temp!=null; temp=temp.next)
            n1+=1;
            
        //finding length of list2.
        for(temp = head2; temp!=null; temp=temp.next)
            n2+=1;
        
        //if list1 is longer, we ignore some of its starting
        //elements till it has as many elements as list2.
        for(  ; n1>n2 ; n1-=1 )
            head1 = head1.next;
        
        // similarly, if list2 is longer, we ignore some of its starting
        //elements till it has as many elements as list1.
        for(  ; n2>n1 ; n2-=1 )
            head2 = head2.next;
        
        //now we simply traverse ahead till we get the intersection point, if 
        //there is none, this loop will break when both pointers point at NULL.
        while( head1 != head2 )
        {
            head1 = head1.next;
            head2 = head2.next;
        }
        // if head1 is not NULL, we return its data otherwise we return -1.
        if(head1!=null) 
        return head1.data;
        return -1;      
    }
}
