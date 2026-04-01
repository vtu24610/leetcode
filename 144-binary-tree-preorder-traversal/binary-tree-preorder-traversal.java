import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) return;
        
        result.add(node.val);           // root
        traverse(node.left, result);    // left
        traverse(node.right, result);   // right
    }
}