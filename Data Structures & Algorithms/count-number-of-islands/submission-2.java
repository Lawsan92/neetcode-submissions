class Solution {
    private final int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int c = 0; c < grid.length; c++) { // c = COL, r = ROW
            for (int r = 0; r < grid[c].length; r++) {
                boolean land_cell = grid[c][r] == '1';
                if (land_cell) {
                    dfs(grid, c, r);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs (char[][] grid, int c, int r) {
        char[] row = grid[0];
        boolean x_outOfBounds = r < 0 || r >= row.length;
        boolean y_outOfBounds = c < 0 || c >= grid.length;
        boolean not_land = !x_outOfBounds && !y_outOfBounds && grid[c][r] == '0';
        if (x_outOfBounds || y_outOfBounds || not_land) {
            return;
        }
        grid[c][r] = '0';
        for (int [] dir: directions) {
            dfs(grid, c + dir[0], r + dir[1]);
        }
    }
}

/*

CORE IDEA:

// when reaching a land cell
  // check all neighboring cells to see if ther are also land cells
  // mark on the map that land cells have been visited to avoid double counting



  [       v                             
    ["0","1","1","1","0"],              
    ["0","1","0","1","0"],                          
    ["1","1","0","0","0"],                                      
    ["0","0","0","0","0"]                                           
  ]             

  DOWN: 0|1, 1|1, 2|1, 3|1...

    [                               
    ["0","0","1","1","0"],              
    ["0","0","0","1","0"],                          
    ["1","0","0","0","0"],                                      
          v
    ["0","0","0","0","0"]    

  DOWN: 0|1, 1|1, 2|1, 3|1...

    [                               
    ["0","0","1","1","0"],              
    ["0","0","0","1","0"],                          
          v
    ["1","0","0","0","0"],                                      
    ["0","0","0","0","0"]    
  ]                          

NEXT etc..
*/
