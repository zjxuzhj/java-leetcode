/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(2);
//        ListNode head4 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
//        head3.next = head4;
        System.out.println(deleteDuplicatesNorMal(head));
    }

    /**
     * 复杂度分析
     * 时间复杂度：O(n)，因为列表中的每个结点都检查一次以确定它是否重复，所以总运行时间为 O(n)，其中 n 是列表中的结点数。
     * 空间复杂度：O(1)，没有使用额外的空间。
     * <p>
     * 正确性
     * 我们可以通过定义循环不变式来证明此代码的正确性。循环不变式是在循环的每次迭代之前和之后为真的条件。在这种情况下，一个帮助我们证明正确性的循环不变式是这样的：
     * 列表中直到指针 current 的所有结点都不包含重复的元素。
     *
     */
    public static ListNode deleteDuplicatesNorMal(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 个人手写
     * 执行用时 : 1 ms, 在所有 Java 提交中击败了 94.21% 的用户 内存消耗 : 39.8 MB , 在所有 Java 提交中击败了 5.14%的用户
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        boolean flag = true;
        ListNode secondNode = head.next;
        while (flag) {
            if (head.next == null || secondNode == null) {
                flag = false;
            } else {
                if (head.next.val == head.val) {
                    if (head.next.next != null) {
                        head.next = head.next.next;
                    } else {
                        head.next = null;
                    }
                } else if (secondNode.next != null && secondNode.val == secondNode.next.val) {
                    if (secondNode.next.next != null) {
                        secondNode.next = secondNode.next.next;
                        continue;
                    } else {
                        secondNode.next = null;
                    }
                }
                secondNode = secondNode.next;
            }
        }
        return head;
    }

    public static class ListNode {
        ListNode next;
        int val;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return next == null ? val + "" : (val + "->" + next);
        }
    }
}
