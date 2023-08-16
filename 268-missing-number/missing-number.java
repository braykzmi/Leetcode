class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2; // Sum of numbers from 0 to n
        
        for (int num : nums) {
            sum -= num; // Subtract each number from the sum
        }
        
        return sum; // The remaining sum is the missing number
    }
}
