class Solution {
    boolean[][] seen; // boolean array to keep track of visited islands

    public int numIslands(char[][] grid) {
        // Keep count of how many unique islands we have seen
        int islands = 0;
        
        // when we encounter a new island, we will map it with dfs, and 
        // update a boolean array to represent the island
        seen = new boolean[grid.length][grid[0].length];
        
        // iterate through the grid
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]=='1'&&!seen[i][j]){
                    islands++;
                    // dfs map of our newly discovered island
                    connect(i, j, grid);
                }
            }
        }
        return islands;
    }
    
    // DFS function to map out the island
    public void connect(int x, int y, char[][] grid){
        if(seen[x][y]){return;}
        seen[x][y]=true;
        //Check all directions.
        if(x-1 >= 0 && !seen[x-1][y] && grid[x-1][y]=='1'){
            connect(x-1, y, grid);
        }
        if(y-1 >= 0 && !seen[x][y-1] && grid[x][y-1]=='1'){
            connect(x, y-1, grid);
        }
        if(x+1 < grid.length && !seen[x+1][y] && grid[x+1][y]=='1'){
            connect(x+1, y, grid);
        }
        if(y+1 < grid[0].length && !seen[x][y+1] && grid[x][y+1]=='1'){
            connect(x, y+1, grid);
        }

    }
}
