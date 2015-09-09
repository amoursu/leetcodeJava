package medium;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * @author zhouyan
 *
 */
public class P82_RemoveDuplicatesFromSortedList2 {
	//可以新添加头指针
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        
        ListNode pre = fakeHead;
    	ListNode cur = head;
    	while(cur!=null){
    		while(cur.next!=null && cur.val==cur.next.val){
    			cur = cur.next;
    		}
    		if(pre.next == cur)
    			pre = pre.next;
    		else
    			pre.next = cur.next;
    		cur = cur.next;
    	}
    	return fakeHead.next;
    }
}
