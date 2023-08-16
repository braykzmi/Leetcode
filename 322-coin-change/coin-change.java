class Solution {
    public int coinChange(int[] coins, int amount) {
    // Create an array to store the minimum number of coins needed for each amount
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);

    // The number of coins needed to make amount 0 is always 0
    dp[0] = 0;

    // Calculate the minimum number of coins needed for each amount from 1 to amount
    for (int i = 1; i <= amount; i++) {
        // Try using each coin denomination to make the current amount
        for (int coin : coins) {
            if (coin <= i) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }

    // If dp[amount] is still amount + 1, it means it's not possible to make the amount using the given coins
    return dp[amount] > amount ? -1 : dp[amount];
}

}