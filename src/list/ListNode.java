package list;

public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return next == null ? val + "" : (val + "->" + next);
    }
}
