class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create sets to store seen digits in rows, columns, and sub-grids
        Set<String> seen = new HashSet<>();
        
        // Traverse the entire board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentChar = board[i][j];
                if (currentChar != '.') {
                    // Check if the current digit has already been seen in the same row, column, or sub-grid
                    if (!seen.add(currentChar + " found in row " + i) ||
                        !seen.add(currentChar + " found in column " + j) ||
                        !seen.add(currentChar + " found in sub-grid " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
