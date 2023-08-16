public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxProduct * curr, minProduct * curr));
            int tempMin = Math.min(curr, Math.min(maxProduct * curr, minProduct * curr));
            
            maxProduct = tempMax;
            minProduct = tempMin;

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
