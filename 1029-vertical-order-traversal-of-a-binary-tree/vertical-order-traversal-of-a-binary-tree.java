import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap for columns ensures sorted order by column index
        TreeMap<Integer, List<int[]>> columnTable = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0)); // node, row, col

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            columnTable.putIfAbsent(col, new ArrayList<>());
            columnTable.get(col).add(new int[]{row, node.val});

            if (node.left != null) queue.offer(new Tuple(node.left, row + 1, col - 1));
            if (node.right != null) queue.offer(new Tuple(node.right, row + 1, col + 1));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (List<int[]> columnNodes : columnTable.values()) {
            // Sort by row first, then by value
            columnNodes.sort((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; // sort by row
                return a[1] - b[1];                   // if same row, sort by value
            });
            List<Integer> sortedColumn = new ArrayList<>();
            for (int[] pair : columnNodes) {
                sortedColumn.add(pair[1]);
            }
            result.add(sortedColumn);
        }

        return result;
    }

    private class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}