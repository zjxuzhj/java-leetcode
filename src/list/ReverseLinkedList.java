package list;

/**
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL  21345
 */
public class ReverseLinkedList {

    /**
     * 迭代法
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗：39.3 MB, 在所有 Java 提交中击败了 5.06% 的用户
     */
    private static ListNode reverseListNormal(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 使用新链表来接收每次尾递归产生值
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00%的用户 内存消耗： 40 MB , 在所有 Java 提交中击败了 5.06%的用户
     */
    public static ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }
    private static ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        System.out.println(reverseListNormal(head));
    }
}
