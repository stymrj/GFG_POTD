/*
N horizontal line segments are arranged on the X-axis of a 2D plane. The start and end point of each line segment is given in a Nx2 matrix lines[ ][ ]. Your task is to find the maximum number of intersections possible of any vertical line with the given N line segments.

Example 1:

Input:
N = 4
lines[][] = {{1,3}, {2,3}, {1,2}, {4,4}}
Output:
3
Explanation:
A vertical line at X = 2 passes through 
{1,3}, {2,3}, {1,2}, ie three of the 
given horizontal lines.
Example 2:

Input: 
N = 3
lines[][] = {{1, 3}, {5, 6}, {3,4}}
Output:
2
Explanation: 
A vertical line at X = 3 passes through 
two of the given horizontal lines which 
is the maximum possible.
Your Task:
You dont need to read input or print anything. Complete the function maxIntersections() which takes the 2D Matrix lines[][] and the integer N as input parameters, and returns the maximum intersections possible.

Expected Time Complexity: O(N*log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105 
-109 ≤ lines[i][0] ≤ 109
lines[i][0] ≤ lines[i][1] ≤ 109


*/



class Solution {
    public int maxIntersections(int[][] lines, int N) {
    
        TreeMap<Integer, Integer> lineMap = new TreeMap<>();
        for(int[] line : lines){
            int start = line[0], end = line[1] + 1;
            lineMap.putIfAbsent(start, 0);
            lineMap.putIfAbsent(end, 0);
            lineMap.put(start, lineMap.get(start) + 1);
            lineMap.put(end, lineMap.get(end) - 1);
        }
        int res = 0, cnt = 0;
        for(Map.Entry<Integer, Integer> entry : lineMap.entrySet()){
            cnt += entry.getValue();
            res = Math.max(res, cnt);
        }
        return res;
    }
}
