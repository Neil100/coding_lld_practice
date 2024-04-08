package com.example.coding;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode two, three;
        if(head==null)
            return head;
        two = head.next;
        head.next = null;
        while(two!=null) {
            three = two.next;
            two.next = head;
            head = two;
            two = three;
        }

        return head;
    }
}
