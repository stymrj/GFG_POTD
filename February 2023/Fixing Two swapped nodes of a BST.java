/*
Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
Note: It is guaranteed than the given input will form BST, except for 2 nodes that will be wrong.
 
Example 1:
Input:
       10
     /    \
    5      8
   / \
  2   20
Output: 1
Explanation:
 
Example 2:

Input:
         11
       /    \
      3      17
       \    /
        4  10
Output: 1 
Explanation: 
By swapping nodes 11 and 10, the BST 
can be fixed.
Your Task:
You don't need to take any input. Just complete the function correctBst() that takes root node as parameter. The function should return the root of corrected BST. BST will then be checked by driver code and 0 or 1 will be printed.

Expected Time Complexity : O(Number of nodes)
Expected Auxiliary Space : O(logN), N = number of nodes
 
Constraints:
1 <= Number of nodes <= 10^5
*/

class Solution {
    Node w1 = null, w2 = null;
    public Node correctBST(Node root) {
        inorder(root);
        // System.out.println(w1.data+" "+w2.data);
        int temp = w1.data;
        w1.data = w2.data;
        w2.data = temp;
        return root;
    }
    Node prev = null;
    public void inorder(Node root) {
        if(root == null) return;
        // last = root;
        inorder(root.left);
        if(prev!=null){
            if(prev.data > root.data){
                if(w1 == null) w1 = prev;
                 w2 = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
 
