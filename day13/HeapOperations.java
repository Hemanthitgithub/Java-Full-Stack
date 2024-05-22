package day13programs;

import java.util.*;


public class HeapOperations {
	private PriorityQueue<Integer>heap;
	public HeapOperations() {
		heap = new PriorityQueue<>();
	}
	public void insert(int value) {
		heap.offer(value);
	}
	public int deleteMin() {
		if(heap.isEmpty())throw new IllegalStateException("Heap is empty");
		return heap.poll();
	}
	public int getMin() {
		if(heap.isEmpty())throw new IllegalStateException("Heap is empty");
		return heap.peek();
	}
	public static void main(String[] args) {
		HeapOperations minHeap = new HeapOperations();
		minHeap.insert(10);
		minHeap.insert(4);
		minHeap.insert(8);
		minHeap.insert(2);
		
		System.out.println("Minimum element:"+minHeap.getMin());
		minHeap.deleteMin();
		System.out.println("Minimum element after deletion:"+minHeap.getMin());
	}
}


	