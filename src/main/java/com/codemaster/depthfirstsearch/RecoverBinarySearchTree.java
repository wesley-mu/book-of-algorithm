package com.codemaster.depthfirstsearch;

import com.codemaster.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 恢复二叉搜索树
 * https://leetcode.cn/problems/recover-binary-search-tree/description/
 */
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, treeNode2);
        TreeNode treeNode1 = new TreeNode(1, treeNode3, null);
        new RecoverBinarySearchTree().recoverTree(treeNode1);
    }

    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public int[] findTwoSwapped(List<Integer> nums) {
        int index1 = -1, index2 = -1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                index2 = i + 1;
                if (index1 == -1) {
                    index1 = i;
                } else {
                    break;
                }
            }
        }
        int x = nums.get(index1), y = nums.get(index2);
        return new int[]{x, y};
    }

    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }
}