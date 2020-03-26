/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class BalancedBinaryTree {

    /**
     * 自底向上的递归（提前阻断）
     * 思路是对二叉树做先序遍历，从底至顶返回子树最大高度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
     *
     */
    public static boolean isBalancedBottomToTop(TreeNode root) {
        return help(root) != -1;
    }

    public static int help(TreeNode root) {
        if (root == null) return 0;
        int left = help(root.left);
        if(left == -1) return -1;
        int right = help(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    /**
     * 自顶向下地判断各个结点。
     * 判断某顶点为根结点的树是否为平衡二叉树，首先要满足的条件是：对于这个顶点，左子树的高度和右子树的高度之差的绝对值小于等于1。
     * 其次：左子树为平衡二叉树，右子树也为平衡二叉树。
     * 综上，自顶向下递归地检查每个顶点。
     *
     * 缺点：自顶向下计算每个结点的高度时存在大量冗余。
     *
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.88% 的用户 内存消耗 : 41.5 MB, 在所有 Java 提交中击败了 9.84% 的用户
     */
    public static boolean isBalancedTopToBottom(TreeNode root) {
        if (root == null) return true;
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)return false;
        return isBalancedTopToBottom(root.left) && isBalancedTopToBottom(root.right);
    }

    public static int getHeight(TreeNode root){
        if(root==null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p = new TreeNode(2);
        TreeNode pLeft = new TreeNode(3);
        TreeNode pRight = new TreeNode(4);
        p.left = pLeft;
        p.right = null;
        p.left.left= new TreeNode(4);

        TreeNode q = new TreeNode(2);
        TreeNode qLeft = new TreeNode(4);
        TreeNode qRight = new TreeNode(3);
        q.left = null;
        q.right = qRight;
        q.right.right = new TreeNode(4);

        root.left = p;
        root.right = q;
        System.out.println(isBalancedBottomToTop(root));
    }
}
