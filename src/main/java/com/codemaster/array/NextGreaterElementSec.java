package com.codemaster.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 下一个更大元素 II
 * https://leetcode.cn/problems/next-greater-element-ii/description/
 */
public class NextGreaterElementSec {
    public static void main(String[] args) {
        int[] res = new NextGreaterElementSec().nextGreaterElements(new int[]{1, 2, 3, 4, 3});
        System.out.println(res);
    }
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }
}
