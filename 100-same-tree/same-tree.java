class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // both null
        if (p == null && q == null) return true;

        // one null
        if (p == null || q == null) return false;

        // values differ
        if (p.val != q.val) return false;

        // check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}