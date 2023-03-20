/*
Give a N*M grid of characters 'O', 'X', and 'Y'. Find the minimum Manhattan distance between a X and a Y.

Manhattan Distance :
| row_index_x - row_index_y | + | column_index_x - column_index_y |


Example 1:

Input:
N = 4, M = 4
grid  = {{X, O, O, O}
         {O, Y, O, Y}
         {X, X, O, O}
         {O, Y, O, O}}
Output:
1
Explanation:
{{X, O, O, O}
{O, Y, O, Y}
{X, X, O, O}
{O, Y, O, O}}
The shortest X-Y distance in the grid is 1.
One possible such X and Y are marked in bold
in the above grid.
Example 2:

Input:
N = 3, M = 3
grid = {{X, X, O}
        {O, O, Y}
        {Y, O, O}}
Output :
2
Explanation:
{{X, X, O}
 {O, O, Y}
 {Y, O, O}}
The shortest X-Y distance in the grid is 2.
One possible such X and Y are marked in bold
in the above grid.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function shortestXYDist() which takes two integers N, and M and an 2D list of size N*M as input and returns the shortest Manhattan Distance between a X and a Y.

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(N*M)


Constraints:
1 ≤ N, M ≤ 103  

There exists at least one 'X' and at least one 'Y' in the grid.
*/

class x
{
    int a,b,c;
}
class Solution {
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int n,int m) {
        Queue<x> q=new LinkedList<>();
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid.get(i).get(j)=='X')
                {
                    x f=new x();
                    f.a=i;f.b=j;f.c=0;
                    q.add(f);
                    vis[i][j]=true;
                }
                
            }
        }
        while(!q.isEmpty())
        {
            x f=q.poll();
            if(grid.get(f.a).get(f.b)=='Y')
            return f.c;
            if(f.a+1<n && !vis[f.a+1][f.b])
            {
                x g=new x();
                g.a=f.a+1;g.b=f.b;g.c=f.c+1;
                q.add(g);
                vis[g.a][g.b]=true;
            }
            if(f.b+1<m && !vis[f.a][f.b+1])
            {
                x g=new x();
                g.a=f.a;g.b=f.b+1;g.c=f.c+1;
                q.add(g);
                vis[g.a][g.b]=true;
            }
            if(f.a-1>=0 && !vis[f.a-1][f.b])
            {
                x g=new x();
                g.a=f.a-1;g.b=f.b;g.c=f.c+1;
                q.add(g);
                vis[g.a][g.b]=true;
            }
            if(f.b-1>=0 && !vis[f.a][f.b-1])
            {
                x g=new x();
                g.a=f.a;g.b=f.b-1;g.c=f.c+1;
                q.add(g);
                vis[g.a][g.b]=true;
            }
        }
        return -1;
    }
};
