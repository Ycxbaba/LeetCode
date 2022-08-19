package medium;

public class MyCircularDeque {

	private int[] queue;
	private int size = 0;
	private int head = 0;
	private int tail = 0;
	private int capacity;

	public MyCircularDeque(int k) {
		queue = new int[k];
		capacity = k;
	}

	public boolean insertFront(int value) {
		if(isFull()){
			return false;
		}
		queue[head] = value;
		head = (head+1)%capacity;
		size++;
		return true;
	}

	public boolean insertLast(int value) {
		if(isFull()){
			return false;
		}
		tail = (tail - 1 + capacity)%capacity;
		queue[tail] = value;
		size++;
		return true;

	}

	public boolean deleteFront() {
		if(isEmpty())return false;
		head = (head-1 + capacity)%capacity;
		size--;
		return true;
	}

	public boolean deleteLast() {
		if(isEmpty())return false;
		tail = (tail+1)%capacity;
		size--;
		return true;
	}

	public int getFront() {
		return isEmpty() ? -1 : queue[(head-1 + capacity)%capacity];
	}

	public int getRear() {
		return isEmpty() ? -1 : queue[tail];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public static void main(String[] args) {
		//["MyCircularDeque","insertFront","insertFront","insertLast","deleteLast","insertLast","getRear"
		// ,"insertLast","getFront","deleteFront","insertLast","insertLast"]
		MyCircularDeque myCircularDeque = new MyCircularDeque(5);
		myCircularDeque.insertFront(5);
		myCircularDeque.insertFront(0);
		myCircularDeque.insertLast(5);
		myCircularDeque.deleteLast();
		myCircularDeque.insertLast(7);
		myCircularDeque.getRear();
		myCircularDeque.insertLast(7);
		myCircularDeque.getFront();
	}
}
