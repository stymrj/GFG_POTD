class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        int ans=0;
        for(int i=1;i<N-1;i++){
            for(int j=1;j<M-1;j++){
                if(matrix[i][j]==1){
                    if(dfs(i,j,N,M,matrix)){
                        ans++;
                       
                    }
                }
            }
        }
        return ans;
    }
    boolean dfs(int i ,int j,int N ,int M ,int[][] matrix){
        if(i==0 || j==0 || i==N-1 || j==M-1){
            if(matrix[i][j]==1)return false;
            return true;
        }
        matrix[i][j]=0;
        boolean up=true,down=true,left=true,right=true;
        if(i+1<N && matrix[i+1][j]==1 ){
            up=dfs(i+1,j,N,M,matrix);
        }
        if(i-1>=0 && matrix[i-1][j]==1){
            down=dfs(i-1,j,N,M,matrix);
        }
        if(j+1<M && matrix[i][j+1]==1)right=dfs(i,j+1,N,M,matrix);
        if(j-1>=0 && matrix[i][j-1]==1)left=dfs(i,j-1,N,M,matrix);
        return left &&  right && up && down;
    }
}
