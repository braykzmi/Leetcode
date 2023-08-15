import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int requiredCount = targetFreq.size(); 
        int left = 0, right = 0; 
        int formed = 0; 
        int[] windowCounts = new int[128]; 
        int minLength = Integer.MAX_VALUE;
        int start = 0; 

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            windowCounts[currentChar]++;

            if (targetFreq.containsKey(currentChar) && windowCounts[currentChar] == targetFreq.get(currentChar)) {
                formed++;
            }

            while (left <= right && formed == requiredCount) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                windowCounts[leftChar]--;

                if (targetFreq.containsKey(leftChar) && windowCounts[leftChar] < targetFreq.get(leftChar)) {
                    formed--;
                }

                left++; 
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
