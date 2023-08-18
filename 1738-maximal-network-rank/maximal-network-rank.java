class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] roadCounts = new int[n];
        boolean[][] isConnected = new boolean[n][n];
        
        for (int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];
            
            roadCounts[city1]++;
            roadCounts[city2]++;
            
            isConnected[city1][city2] = true;
            isConnected[city2][city1] = true;
        }
        
        int maxRank = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = roadCounts[i] + roadCounts[j];
                if (isConnected[i][j]) {
                    rank--; // Avoid counting the same road twice
                }
                maxRank = Math.max(maxRank, rank);
            }
        }
        
        return maxRank;
    }
}
