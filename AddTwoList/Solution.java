package AddTwoList;

import java.util.List;

public class Solution {
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        
        ListNode node = solution.addTwoNumbers(l1, l2);
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode firstNode = new ListNode(l1.val + l2.val);
        ListNode currNode = firstNode;
        
        l1 = l1.next;
        l2 = l2.next;
        while( l1 != null || l2 != null) {
            
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);

            if (currNode.val >= 10) {
                sum += 1;
                currNode.val = currNode.val - 10;
            }

            currNode.next = new ListNode(sum);
            currNode = currNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

        }

        if (currNode.val >= 10) {
            currNode.val = currNode.val - 10;
            currNode.next = new ListNode(1);
        }

        return firstNode;

    }

    

}

class ListNode {
    int val;

    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
