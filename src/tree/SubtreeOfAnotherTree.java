package tree;

/**
 * 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 */
public class SubtreeOfAnotherTree {

    /**
     *  一棵树是子树要满足，要么两棵树相同，要么是左子树的子树，要么是右子树的子树，那么如果和子树的子树相同，则为true
     *
     *  执行用时 : 6 ms, 在所有 Java 提交中击败了 95.56% 的用户 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 62.63% 的用户
     */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return SameTree.isSameTreeNormal(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
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
        System.out.println(isSubtree(root,qLeft));
    }
}
