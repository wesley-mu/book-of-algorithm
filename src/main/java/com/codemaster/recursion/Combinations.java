package com.codemaster.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * https://leetcode.cn/problems/combinations/
 */
public class Combinations {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public static void main(String[] args) {
        List<List<Integer>> result = new Combinations().combine(4, 2);
        System.out.println(result);
    }

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return result;
    }

    public void dfs(int cur, int n, int k) {
        // temp长度加上区间[cur, n]的长度小于k, 不可能构造出长度为k的temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }
}
