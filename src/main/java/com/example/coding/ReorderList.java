package com.example.coding;

public class ReorderList {
    public void reorderList(ListNode head) {
        // mark the mid
        // one two
        // reverse the two
        // modify the one based on the two
        // 1 2 3 4
        // 
        // mark the mid
        ListNode temp = new ListNode(-1), itr = head;
        ListNode midItr = temp;

        temp.next = head;
        
        while(itr!=null && itr.next!=null) {
        	itr=itr.next;
        	itr=itr.next;
        	midItr = midItr.next;
        }

        ListNode tail = midItr.next;
        midItr.next = null;
        
        // head tail
        // reverse the tail
        
        ListNode tailItr = tail, tailPrevious = null;
        
        while(tailItr!=null) {
        	temp = tailItr.next;
        	tailItr.next = tailPrevious;
        	tailPrevious = tailItr;
        	if(temp==null)
        		break;
        	tailItr = temp;
        }
        
        // head tailItr
        
        itr=head;
        while(itr!=null && tailItr!=null) {
        	temp = itr.next;
        	midItr = tailItr.next;
        	itr.next = tailItr;
        	tailItr.next = temp;
            if(temp==null && midItr!=null) {
                tailItr.next = midItr;
            }
        	tailItr = midItr;
        	itr = temp;
        }
    }
}
