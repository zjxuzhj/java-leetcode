package list;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    /**
     * 迭代
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 73.59% 的用户 内存消耗 : 39.7 MB , 在所有 Java 提交中击败了 44.31% 的用户
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return head.next;
    }

    /**
     * 递归
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 73.59% 的用户 内存消耗 : 39.2 MB , 在所有 Java 提交中击败了 65.09% 的用户
     */
    public static ListNode mergeTwoListsNormal(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }else if(l1.val<l2.val){
            l1.next = mergeTwoListsNormal(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoListsNormal(l2.next, l1);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(4);

        ListNode head3 = new ListNode(1);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(4);

        head.next = head1;
        head1.next = head2;

        head3.next = head4;
        head4.next = head5;

        System.out.println(mergeTwoListsNormal(head, head3));
    }
}
