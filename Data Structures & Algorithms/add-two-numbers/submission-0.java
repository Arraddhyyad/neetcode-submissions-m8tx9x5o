class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;  
        
        int carry = 0;
        
        while (l1 != null && l2 != null) {  
            int sum = carry + l1.val + l2.val;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next; 
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int sum = carry + l1.val;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int sum = carry + l2.val;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            l2 = l2.next;
        }
        
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}
