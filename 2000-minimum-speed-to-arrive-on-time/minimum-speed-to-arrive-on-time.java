class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        
        // Check if it's possible to reach the destination within the given time
        if (hour <= n - 1)
            return -1;
        
        // Binary search for the minimum speed
        int left = 1, right = 10000000; // Adjust the upper bound accordingly
        while (left < right) {
            int mid = left + (right - left) / 2;
            double totalTime = 0;
            
            for (int i = 0; i < n - 1; i++) {
                totalTime += Math.ceil((double) dist[i] / mid);
            }
            
            totalTime += (double) dist[n - 1] / mid;
            
            if (totalTime <= hour) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        // Check if the result is valid within the given time
        double totalTime = 0;
        for (int i = 0; i < n - 1; i++) {
            totalTime += Math.ceil((double) dist[i] / left);
        }
        totalTime += (double) dist[n - 1] / left;
        
        return totalTime <= hour ? left : -1;
    }
}
