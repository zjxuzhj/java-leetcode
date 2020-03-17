import java.util.LinkedList;

/**
 * 100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 */
public class sameTree {

    /**
     * 二叉树套路框架
     *
     * 二叉搜索树（Binary Search Tree，简称 BST）是一种很常用的的二叉树。
     * 它的定义是：一个二叉树中，任意节点的值要大于等于左子树所有节点的值，且要小于等于右边子树的所有节点的值。
     *
     * 总结
     * 1. 二叉树算法设计的总路线：把当前节点要做的事做好，其他的交给递归框架，不用当前节点操心。
     * 2. 如果当前节点会对下面的子节点有整体影响，可以通过辅助函数增长参数列表，借助参数传递信息。
     * 3. 在二叉树框架之上，扩展出一套 BST 遍历框架：
     *
     * https://leetcode-cn.com/problems/same-tree/solution/xie-shu-suan-fa-de-tao-lu-kuang-jia-by-wei-lai-bu-/
     */

    /**
     * 直觉法，使用先序遍历的递归形式
     * <p>
     * 复杂度分析
     * 时间复杂度 : O(N)，其中 N 是树的结点数，因为每个结点都访问一次。
     * 空间复杂度 : 最优情况（完全平衡二叉树）时为 O(log(N))，最坏情况下（完全不平衡二叉树）时为 O(N)，用于维护递归栈。
     */
    public static boolean isSameTreeNormal(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 :37.1 MB , 在所有 Java 提交中击败了 5.03%的用户
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            if (p.left != null && q.left != null) {
                if (isSameTree(p.left, q.left)) {
                    if (p.right != null) {
                        return isSameTree(p.right, q.right);
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            } else if (p.left == null && q.left == null) {
                if (p.right != null) {
                    return isSameTree(p.right, q.right);
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode pLeft = new TreeNode(-5);
        TreeNode pRight = new TreeNode(3);
        p.left = pLeft;
//        p.right = pRight;
        p.right = null;

        TreeNode q = new TreeNode(1);
        TreeNode qLeft = new TreeNode(-8);
        TreeNode qRight = new TreeNode(3);
        q.left = qLeft;
//        q.left = null;
//        q.right = qRight;
        q.right = null;
        System.out.println(isSameTreeNormal(p, q));
    }
}
