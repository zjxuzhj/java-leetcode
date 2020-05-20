package list;

/**
 * 237. 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *
 * 示例 1:
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 示例 2:
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class DeleteNodeInALinkedList {
    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 39.8 MB, 在所有 Java 提交中击败了 6.52% 的用户
     */
    public static void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(5);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(9);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head1;

        deleteNode(head);
        System.out.println(head1);
    }
}
