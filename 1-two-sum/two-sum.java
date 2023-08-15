import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complementMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (complementMap.containsKey(complement)) {
                return new int[] {complementMap.get(complement), i};
            }
            
            complementMap.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }
}
