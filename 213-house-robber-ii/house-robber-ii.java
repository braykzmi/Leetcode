public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        // Rob the first house to the second-to-last house
        int max1 = robRange(nums, 0, nums.length - 2);
        
        // Rob the second house to the last house
        int max2 = robRange(nums, 1, nums.length - 1);
        
        return Math.max(max1, max2);
    }
    
    private int robRange(int[] nums, int start, int end) {
        int prevMax = 0;
        int currMax = 0;
        
        for (int i = start; i <= end; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
        
        return currMax;
    }
}
