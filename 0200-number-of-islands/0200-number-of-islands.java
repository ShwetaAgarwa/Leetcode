class Solution {
    public int numIslands(char[][] grid) {
         int count = 0;
 
      for(int i = 0; i < grid.length; i++) {
         for(int j = 0; j < grid[0].length; j++) {
 
            if(grid[i][j] == '1') {
               //Find all connected 1's
               countIslandHelper(grid, i, j);
               count++;
             }
         }
      }
 
      return count;
 }
 
 public static void countIslandHelper(char[][] grid, int i, int j) {
 
      if(i < 0 || j < 0 || i >= grid.length 
         || j >= grid[0].length || grid[i][j] != '1') {
 
           return;
       }
       //To mark them as visited, i put 2
       grid[i][j] = '2';
 
       //Move in 4 directions
       countIslandHelper(grid, i+1, j);
       countIslandHelper(grid, i-1, j);
       countIslandHelper(grid, i, j-1);
       countIslandHelper(grid, i, j+1);
    }
}