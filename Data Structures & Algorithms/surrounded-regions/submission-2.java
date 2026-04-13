class Solution {
    public void solve(char[][] board) {
        // recursively check the border of the board to see if any of the Os are connected to one
        // on the outer edge which indicates it is not able to be surrounded by marking it T
        for(int r= 0;r < board.length;r++){
            if(board[r][0] == 'O'){
            unsurround(board,r,0);
            }
            if(board[r][board[0].length-1]=='O'){
            unsurround(board,r,board[0].length-1);
            }
        }
        for(int c= 0;c < board[0].length;c++){
            if(board[0][c]=='O')
            {
                unsurround(board,0,c);
                }
            if(board[board.length-1][c]=='O')
            {
                unsurround(board,board.length-1,c);
            }
        }
        //We mark every O as X indicating we captured it and
        // any T is marked O to indicate it wasn't captured
        for(int r=0;r < board.length;r++){
            for(int c=0;c < board[0].length;c++){
                if(board[r][c] == 'O'){
                    board[r][c] ='X';
                }
                if(board[r][c] == 'T'){
                    board[r][c] ='O';
                }
            }
        }

        
    }
    public void unsurround(char[][] board,int r,int c){
        if (r >= board.length || c >= board[0].length || r < 0 || c < 0 || board[r][c] != 'O'){
            return;
        }
        board[r][c] = 'T';
        unsurround(board,r+1,c);
        unsurround(board,r-1,c);
        unsurround(board,r,c+1);
        unsurround(board,r,c-1);
    }
}
