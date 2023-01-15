package com.hackerrank.practices;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryHeap {
	private static final int d = 2;
	private int[] heap;
	private int heapSize;

	BinaryHeap(int capacity) {
		heap = new int[capacity + 1];
		heapSize = 0;
		Arrays.fill(heap, -1);
	}

	// is heap empty?
	public boolean isEmpty() {
		return heapSize == 0;
	}

	// return parent
	private int parent(int i) {
		return (i - 1) / d;
	}

	// is heap full?
	public boolean isFull() {
		return heapSize == heap.length;
	}

	public void insert(int x) {
		if (isFull())
			throw new NoSuchElementException("Heap is full, No space to insert new element");
		heap[heapSize++] = x;
		heapifyUp(heapSize - 1);
	}

	// maintain heap property during insertion
	private void heapifyUp(int i) {
		int temp = heap[i];
		while (i > 0 && temp > heap[parent(i)]) {
			heap[i] = heap[parent(i)];
			i = parent(i);
		}
		heap[i] = temp;
	}

	public static void main(String[] args) {

		BinaryHeap maxHeap = new BinaryHeap(10);
		maxHeap.insert(1);
		maxHeap.insert(2);

	}
}
