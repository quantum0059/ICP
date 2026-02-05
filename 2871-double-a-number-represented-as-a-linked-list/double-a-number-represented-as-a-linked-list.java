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
    public ListNode doubleIt(ListNode head) {

        ListNode newHead = reverse(head);

        ListNode res = new ListNode(-1);

        ListNode curr = newHead;
        ListNode temp = res;

        int carry = 0;
        int val = 0;

        while(curr!= null){
            int sum = (curr.val*2)+carry;
            val = sum%10;
            carry = sum/10;
            temp.next = new ListNode(val);
            temp = temp.next;
            curr = curr.next;

        }

        if(carry == 1){
            temp.next = new ListNode(1);
        }

        return reverse(res.next);




    }
    static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr!= null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}