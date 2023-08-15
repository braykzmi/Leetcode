public class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // maximum reachable index
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                return false; // cannot reach current index
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            
            if (maxReach >= n - 1) {
                return true; // can reach the last index
            }
        }
        
        return false; // cannot reach the last index
    }
}
