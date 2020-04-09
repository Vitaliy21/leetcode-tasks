package com.leetcode;

import com.leetcode.dto.TreeNode;

public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if(oneOfNodeIsNull(p,q)) {
            return false;
        }
        if(p.val != q.val || !isSimilarChilds(p,q)) {
            return false;
        } else {
            if(p.left!=null) {
                if (!isSameTree(p.left, q.left)) {
                    return false;
                }
            }
            if(p.right!=null) {
                if(!isSameTree(p.right, q.right)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean oneOfNodeIsNull(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return true;
        } else if (p != null && q == null) {
            return true;
        } else return false;
    }

    private boolean isSimilarChilds(TreeNode p, TreeNode q) {
        return isSimilarLefts(p.left, q.left) && isSimilarRights(p.right, q.right);
    }

    private boolean isSimilarLefts(TreeNode left, TreeNode left1) {
        if (left == null && left1 == null) {
            return true;
        } else return left != null && left1 != null && left.val == left1.val;
    }


    private boolean isSimilarRights(TreeNode right, TreeNode right1) {
        if (right == null && right1 == null) {
            return true;
        } else return right != null && right1 != null && right.val == right1.val;
    }
}
