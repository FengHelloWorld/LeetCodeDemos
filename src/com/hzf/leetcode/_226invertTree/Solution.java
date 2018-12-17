package com.hzf.leetcode._226invertTree;

import com.hzf.leetcode.utils.TreeNode;

/**
 * Created by zf.huang on 2018.12.17
 * <p>
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 * <p>
 * ***** 4
 * *** /   \
 * ** 2     7
 * * / \   / \
 * 1    3 6   9
 * 输出：
 * <p>
 * ***** 4
 * *** /   \
 * ** 7     2
 * * / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */
public class Solution {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = temp;
        return root;
    }
}
