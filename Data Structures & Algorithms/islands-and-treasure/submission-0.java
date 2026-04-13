class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int ROWS = grid.length, COLS = grid[0].length;
        for(int r = 0; r < ROWS;r++){//add all gates to queue
            for(int c = 0; c < COLS;c++){
                if(grid[r][c] == 0){
                    queue.add(new int[] {r,c});
                }
            }
        }
        if (queue.size()==0){
            return;
        }
        int[][] dirs = { {-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int[] dir :dirs){//search from all directions
                int r = cell[0] + dir[0];
                int c = cell[1] + dir[1];
                if (r >= ROWS || c >= COLS || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE){// if out of bounds or not a path
                    continue;// skip to next iteration
                }
            
            queue.add(new int[] {r, c});

            grid[r][c] = grid[cell[0]][cell[1]] +1;//increment possible path by 1
            }
        }
    }
}

//we use a queue to store the gates
//we perform a BFS on each gate, setting the adjacent unoccupied cells incrementally outward from the gate
