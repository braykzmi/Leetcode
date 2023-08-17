import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];

        // DFS from the top and left borders (Pacific)
        for (int i = 0; i < m; i++) {
            dfs(matrix, canReachPacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, canReachAtlantic, Integer.MIN_VALUE, i, n - 1);
        }

        // DFS from the bottom and right borders (Atlantic)
        for (int i = 0; i < n; i++) {
            dfs(matrix, canReachPacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, canReachAtlantic, Integer.MIN_VALUE, m - 1, i);
        }

        // Find the common cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }

        return result;
    }

    private void dfs(int[][] matrix, boolean[][] canReach, int prevHeight, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Check if the cell is out of bounds or already visited
        if (row < 0 || row >= m || col < 0 || col >= n || canReach[row][col] || matrix[row][col] < prevHeight) {
            return;
        }

        // Mark the cell as reachable
        canReach[row][col] = true;

        // Perform DFS on neighboring cells
        dfs(matrix, canReach, matrix[row][col], row + 1, col);
        dfs(matrix, canReach, matrix[row][col], row - 1, col);
        dfs(matrix, canReach, matrix[row][col], row, col + 1);
        dfs(matrix, canReach, matrix[row][col], row, col - 1);
    }
}
