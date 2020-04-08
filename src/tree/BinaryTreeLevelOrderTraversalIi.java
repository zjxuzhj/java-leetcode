package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalIi {
    /**
     * BFS层次遍历
     * 执行用时 : 1 ms, 在所有 Java 提交中击败了 99.75% 的用户内存消耗 : 39.6 MB , 在所有 Java 提交中击败了 5.03% 的用户
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> integer1 = new ArrayList<>();
        integer1.add(root.val);
        lists.add(integer1);
        while (!queue.isEmpty()) {
            List<Integer> integerList = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode removeFirst = queue.removeFirst();
                if (removeFirst.left != null) {
                    queue.add(removeFirst.left);
                    integerList.add(removeFirst.left.val);
                }
                if (removeFirst.right != null) {
                    queue.add(removeFirst.right);
                    integerList.add(removeFirst.right.val);
                }
            }
            if (integerList.size() != 0) {
                lists.add(integerList);
            }
        }
        Collections.reverse(lists);
        return lists;
    }

    /**
     * DFS深度优先遍历
     * 使用递归遍历二叉树框架的基本方法，同时添加 list 、 height 两个参数实现。
     * 每次深度增加添加一个list，并且把当前层级的叶子节点添加到list中
     */
    public static List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        levelOrderBottomDFS(root, lists, 0);
        Collections.reverse(lists);
        return lists;
    }

    public static List<List<Integer>> levelOrderBottomDFS(TreeNode root, List<List<Integer>> lists, int height) {
        if (root == null) {
            return null;
        }
        if (lists.size() <= height)
            lists.add(new ArrayList<>());
        lists.get(height).add(root.val);
        height++;
        levelOrderBottomDFS(root.left, lists, height);
        levelOrderBottomDFS(root.right, lists, height);
        return lists;
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
        System.out.println(levelOrderBottomDFS(root));
    }

}
