class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int ROWS = grid.length, COLS = grid[0].length;
        int time = 0,fresh = 0;
        for(int r = 0; r < ROWS;r++){
            for(int c = 0; c < COLS;c++){
                if (grid[r][c] == 2){
                    queue.add(new int[]{r,c});
                } else if (grid[r][c] ==1){
                    fresh++;
                }
            }
        }

        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        while(fresh > 0 && !queue.isEmpty()){
            int length = queue.size();
            for (int i = 0; i < length;i++){
                int[] cell = queue.poll();
                for(int[] dir : dirs){
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];
                    if(row >= ROWS || col >= COLS || row < 0 || col < 0 || grid[row][col] != 1){
                        continue;
                    }
                    grid[row][col] = 2;
                    queue.add(new int[]{row,col});
                    fresh--;
                    }
                }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
