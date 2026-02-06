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
    public int[] nextLargerNodes(ListNode head) {
        if(head.next == null){
            return new int[]{0};
        }

        Stack<Integer> st = new Stack<>();
        int size = findSize(head);
        int[] arr = new int[size];
        ListNode curr = head;
        int j=0;

        while(curr != null){
           arr[j] = curr.val;
           j++;
           curr = curr.next;
        }
        int[] res = new int[size];

        for(int i=size-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]>= st.peek()){
                st.pop();
            }

            if(st.isEmpty()){
               res[i] =0;
            }else{
                res[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return res;

    }
    static int findSize(ListNode head){
        int count =0;
        ListNode curr = head;
        while(curr != null){
          count++;
          curr = curr.next;
        }
        return count;
    }
}