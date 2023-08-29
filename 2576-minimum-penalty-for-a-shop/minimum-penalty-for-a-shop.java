class Solution {
    public int bestClosingTime(String customers) {
        int max_sc = 0, sc = 0, bestHour = -1;
        for(int i = 0; i < customers.length(); ++i) {
            sc += (customers.charAt(i) == 'Y') ? 1 : -1;
            if(sc > max_sc) {
                max_sc = sc;
                bestHour = i;
            }
        }
        return bestHour + 1;

    }
}