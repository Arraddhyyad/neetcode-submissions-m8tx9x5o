class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        Arrays.fill(memo, -2);
        return dfs(amount, memo, coins);
    }

    public int dfs(int amount, int[] memo, int[] coins){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(memo[amount]!=-2) return memo[amount];

        int best = Integer.MAX_VALUE;

        for(int coin:coins){
            int res = dfs(amount-coin, memo, coins);
            if(res!=-1)
                best = Math.min(best, 1+res);
        }

        memo[amount] = (best==Integer.MAX_VALUE)?-1:best;
        return memo[amount];
    }
}
