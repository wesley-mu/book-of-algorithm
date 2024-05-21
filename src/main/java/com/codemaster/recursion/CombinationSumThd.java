package com.codemaster.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 III
 * https://leetcode.cn/problems/combination-sum-iii/description/
 */
public class CombinationSumThd {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    
    public static void main(String[] args) {
        List<List<Integer>> lists = new CombinationSumThd().combinationSum3(3, 7);
        // System.out.println(lists);
    }

    /**
     * 二进制法子集枚举
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 1000000000
        for (int mask = 0; mask < (1 << 9); mask++) {
            if (check(mask, k, n)) {
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }

    public boolean check(int mask, int k, int n) {
        tempList.clear();
        for (int i = 0; i < 9; i++) {
            if (((1 << i) & mask) != 0) {
                tempList.add(i + 1);
            }
        }
        if (tempList.size() != k) {
            return false;
        }
        int sum = 0;
        for (Integer i : tempList) {
            sum += i;
        }
        return sum == n;
    }
}
