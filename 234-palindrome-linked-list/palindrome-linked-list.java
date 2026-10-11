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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        if(head.next.next==null){
            return head.val == head.next.val;
        }
        ListNode mid = midPoint(head);
        ListNode p = head;
        
        ListNode rev = reverse(mid);
        ListNode p1 = rev;
        while(p1!= null){
            if(p.val != p1.val){
                return false;
            }
            p=p.next;
            p1=p1.next;
        }
        return true;

    }
    ListNode midPoint(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!= null){
            ListNode next = curr.next;
            curr.next = prev;
            prev= curr;
            curr=next;
        }
        return prev;
    }
}