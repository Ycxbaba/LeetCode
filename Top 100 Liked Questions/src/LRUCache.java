import java.util.HashMap;

/**
 * https://leetcode.cn/problems/lru-cache/
 */
public class LRUCache {
	HashMap<Integer,Node> map;
	DoubleLinkedNode linkedNode;
	int cap;
	public LRUCache(int capacity) {
		map = new HashMap<>();
		linkedNode = new DoubleLinkedNode();
		cap = capacity;
	}

	public int get(int key) {
		if(map.containsKey(key)){
			int val = map.get(key).val;
			put(key,val);
			return val;
		}
		return -1;
	}

	public void put(int key, int value) {
		Node node = new Node(key, value);
		if (map.containsKey(key)) {
			linkedNode.delete(map.get(key));
		}else {
			if(map.size() == cap){
				int k = linkedNode.deleteTail();
				map.remove(k);
			}
		}
		map.put(key,node);
		linkedNode.insertHead(node);
	}
}
class DoubleLinkedNode{
	Node head;
	Node tail;
	DoubleLinkedNode(){
		head = new Node(0,0);
		tail = new Node(0,0);

		head.next = tail;
		tail.pre = head;
	}

	void insertHead(Node node){
		node.next = head.next;
		node.pre = head;
		head.next.pre = node;
		head.next = node;

	}

	int delete(Node node){
		node.pre.next = node.next;
		node.next.pre = node.pre;
		return node.key;
	}

	int deleteTail(){
		if(head.next == tail)   return -1;
		return delete(tail.pre);
	}
}
class Node {
	int key;
	int val;
	Node pre;
	Node next;
	Node(int key,int val){
		this.key = key;
		this.val = val;
	}
}
