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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while(temp!= null){
           int val = temp.val;
           list.add(val);
           temp = temp.next;
        }
         int pow = 1;
         int sum =0;
        for(int i=list.size()-1;i>=0;i--){
           if(list.get(i) == 1){
             sum+=pow;
           }
           pow*=2;
        }

        return sum;
    }
}