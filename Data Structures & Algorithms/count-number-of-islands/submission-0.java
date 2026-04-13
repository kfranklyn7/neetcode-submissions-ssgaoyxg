class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int islands = 0;

        for(int r = 0; r < rows;r++){
            for(int c = 0; c < columns;c++){
                if (grid[r][c] == '1'){
                    dfs(grid,r,c);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void dfs(char[][] grid,int row,int column){
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == '0'){
            return;
        }
        grid[row][column] = '0';//we set the current cell to 0 as a way of visiting

        dfs(grid,row + 1, column);
        dfs(grid,row -1, column);
        dfs(grid,row,column + 1);
        dfs(grid,row,column -1);


    }
}
