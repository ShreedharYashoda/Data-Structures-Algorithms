import java.util.*;
public class LRUCache{

	public class ListNode{
		int key, value;
		ListNode next, prev;
	}

	public void addNode(ListNode node){
		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	public void removeNode(ListNode node){
		ListNode nextt = node.next;
		ListNode prevv = node.prev;

		nextt.prev = prevv;
		prevv.next = nextt; 
	}

	public void moveToHead(ListNode node){
		removeNode(node);
		addNode(node);
	}

	public ListNode popTail(){
		ListNode last = tail.prev;
		removeNode(last);
		return last;
	}

	private Map<Integer, ListNode> cache;
	private int size;
	private int capacity;
	private ListNode head, tail;

	public LRUCache(int capacity){
		this.capacity = capacity;
		cache = new HashMap<>();
		head = new ListNode();
		tail = new ListNode();

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key){
		ListNode node = cache.get(key);

		if(node == null) return -1;

		moveToHead(node);

		return node.value;
	}

	public void put(int key, int value){
		ListNode node = cache.get(key);

		if(node == null){
			ListNode newNode = new ListNode();
			newNode.key = key;
			newNode.value = value;

			cache.put(key, newNode);
			addNode(newNode);
			size++;

			if(size > capacity){
				ListNode last = popTail();
				cache.remove(last.key);
				size--;
			}
		}else{
			node.value = value;
			moveToHead(node);
		}
	}


	public static void main(String[] args) {

		LRUCache lRUCache = new LRUCache(2);
		System.out.println("Created LRUCache");

		lRUCache.put(1, 1); // cache is {1=1}
		System.out.println("Put 1");

		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println("Put 2");

		System.out.print("get 1 ");
		System.out.println(lRUCache.get(1));    // return 1

		System.out.println("put 3");
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println("Evicted 2");

		System.out.print("get 2 ");
		System.out.println(lRUCache.get(2));    // returns -1 (not found)

		System.out.println("put 4");
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println("Evicted 1");

		System.out.print("get 1 ");
		System.out.println(lRUCache.get(1));    // return -1 (not found)

		System.out.print("get 3 ");
		System.out.println(lRUCache.get(3));    // return 3

		System.out.print("get 4 ");
		System.out.println(lRUCache.get(4));    // return 4
  }


}