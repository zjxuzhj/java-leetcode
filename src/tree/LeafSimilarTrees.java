package tree;

/**
 * 872. 叶子相似的树
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 提示：
 *
 * 给定的两颗树可能会有 1 到 200 个结点。
 * 给定的两颗树上的值介于 0 到 200 之间。
 */
public class LeafSimilarTrees {

    /**
     * 递归法
     * 执行用时 : 9 ms , 在所有 Java 提交中击败了 6.21% 的用户 内存消耗 : 38 MB , 在所有 Java 提交中击败了 33.33% 的用户
     */
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        return getLeafNum(root1,sb1).equals(getLeafNum(root2,sb2));
    }

    public static String getLeafNum(TreeNode root,StringBuilder sb){
        if (root == null) return sb.toString();
        if (root.left != null && root.right != null) {
            return getLeafNum(root.left, sb) + getLeafNum(root.right, sb);
        } else if (root.left != null) {
            return getLeafNum(root.left, sb);
        } else if (root.right != null) {
            return getLeafNum(root.right, sb);
        } else {
            return sb.append(root.val).append( ",").toString();
        }
    }

    public static void main(String[] args) {
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

        System.out.println(leafSimilar(p,q));
    }
}
