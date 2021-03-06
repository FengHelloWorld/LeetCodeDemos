package com.hzf.leetcode._322coinChange;

/**
 * Created by zf.huang on 2018.12.7
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class Solution {

    public static void main(String[] args) {
        int[] coins = {346, 29, 395, 188, 155, 109};
        int amount = 9401;
        System.out.println(new Solution().coinChange(coins, amount));
    }

    private final int maxValue = 100000000;

    private int[][] cache;

    private int coinChange(int[] coins, int amount) {
        cache = new int[amount + 1][coins.length];
        int res = change(coins, amount, 0);
        if (res < maxValue) return res;
        else return -1;
    }

    private int change(int[] coins, int amount, int index) {
        if (amount < 0 || index >= coins.length) return maxValue;
        if (cache[amount][index] != 0) return cache[amount][index];
        if (amount == 0) return 0;
        int a = change(coins, amount - coins[index], index) + 1;
        int b = change(coins, amount, index + 1);
        cache[amount][index] = Math.min(a, b);
        return cache[amount][index];
    }


//    private int coinChange(int[] coins, int amount) {
//        if (amount == 0) return 0;
//        int[] ans = new int[amount + 1];
//        for (int coin : coins) {
//            if (coin > amount) continue;
//            ans[coin] = 1;
//        }
//        for (int i = 1; i <= amount; ++i) {
//            if (ans[i] != 0) continue;
//            int min = Integer.MAX_VALUE;
//            for (int coin : coins) {
//                if (i - coin <= 0 || ans[i - coin] == 0) continue;
//                min = Math.min(min, ans[i - coin] + 1);
//            }
//            min = min == Integer.MAX_VALUE ? 0 : min;
//            ans[i] = min;
//        }
//        return ans[amount] == 0 ? -1 : ans[amount];
//    }

}
