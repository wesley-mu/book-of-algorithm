package com.codemaster.greedy;

/**
 * 跳跃游戏II
 * https://leetcode.cn/problems/jump-game-ii/description/
 */
public class JumpGameSec {
    /**
     * 正向查找可到达的最大位置
     *
     * @param nums
     * @return
     */
    public int jump (int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int steps = new JumpGameSec().jump(new int[]{2, 3, 1, 2, 4, 2, 3});
        System.out.println(steps);
    }
}
