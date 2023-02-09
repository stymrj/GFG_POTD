/*
There are M job applicants and N jobs.  Each applicant has a subset of jobs that he/she is interested in. Each job opening can only accept one applicant and a job applicant can be appointed for only one job. Given a matrix G with M rows and N columns where G(i,j) denotes ith applicant is interested in the jth job. Find the maximum number of applicants who can get the job.

Example 1:

Input: 
M = 3, N = 5
G = {{1,1,0,1,1},{0,1,0,0,1},
{1,1,0,1,1}}
Output: 3
Explanation: There is one of the possible
assignment-
First applicant gets the 1st job.
Second applicant gets the 2nd job.
Third applicant gets the 4th job.
Example 2:

Input:
M = 6, N = 2
G = {{1,1},{0,1},{0,1},{0,1},
{0,1},{1,0}}
Output: 2
Explanation: There is one of the possible
assignment-
First applicant gets the 1st job.
Second applicant gets the 2nd job.
 

Your Task:
You don't need to read to print anything. Your task is to complete the function maximumMatch() which takes matrix G as input parameter and returns the maximum number of applicants who can get the job.

Expected Time Complexity: O(N3).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N, M ≤ 100
*/

class Solution
{
    public boolean IsValid(int j, boolean[] vis, int[][] G, int[] assign){
        for(int i=0;i<G[0].length;i++){
            if(G[j][i]==1 && !vis[i]){
                vis[i] = true;
                
                if(assign[i]==-1 || IsValid(assign[i], vis, G, assign)){
                    assign[i]=j;
                    return true;
                }
            }
        }
        return false;
    }
    public int maximumMatch(int[][] G)
    {
        // Code here
        int m= G[0].length;
        int n = G.length;
        int count=0;
        
        
        int[] assign = new int[m];
        Arrays.fill(assign, -1);
        
        for(int i=0;i<n;i++){
            boolean[] vis = new boolean[m]; 
            if(IsValid(i, vis, G, assign)){
                count++;
            }
        }
        
        return count;
    }
}
