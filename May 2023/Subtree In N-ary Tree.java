/*
Given root of a n-ary tree find the number of duplicate subtree in the n-ary tree.
Two trees are duplicate if they have the same structure with the same node values.

Example 1:

Input:
1 N 2 2 3 N 4 N 4 4 3 N N N N N

Output: 2
Explanation: [4], [3] are duplicate subtree.
Example 2:

Input:
1 N 2 3 N 4 5 6 N N N N

Output: 0
Explanation: No duplicate subtree found.
Your Task:
You don't need to read input or print anything. Your task is to complete the function duplicateSubtreeNaryTree() which takes root of n-ary tree as input, and return an integer value as number of duplicate subtrees.

Constraints:
   1 <= n < 103
   1 <= node.key< 103


*/

class Solution{
    public int duplicateSubtreeNaryTree(Node root){
        int count = 0;
        hm = new HashMap<>();
        dfs(root);
        for(Map.Entry<String, Integer> e : hm.entrySet()){
            if(e.getValue() > 1)
                count++;
        }
        return count;
    }
    static String dfs(Node node){
        StringBuilder sb = new StringBuilder(node.data + "#");
        for(Node child : node.children){
            sb.append(dfs(child));
        }
        String s = sb.toString();
        hm.put(s, hm.getOrDefault(s, 0) + 1);
        return s;
    }
    static Map<String, Integer> hm;
}
