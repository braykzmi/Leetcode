import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> charCount = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        int longestPalindromeLength = 0;
        boolean hasOddCount = false;
        
        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                longestPalindromeLength += count;
            } else {
                longestPalindromeLength += count - 1;
                hasOddCount = true;
            }
        }
        
        if (hasOddCount) {
            longestPalindromeLength++;
        }
        
        return longestPalindromeLength;
    }
}
