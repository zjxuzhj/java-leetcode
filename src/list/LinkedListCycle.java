package list;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 */
public class LinkedListCycle {

    /**
     * 双指针法
     * 通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)。慢指针每次移动一步，而快指针每次移动两步。
     *
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 5.49% 的用户
     */
    public static boolean hasCycleDoublePointer(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 哈希表法
     * 执行用时 : 5 ms , 在所有 Java 提交中击败了 22.27% 的用户 内存消耗 : 41 MB , 在所有 Java 提交中击败了 5.49% 的用户
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.contains(head.next)) {
                return true;
            } else {
                hashSet.add(head.next);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(0);
        ListNode head3 = new ListNode(-4);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head1;

        System.out.println(hasCycleDoublePointer(head));
    }
}
