class Solution {
    int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};//used to traverse adjacent cells
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length,COLS = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] atlantic = new boolean[ROWS][COLS];
        boolean[][] pacific = new boolean[ROWS][COLS];
        for(int c = 0; c < COLS;c++){
            dfs(heights,pacific,0,c);
            dfs(heights,atlantic,ROWS-1,c);   
        }
        for(int r = 0; r < ROWS;r++){
            dfs(heights,pacific,r,0);
            dfs(heights,atlantic,r,COLS-1);
        }// run dfs on both borders for their respective oceans
        for(int r = 0; r < ROWS;r++){
            for(int c = 0; c < COLS;c++){
                if (pacific[r][c] && atlantic[r][c]){
                    result.add(new ArrayList(Arrays.asList(r,c)));
                }
            }
        }
        return result;
    }
    public void dfs(int[][] heights,boolean[][] ocean,int row, int col){
        ocean[row][col] = true;
        for(int[] dir : directions){
            int nr = row + dir[0], nc = col + dir[1];
            if (nr >= 0  && nc>= 0 && nr < heights.length && nc < heights[0].length && !ocean[nr][nc] && heights[nr][nc] >= heights[row][col] )//within range, next row is >= and isn't already false
            dfs(heights,ocean,nr,nc);
        }
    }
}
//cells need to have a path between them and both oceans, ie along the last column and row for atlantic, first row and column for pacific
//