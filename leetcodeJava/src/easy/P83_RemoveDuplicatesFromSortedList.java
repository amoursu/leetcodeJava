package easy;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * @author zhouyan
 *
 */
public class P83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null) return head;
//    	ListNode cur = head.next; // two pointers
//    	ListNode pre = head;
//        while(cur != null){
//        	if(cur.val == pre.val){
//        		pre.next = cur.next;
//        	}else{
//        		pre = cur;
//        	}
//        	cur = cur.next;
//        }
    	
    	ListNode cur = head;
    	//改变next指针或改变自己的指向
    	while(cur.next != null){
    		if(cur.next.val == cur.val)
    			cur.next = cur.next.next;
    		else
    			cur = cur.next;
    	}
    	
    	return head;
    }
    
      //recursive solution
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null)return head;
//        head.next = deleteDuplicates(head.next);
//        return head.val == head.next.val ? head.next : head;
//    }
}
