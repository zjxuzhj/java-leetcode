package tree;

import java.util.LinkedList;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class MaximumDepthOfBinaryTree {

    /**
     * BFS:层次遍历思想  通过迭代实现二叉树最大深度
     * 构建一个队列，然后把树放进去
     * 利用队列的特性，一层一层读取树的元素，每读取一层，层数加1
     * 直到所有层遍历完毕，输出层数
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
     * <p>
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 24.06% 的用户 内存消耗 :39.2 MB , 在所有 Java 提交中击败了= 16.80%= 的用户
     *
     * @param root 根节点
     * @return 最大深度
     */
    public static int maxDepthIterationBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode removeFirst = queue.removeFirst();
                if (removeFirst.left != null) {
                    queue.add(removeFirst.left);
                }
                if (removeFirst.right != null) {
                    queue.add(removeFirst.right);
                }
            }
        }
        return maxDepth;
    }

    /**
     * DFS:深度优先搜索算法(Depth First Search) 前序遍历思想
     * 对于二叉树而言，它沿着树的深度遍历树的节点，尽可能深的搜索树的分支，这一过程一直进行到已发现从源节点可达的所有节点为止。
     * 使用迭代方法
     */
    public static int maxDepthIterationDFS(TreeNode root) {
        return 0;
    }

    /**
     * DFS（深度优先搜索）：可能会爆栈（因为在递归中，层级过深，我们可能保存太多临时变量，导致内存溢出）
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户内存消耗 : 39 MB , 在所有 Java 提交中击败了 28.68% 的用户
     * <p>
     * 时间复杂度：我们每个结点只访问一次，因此时间复杂度为 O(N)，
     * 其中 N 是结点的数量。
     * 空间复杂度：在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，递归将会被调用 N 次（树的高度），因此保持调用栈的存储将是 O(N)。
     * 但在最好的情况下（树是完全平衡的），树的高度将是 log(N)。因此，在这种情况下的空间复杂度将是 O(log(N))。
     */
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
        System.out.println(maxDepthIterationBFS(root));
    }
}
