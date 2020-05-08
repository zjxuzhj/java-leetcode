package tree;

import java.util.LinkedList;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class MergeTwoBinaryTrees {

    /**
     * 递归，修改原树
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 64.65% 的用户 内存消耗 : 39.7 MB , 在所有 Java 提交中击败了 94.12% 的用户
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null) return t2;
        if(t2==null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 迭代
     *
     * 执行用时 : 2 ms, 在所有 Java 提交中击败了 8.84% 的用户 内存消耗 : 40 MB , 在所有 Java 提交中击败了 85.29% 的用户
     */
    public static TreeNode mergeTreesNormal(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        //用队列保存节点
        LinkedList<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{t1, t2});
        while (queue.size() > 0) {
            TreeNode[] root = queue.removeFirst();
            if (root[0] == null || root[1] == null) {
                continue;
            }
            root[0].val += root[1].val;
            if (root[0].left == null) {
                root[0].left = root[1].left;
            } else {
                queue.add(new TreeNode[]{root[0].left, root[1].left});
            }
            if (root[0].right == null) {
                root[0].right = root[1].right;
            } else {
                queue.add(new TreeNode[]{root[0].right, root[1].right});
            }
        }
        return t1;
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

        System.out.println(mergeTreesNormal(p,q));
    }
}
