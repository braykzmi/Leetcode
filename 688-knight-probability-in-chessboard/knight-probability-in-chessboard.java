public class Solution {
    private static final int[][] DIRECTIONS = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] memo = new double[N][N][K + 1];
        return findProbability(N, K, r, c, memo);
    }
    
    private double findProbability(int N, int K, int r, int c, double[][][] memo) {
        if (r < 0 || r >= N || c < 0 || c >= N) return 0.0;
        if (K == 0) return 1.0;
        if (memo[r][c][K] > 0) return memo[r][c][K];
        
        double probability = 0.0;
        for (int[] direction : DIRECTIONS) {
            int newRow = r + direction[0];
            int newCol = c + direction[1];
            probability += 0.125 * findProbability(N, K - 1, newRow, newCol, memo);
        }
        
        memo[r][c][K] = probability;
        return probability;
    }
}
