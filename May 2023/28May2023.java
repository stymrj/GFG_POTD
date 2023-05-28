class Solution
{
    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
    	// Your code here
    	 Node slowPtr = head;
        Node fastPtr = head;

        // Move the fast pointer 'n' positions ahead.
        for (int i = 0; i < n; i++) {
            if (fastPtr == null) {
                // 'n' is greater than the number of nodes in the linked list.
                return -1;
            }
            fastPtr = fastPtr.next;
        }

        // Move both pointers simultaneously until the fast pointer reaches the end.
        while (fastPtr != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        // The slow pointer will be pointing to the Nth node from the end.
        return slowPtr.data;
    }
}
