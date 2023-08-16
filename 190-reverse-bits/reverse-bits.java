public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1; // left shift result to make space for the next bit
            result |= n & 1; // OR operation with the least significant bit of n
            n >>= 1; // right shift n to get the next bit
        }
        return result;
    }
}
