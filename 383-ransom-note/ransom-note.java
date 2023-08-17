import java.util.HashMap;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomLetters = ransomNote.toCharArray();
        char[] magazineLetters = magazine.toCharArray();
        if(ransomLetters.length > magazineLetters.length){
            return false;
        }
        HashMap<Character,Integer> magazinePieces = new HashMap<Character,Integer>();
        for(char c : magazineLetters){
            if(magazinePieces.containsKey(c)){
                magazinePieces.put(c , magazinePieces.get(c)+1);
            }
            else{
                magazinePieces.put(c, 1);
            }
        }

        for(char k : ransomLetters){
            if(magazinePieces.containsKey(k) && magazinePieces.get(k) != 0){
                magazinePieces.put(k , magazinePieces.get(k)-1);
            }
            else{
                return false;
            }
        }
        return true;



    }
}