class Solution {
    public void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    
    boolean firstRowHasZero = false;
    boolean firstColHasZero = false;
    
    // Check if the first row contains a zero
    for (int j = 0; j < cols; j++) {
        if (matrix[0][j] == 0) {
            firstRowHasZero = true;
            break;
        }
    }
    
    // Check if the first column contains a zero
    for (int i = 0; i < rows; i++) {
        if (matrix[i][0] == 0) {
            firstColHasZero = true;
            break;
        }
    }
    
    // Use the first row and column as flags, set matrix[i][j] = 0 if matrix[i][j] = 0
    for (int i = 1; i < rows; i++) {
        for (int j = 1; j < cols; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;  // Set the corresponding row flag
                matrix[0][j] = 0;  // Set the corresponding column flag
            }
        }
    }
    
    // Set the entire row to 0 if the flag in the first column is set
    for (int i = 1; i < rows; i++) {
        if (matrix[i][0] == 0) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    
    // Set the entire column to 0 if the flag in the first row is set
    for (int j = 1; j < cols; j++) {
        if (matrix[0][j] == 0) {
            for (int i = 1; i < rows; i++) {
                matrix[i][j] = 0;
            }
        }
    }
    
    // Set the first row to 0 if necessary
    if (firstRowHasZero) {
        for (int j = 0; j < cols; j++) {
            matrix[0][j] = 0;
        }
    }
    
    // Set the first column to 0 if necessary
    if (firstColHasZero) {
        for (int i = 0; i < rows; i++) {
            matrix[i][0] = 0;
        }
    }
}

}