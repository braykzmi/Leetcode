class Solution {
   public int findPoisonedDuration(int[] timeSeries, int duration) {
    if (timeSeries == null || timeSeries.length == 0) {
        return 0;
    }
    int totalPoisonedTime = 0;

    for (int i = 1; i < timeSeries.length; i++) {
        int timeDifference = timeSeries[i] - timeSeries[i - 1];
        totalPoisonedTime += Math.min(timeDifference, duration);
    }
    totalPoisonedTime += duration;
    return totalPoisonedTime;
    }
}
