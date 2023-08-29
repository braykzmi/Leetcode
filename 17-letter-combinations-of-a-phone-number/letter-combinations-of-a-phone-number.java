import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
        
        generateCombinations(result, digitToLetters, digits, "", 0);
        return result;
    }
    
    private void generateCombinations(List<String> result, Map<Character, String> digitToLetters, String digits, String current, int index) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        
        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);
        for (char letter : letters.toCharArray()) {
            generateCombinations(result, digitToLetters, digits, current + letter, index + 1);
        }
    }
}
