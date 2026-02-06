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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = sizeOfList(head);
        return solve(head, k, size);
    }

    static ListNode solve(ListNode head, int k, int size){
        if(size<k){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;

        int i=k;
        while(i>0 && curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i--;
        }

        head.next = solve(curr, k, size-k);
        return prev;
    }
    static int sizeOfList(ListNode head){
        int count =0;
        ListNode curr = head;

        while(curr!= null){
            count++;
            curr = curr.next;
        }

        return count;
    }
}