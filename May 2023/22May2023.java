class Solution {
    public static int solve(int N, int[] p) {
        // code here
        int con[] = new int[N];
        for(int i=1; i<N ;i++)
        {
            con[i]++; con[p[i]]++;
        }
        int ans=0; //leaf
        for(int x : con)
        if(x==1) ans++;
        
        return N-ans-1;
    }
}
