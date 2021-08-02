//Leetcode 1836

import java.util.*;

class DeleteDuplicatesUnsorted{
    public static ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        
        ListNode cur = head;
        
        while(cur != null){
            map.put(cur.val, map.getOrDefault(cur.val, 0)+1);
            cur = cur.next;
        }
        
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        
        ListNode prev = tempHead;
        cur = head;
        
        while(cur != null){
            if(map.get(cur.val) > 1){
                prev.next = cur.next;
                cur.next = null;
                cur = prev;
            }
            prev = cur;
            cur = cur.next;
        }
        
        return tempHead.next;

		
	}

	public static void main(String[] args){
			ListNode node = new ListNode(1);
			node.next = new ListNode(2);
			node.next.next = new ListNode(3);
			node.next.next.next = new ListNode(2);

			ListNode temp = node;
			while(temp != null){
				System.out.print(temp.val +" ");
				temp = temp.next;
			}
			System.out.println();

			ListNode ans = deleteDuplicatesUnsorted(node);

			while(ans != null){
				System.out.print(ans.val +" ");
				ans = ans.next;
			}
		}
}