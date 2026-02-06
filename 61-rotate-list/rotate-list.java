/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        List<Integer> list = new ArrayList<>();

        ListNode curr = head;

        while(curr!=null){
            list.add(curr.val);
            curr = curr.next;
        }

        Collections.rotate(list, k);

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for(int i: list){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        return dummy.next;
    }
}