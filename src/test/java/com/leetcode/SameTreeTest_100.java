package com.leetcode;

import com.leetcode.dto.TreeNode;
import org.junit.Before;
import org.junit.Test;

public class SameTreeTest_100 {

    TreeNode a1;
    TreeNode b1;

    @Before
    public void initTests() {
        a1 = new TreeNode(1);
        b1 = new TreeNode(1);
        TreeNode a21 = new TreeNode(2);
        TreeNode a22 = new TreeNode(3);
        TreeNode b21 = new TreeNode(2);
        TreeNode b22 = new TreeNode(3);

        a1.left = a21;
        a1.right = a22;
        b1.left = b21;
        b1.right = b22;
    }
    @Test
    public void run() {
        boolean isSame = new SameTree_100().isSameTree(a1, b1);
        System.out.println(isSame);
    }
}
