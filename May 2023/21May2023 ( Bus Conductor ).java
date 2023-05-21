class Solution {
    public static int findMoves(int n, int[] chairs, int[] passengers) {
        // code here
        int s=0,p=0;
     Arrays.sort(chairs);
     Arrays.sort(passengers);
     for(int i=0;i<n;i++)
        s+=(int)Math.abs(chairs[i]-passengers[i]);
        return s;
        
    }
}
