class Solution {
    int rows, columns;
    Set<Pair<Integer,Integer>> seen = new HashSet<>();

    public boolean exist(char[][] board, String word) {
    rows = board.length;
    columns = board[0].length;
    for (int row = 0; row < rows;row++){
        for (int column = 0; column < columns;column++){
            if (dfs(board,0,word,row,column)){
                return true;
            }
        }
    }
    return false;
    }
    private boolean dfs(char[][] board,int index,String word, int row, int column){
        if (index == word.length()){
            return true;
        }

        if (row < 0 || column < 0 || row >= rows || column >= columns || board[row][column] != word.charAt(index) || seen.contains(new Pair<>(row,column))){
            return false;
        }


        seen.add(new Pair<>(row,column));
        boolean res = (dfs(board,index+1,word,row + 1, column) 
        || dfs(board,index+1,word,row -1, column)
        || dfs(board,index+1,word,row, column +1)  
        || dfs(board,index+1,word,row, column -1));
        seen.remove(new Pair<>(row,column));

        return res;
    }
}
// we can try storing each path in a hashset after we evaluate if a square is in a word or not