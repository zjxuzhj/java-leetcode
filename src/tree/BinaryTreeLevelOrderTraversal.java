package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 22.80% 的用户 内存消耗 :39.7 MB , 在所有 Java 提交中击败了 5.71% 的用户
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<TreeNode>> nodeLinkedList = new LinkedList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        nodeLinkedList.add(nodeList);

        List<List<Integer>> intLinkedList = new LinkedList<>();
        if(root==null){
            return intLinkedList;
        }
        List<Integer> intList = new ArrayList<>();
        intList.add(root.val);
        intLinkedList.add(intList);

        while (!nodeLinkedList.isEmpty()) {
            intList=new ArrayList<>();
            nodeList=new ArrayList<>();
            List<TreeNode> treeNodes = nodeLinkedList.pollFirst();
            for (TreeNode treeNode : treeNodes) {
                if (treeNode.left != null) {
                    intList.add(treeNode.left.val);
                    nodeList.add(treeNode.left);
                }
                if (treeNode.right!=null){
                    intList.add(treeNode.right.val);
                    nodeList.add(treeNode.right);
                }
            }
            if(!nodeList.isEmpty()) {
                nodeLinkedList.add(nodeList);
                intLinkedList.add(intList);
            }
        }
        return intLinkedList;
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
        System.out.println(levelOrder(root));
    }
}
