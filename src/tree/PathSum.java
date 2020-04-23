package tree;

import java.util.LinkedList;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class PathSum {

    /**
     * 递归
     * 计算返回每一条路径的值，使用-为0比相加等于sum靠谱多了。
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 39.9 MB , 在所有 Java 提交中击败了 6.52% 的用户
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return 0 == sum - root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 迭代
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 9.87% 的用户 内存消耗 : 39.5 MB , 在所有 Java 提交中击败了 6.52% 的用户
     */
    public static boolean hasPathSumBFS(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> queueVal = new LinkedList<>();
        queue.add(root);
        queueVal.add(sum-root.val);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode removeFirst = queue.removeFirst();
                int val = queueVal.removeFirst();
                if (removeFirst.right == null && removeFirst.left == null && val == 0) {
                    return true;
                }
                if (removeFirst.left != null) {
                    queue.add(removeFirst.left);
                    queueVal.add(val-removeFirst.left.val);
                }
                if (removeFirst.right != null) {
                    queue.add(removeFirst.right);
                    queueVal.add(val-removeFirst.right.val);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p = new TreeNode(2);
        TreeNode pLeft = new TreeNode(3);
        TreeNode pRight = new TreeNode(4);
        p.left = pLeft;
        p.right = pRight;

        TreeNode q = new TreeNode(2);
        TreeNode qLeft = new TreeNode(4);
        TreeNode qRight = new TreeNode(3);
        q.left = qLeft;
        q.right = qRight;

        root.left = p;
        root.right = q;
        System.out.println(hasPathSumBFS(root,6));
    }
}
