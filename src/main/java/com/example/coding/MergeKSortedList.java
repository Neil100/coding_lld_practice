package com.example.coding;

public class MergeKSortedList {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode sol = new ListNode(-1);
        ListNode solItr = sol;

        ListNode mmin = new ListNode(Integer.MAX_VALUE);
        ListNode min;
        while(true) {
            min = mmin;
            int index= -1;
            for(int i=0; i<lists.length; i++) {
                if(lists[i]!=null && min.val > lists[i].val) {
                    min = lists[i];
                    index = i;
                }
            }
            if(index==-1)
                break;
            lists[index] = lists[index].next;
            solItr.next = min;
            solItr = solItr.next;

        }
        solItr.next = null;
        return sol.next;
    }

}
