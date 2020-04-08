package tree;

import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {

    /**
     * 层次遍历
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户内存消耗 : 37 MB , 在所有 Java 提交中击败了 5.39% 的用户
     */
    public static TreeNode invertTreeBFS(TreeNode root) {
        if(root==null){
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode removeFirst = queue.removeFirst();
                TreeNode temp = removeFirst.left;
                removeFirst.left=removeFirst.right;
                removeFirst.right=temp;
                if (removeFirst.left != null) {
                    queue.add(removeFirst.left);
                }
                if (removeFirst.right != null) {
                    queue.add(removeFirst.right);
                }
            }
        }
        return root;
    }

    /**
     * 递归深度遍历
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户内存消耗 : 37 MB , 在所有 Java 提交中击败了 5.39% 的用户
     */
    public static TreeNode invertTreeDFS(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode right= invertTreeDFS(root.right);
        TreeNode left= invertTreeDFS(root.left);
        root.left = right;
        root.right = left;
        return root;
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
        System.out.println(invertTreeBFS(root));

    }

}
