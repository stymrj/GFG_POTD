/*
Geeks Island is represented by an N * M matrix mat. The island is touched by the Indian Ocean from the top and left edges and the Arabian Sea from the right and bottom edges. Each element of the matrix represents the height of the cell.

Due to the rainy season, the island receives a lot of rainfall, and the water can flow in four directions(up, down, left, or right) from one cell to another one with height equal or lower.

You need to find the number of cells from where water can flow to both the Indian Ocean and the Arabian Sea.

Example 1:

Input:
N = 5, M = 5
mat[][] =    {{1, 3, 3, 2, 4},
               {4, 5, 6, 4, 4},
               {2, 4, 5, 3, 1},
               {6, 7, 1, 4, 5},
               {6, 1, 1, 3, 4}}
Output:
8
Explanation:
Indian    ~   ~   ~   ~   ~
Ocean  ~  1   3   3   2  (4) *
        ~  4   5  (6) (4) (4) *
        ~  2   4  (5)  3   1  *
        ~ (6) (7)  1   4   5  *
        ~ (6)  1   1   3   4  *           
           *   *   *   *   * Arabian Sea
Water can flow to both ocean and sea from the cells
denoted by parantheses().For example at index(1,2), the height of that island is 6. If a water drop falls on that island, water can flow to up direction(as 3<=6) and reach to Indian Ocean. ALso, water can flow to right direction(as 6>=4>=4) and reach to Arabian Sea.
Example 2:

Input:
N = 2, M = 3
mat[][] =    {{1, 1, 1},
               {1, 1, 1}}
Output:
6 
Explanation:
Water can flow from all cells to both Indian Ocean and Arabian Sea as the height of all islands are same.
Your Task:

Your task is to complete the function water_flow() which takes an integer array mat, integer N and integer M as the input parameter and returns an integer, denoting the number of cells from which water can to both ocean and sea.

Expected Time Complexity : O(N*M)
Expected Auxiliary Space : O(N*M)

Constraints:

1 <= N, M <= 103
1 <= mat[i][j] <= 106
*/

class Pair{

    int row;

    int col;

    Pair(int row, int col){

        this.row = row;

        this.col = col;

    }

}

class Solution{

 int water_flow(int [][] mat, int N, int M) {

 int [][] IndianOcean = new int[N][M];

 int [][] ArabicOcean = new int[N][M];

 Queue<Pair> queue = new LinkedList<>();

 Queue<Pair> queue2 = new LinkedList<>();

 int count = 0;

 for(int i=0; i< N; i++){

     for(int j=0; j< M; j++){

         if(i==0 || j == 0){

             queue.add(new Pair(i, j));

             IndianOcean[i][j] = 1;

         }

         if(i == N-1 || j == M-1) {

             ArabicOcean[i][j] = 1;

             queue2.add(new Pair(i,j));

         }

     }

 }

 int []delRow = {-1, 0, 1, 0};

 int []delCol = {0, 1, 0, -1};

 while(!queue.isEmpty()){

     Pair pair = queue.remove();

     for(int i=0; i< 4; i++){

         int NRow = delRow[i] + pair.row;

         int NCol = delCol[i] + pair.col;

         if(NRow >= 0 && NRow < N && NCol >= 0 && NCol < M &&

         IndianOcean[NRow][NCol] == 0 && mat[NRow][NCol] >= mat[pair.row][pair.col]){

             IndianOcean[NRow][NCol] = 1;

             queue.add(new Pair(NRow, NCol));

         }

     }

 }

 

 while(!queue2.isEmpty()){

     Pair pair = queue2.remove();

     for(int i=0; i< 4; i++){

         int NRow = delRow[i] + pair.row;

         int NCol = delCol[i] + pair.col;

         if(NRow >= 0 && NRow < N && NCol >= 0 && NCol < M &&

         ArabicOcean[NRow][NCol] == 0 && mat[NRow][NCol] >= mat[pair.row][pair.col]){

             ArabicOcean[NRow][NCol] = 1;

             queue2.add(new Pair(NRow, NCol));

         }

     }

 }

 

 for(int i=0; i< N; i++){

     for(int j=0; j< M; j++){

         if(ArabicOcean[i][j] == 1 && IndianOcean[i][j] == 1) count++;

     }

 }

 return count;

 }

}
