class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //We want to search the "endpoints" of each row
        //between the first row in the first column and he last row in the last column
        //we can use modulus and integer division to give us the proper row and column positions
        //
        //
        //  1  2  3  4 
        //1 0  1  2  3 
        //2 4  5  6  7 
        //3 8  9  10 11
        // so we can use a single index/position number to parse the row and column index
        // and essentially flatten to a regular binary search, while checking the ends of each row
        int colSize = matrix.length;
        int rowSize = matrix[0].length;
        int currIndex = colSize * rowSize / 2;
        int lowIndex = 0;
        int highIndex = colSize * rowSize -1;
        boolean found = false;
        while (!found && highIndex >= lowIndex){
            int currRow = currIndex / rowSize;
            int currCol = currIndex % rowSize;
            if (matrix[currRow][currCol] == target){
                found = true;
                break;
            }
            if (matrix[currRow][currCol] > target) highIndex = currIndex -1;
            else if (matrix[currRow][currCol] < target) lowIndex = currIndex + 1;
            currIndex =  lowIndex + ((highIndex - lowIndex) / 2);
        }
        return found;
        
    }
}
