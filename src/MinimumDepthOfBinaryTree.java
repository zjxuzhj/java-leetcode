/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 */
public class MinimumDepthOfBinaryTree {

    /**
     * 直接求树的最小深度，注意根节点的左或右子树为空的话是构不成子树的
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 39.1 MB , 在所有 Java 提交中击败了 34.15%的用户
     */
    public static int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.right==null&&root.left!=null) {
            return minDepth(root.left)+1;
        }
        if(root.left==null&&root.right!=null) {
            return minDepth(root.right)+1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p = new TreeNode(2);
        TreeNode pLeft = new TreeNode(3);
        TreeNode pRight = new TreeNode(4);
//        p.left = pLeft;
//        p.right = pRight;

        TreeNode q = new TreeNode(2);
        TreeNode qLeft = new TreeNode(4);
        TreeNode qRight = new TreeNode(3);
        q.left = qLeft;
        q.right = qRight;

        root.left = p;
        root.right = q;
        System.out.println(minDepth(root));
    }
}
