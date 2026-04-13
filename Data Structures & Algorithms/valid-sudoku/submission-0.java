class Solution {
    public boolean isValidSudoku(char[][] board) {
        //intuition: use a set, use multiple sets? use a set per row? use a set per column? too much space complexity?
        // Something similar to anagrams involving a sets nested inside the hashmap
        Map<Integer,Set<Character>> rows = new HashMap<>();
        Map<Integer,Set<Character>> columns = new HashMap<>(); 
        Map<String,Set<Character>> squares = new HashMap<>();
        for (int index = 0; index < board.length;index++){
            for (int index2 = 0; index2 < board.length; index2++){
                if (board[index][index2] == '.'){
                    continue;
                }//continue to next row/column if . is present
                String sk = (index/ 3) + "," + (index2/3);
                if (rows.computeIfAbsent(index , k -> new HashSet<>()).contains(board[index][index2])
                || columns.computeIfAbsent(index2 , k -> new HashSet<>()).contains(board[index][index2]) 
                || squares.computeIfAbsent(sk , k -> new HashSet<>()).contains(board[index][index2])){
                    return false;
                }
                rows.get(index).add(board[index][index2]);
                columns.get(index2).add(board[index][index2]);
                squares.get(sk).add(board[index][index2]);

            }
        }
        return true;
         
    }     
}
