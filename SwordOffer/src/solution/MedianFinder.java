package solution;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 */
public class MedianFinder {
	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;


	/** initialize your data structure here. */
	public MedianFinder() {
		maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
		minHeap = new PriorityQueue<>();
	}

	public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if(maxHeap.size()+1<minHeap.size())
			maxHeap.add(minHeap.poll());
	}

	public double findMedian() {
		if(minHeap.size()>maxHeap.size())return minHeap.peek();
		return (double)(maxHeap.peek()+minHeap.peek())/2;
	}
}
