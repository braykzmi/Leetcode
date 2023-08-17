class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCounts = new int[26];
        int maxCount = 0; // tracks the count of the most frequent character
        int maxLength = 0; // tracks the length of the longest substring
        
        int start = 0; // start of the sliding window
        for (int end = 0; end < s.length(); end++) {
            charCounts[s.charAt(end) - 'A']++; // increment the count of the current character
            maxCount = Math.max(maxCount, charCounts[s.charAt(end) - 'A']); // update maxCount
            
            // calculate the number of characters that need to be replaced
            int replaceCount = (end - start + 1) - maxCount;
            
            // if the number of characters to be replaced is greater than k, move the window
            if (replaceCount > k) {
                charCounts[s.charAt(start) - 'A']--; // decrement the count of the character at start
                start++; // move the start of the window
            }
            
            // update maxLength if the current substring is longer
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
