class Solution {
    static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    public int minimumPairRemoval(int[] nums) {
        if(nums.length == 1) return 0;
       boolean flag = true;
       for(int i=1;i<nums.length;i++){
         if(nums[i-1]>nums[i]){
             flag = false;
         }
       }

       if(flag) return 0;

    //    PriorityQueue<Integer> pq = new PriorityQueue<>();
       Node newList  = new Node(0);
       Node dummy = newList;

       for(int i=0;i<nums.length;i++){
          dummy.next = new Node(nums[i]);
          dummy = dummy.next;
       }
       int steps = 0;
       while (true) {
            Node prev = newList;
            Node curr = newList.next;
            Node bestPrev = null;
            int minSum = Integer.MAX_VALUE;

            while(curr!= null && curr.next!= null){
                int sum = curr.value + curr.next.value;
                if(sum< minSum){
                    minSum = sum;
                    bestPrev = prev;
                }
                prev = curr;
                curr = curr.next;
            }

            Node next = bestPrev.next.next.next;
            bestPrev.next = new Node(minSum);
            bestPrev.next.next = next;

            steps++;
            if(isSorted(newList)) break;

  }


       return steps;

    }

    static boolean isSorted(Node newList){
        Node dummy = newList.next.next;
        Node prev = newList.next;

        while(dummy!=null){
            if(prev.value > dummy.value){
                return false;
            }
            prev = prev.next;
            dummy = dummy.next;
        }

        return true;
    }
}