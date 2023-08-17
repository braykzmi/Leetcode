import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<String, Double> memo;

    public double soupServings(int N) {
        if (N > 4800) {
            return 1.0;
        }

        memo = new HashMap<>();
        return dfs(N, N);
    }

    private double dfs(int A, int B) {
        if (A <= 0 && B <= 0) {
            return 0.5;
        }
        if (A <= 0) {
            return 1.0;
        }
        if (B <= 0) {
            return 0.0;
        }

        String key = A + "-" + B;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        double probability = 0.25 * (dfs(A - 100, B) + dfs(A - 75, B - 25) + dfs(A - 50, B - 50) + dfs(A - 25, B - 75));
        memo.put(key, probability);
        return probability;
    }
}
