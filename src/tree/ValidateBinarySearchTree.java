package tree;

import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class ValidateBinarySearchTree {

    /**
     * 中序遍历，先取出所有左节点，然后取出该对应的右节点，必须大于左节点的最大值。
     * 执行用时 :3 ms , 在所有 Java 提交中击败了 23.44% 的用户 内存消耗 :38.8 MB , 在所有 Java 提交中击败了 67.10% 的用户
     */
    public static boolean isValidBSTInOrder(TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;

        while (queue.size() > 0 || node != null) {
            while (node != null) {
                queue.add(node);
                node = node.left;
            }
            node = queue.pollLast();
            if (inorder >= node.val) {
                return false;
            }
            inorder = node.val;
            node = node.right;
        }
        return true;
    }

    /**
     * 迭代法
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 6.14% 的用户 内存消耗 : 39 MB , 在所有 Java 提交中击败了 53.42% 的用户
     */
    public static boolean isValidBSTNormal(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }
        Integer lower;
        Integer upper;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> lowerL = new LinkedList<>();
        LinkedList<Integer> upperL = new LinkedList<>();
        queue.add(node);
        while (queue.size() > 0) {
            TreeNode root = queue.poll();
            lower = lowerL.poll();
            upper = upperL.poll();
            if (root == null) {
                continue;
            }
            int val = root.val;
            if (lower != null && val <= lower || upper != null && val >= upper) {
                return false;
            }

            if (root.left == null && root.right == null) {
                continue;
            }

            lowerL.add(lower);
            upperL.add(val);
            queue.add(root.left);

            lowerL.add(val);
            upperL.add(upper);
            queue.add(root.right);
        }
        return true;
    }

    /**
     * 使用递归运算，并且每次保留上下界限
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00%的用户内存消耗 : 39.5 MB , 在所有 Java 提交中击败了16.57% 的用户
     */
    public static boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        TreeNode p = new TreeNode(1);
        TreeNode pLeft = new TreeNode(0);
        TreeNode pRight = new TreeNode(2);
//        p.left = pLeft;
//        p.right = pRight;

        TreeNode q = new TreeNode(3);
        TreeNode qLeft = new TreeNode(4);
        TreeNode qRight = new TreeNode(6);
//        q.left = qLeft;
//        q.right = qRight;

        root.left=p;
        root.right=q;
        System.out.println(isValidBSTInOrder(root));
    }
}
