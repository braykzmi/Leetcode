public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] lengths = new int[n]; // Length of longest increasing subsequence ending at index i
        int[] counts = new int[n];  // Number of longest increasing subsequences ending at index i
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);

        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j]; // Restart count, as we found a longer LIS
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j]; // Add count of LIS with the same length
                    }
                }
            }
            maxLength = Math.max(maxLength, lengths[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLength) {
                result += counts[i];
            }
        }

        return result;
    }
}
