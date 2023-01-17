class Solution {
    int ans,curr;
    int maxGCD(Node root) {
        // code here 
        if(root==null)return -1;
        ans=0;
        curr=0;
        fun(root);
        return ans;
    }
    void fun(Node root)
    {
        if(root!=null){
            if(root.left!=null && root.right!=null){
                int gcd=gcd(root.left.data,root.right.data);
                if(gcd>curr){
                    curr=gcd;
                    ans=root.data;
                }else if(gcd==curr){
                    ans=Math.max(ans,root.data);
                }
            }
            fun(root.left);
            fun(root.right);
        }
    }
    int gcd(int a,int b)
    {
        if(b==0)return a;
        return gcd(b,a%b);
    }
}
