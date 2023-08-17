class Solution {
    public int[] countBits(int n) {
    int[] result = new int[n + 1];
    
    for (int i = 1; i <= n; i++) {
        // The number of 1's in i is equal to the number of 1's in i/2 plus the least significant bit of i
        result[i] = result[i >> 1] + (i & 1);
    }
    
    return result;
}
}