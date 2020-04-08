package tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 遍历树的两种通用策略：
 *
 * 深度优先遍历（DFS）
 *
 * 这种方法以深度 depth 优先为策略，从根节点开始一直遍历到某个叶子节点，然后回到根节点，在遍历另外一个分支。
 * 根据根节点，左孩子节点和右孩子节点的访问顺序又可以将 DFS 细分为先序遍历 preorder，中序遍历 inorder 和后序遍历 postorder。
 *
 * 广度优先遍历（BFS）
 *
 * 按照高度顺序，从上往下逐层遍历节点。
 * 先遍历上层节点再遍历下层节点。
 */
public class ConvertSortedArrayToBinarySearchTree {

    private static int[] nums;

    /**
     * 方法一：中序遍历：始终选择中间位置左边元素作为根节点。（同样，可以选取中间位置右边元素作为根节点）
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户内存消耗 : 41.1 MB , 在所有 Java 提交中击败了 5.03% 的用户
     *
     * 复杂度分析
     *
     * 时间复杂度：O(N)，每个元素只访问一次。
     *
     * 空间复杂度：O(N)，二叉搜索树空间 O(N)，递归栈深度 O(logN)。

     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        ConvertSortedArrayToBinarySearchTree.nums = nums;
        return helper(0, nums.length - 1);
    }

    public static TreeNode helper(int left,int right){
        if(left>right)
            return null;
        int p=(left+right)/2;
        TreeNode treeNode=new TreeNode(nums[p]);
        treeNode.left=helper(left,p-1);
        treeNode.right=helper(p+1,right);
        return treeNode;
    }

    public static void main(String[] args) {
        nums = new int[]{-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));
    }
}
