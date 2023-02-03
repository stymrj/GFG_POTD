/*
Given a binary matrix of dimensions  with R rows and C columns. Start from cell(0, 0), moving in the right direction. Perform the following operations: 

If the value of matrix[i][j] is 0, then traverse in the same direction and check the next value.
If the value of matrix[i][j] is 1, then update matrix[i][j] to 0 and change the current direction clockwise. ie - up, right, down, or left directions change to right, down, left, and up respectively.
Find the index of the cell where you will be forced to exit the matrix while performing the given traversal. 

Example 1:

Input:
matrix[][] = {{0,1},
              {1,0}}
R=2
C=2

Output: (1,1)
Explanation:




Example 2:

Input: 
matrix[][] = {{0, 1, 1, 1, 0},
                   {1, 0, 1, 0, 1},
              {1, 1, 1, 0, 0}}
R=4
C=4

Output: (2,0)
Explanation: We will leave the grid after visiting the index (2,0).
 

Your Task:
You don't need to read input or print anything. Complete the function endPoints() which take  a 2D matrix[][] , an integer R and an integer C as  input parameter and returns the index of the last cell before exiting the matrix. 

Expected Time Complexity: O(N)
Expected Space Complexity: O(1)

Constrains:
1<= R,C<=1000
0<= matrix[i][j] <=1
*/

class Solution{
    static boolean issafe(int m, int n, int i, int j)
    {
     
      // Cases for invalid cells
      if (i < 0)
        return false;
      if (j < 0)
        return false;
      if (i >= m)
        return false;
      if (j >= n)
        return false;
     
      // Return true if valid
      return true;
    }
     
    // Function to find indices of cells
    // of a matrix from which traversal
    // leads to out of the matrix
    static int [] endPoints(int [][]arr, int m, int n){
     
      // Starting from cell (0, 0),
      // traverse in right direction
      int i = 0;
      int j = 0;
      int current_i = 0;
      int current_j = 0;
     
      char current_d = 'r';
     
      // Stores direction changes
      Map<Character,Character> rcd = new HashMap<>();
      rcd.put('l', 'u');
      rcd.put('u', 'r');
      rcd.put('r', 'd');
      rcd.put('d', 'l');
     
      // Iterate until the current cell
      // exceeds beyond the matrix
      while (issafe(m, n, i, j)){
     
        // Current index
        current_i = i;
        current_j = j;
     
        // If the current cell is 1
        if (arr[i][j] == 1){
     
          char move_in = rcd.get(current_d);
     
          // Update arr[i][j] = 0
          arr[i][j] = 0;
     
          // Update indices according
          // to the direction
          if (move_in == 'u')
            i -= 1;
          else if(move_in == 'd')
            i += 1;
          else if(move_in == 'l')
            j -= 1;
          else if(move_in == 'r')
            j += 1;
     
          current_d = move_in;
     
        }
     
        // Otherwise
        else{
          // Update indices according
          // to the direction
          if (current_d == 'u')
            i -= 1;
          else if(current_d == 'd')
            i += 1;
          else if(current_d == 'l')
            j -= 1;
          else if(current_d == 'r')
            j += 1;
        }
      }
     
      // The exit cooridnates
      return new int[]{current_i, current_j};
     
    }
}
