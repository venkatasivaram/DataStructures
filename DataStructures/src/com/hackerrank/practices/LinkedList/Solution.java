package com.hackerrank.practices.LinkedList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	public static boolean hasCycle(SinglyLinkedListNode head) {

		if (head == null)
			return false;

		boolean hasCycle = false;
		SinglyLinkedListNode p1 = head;
		SinglyLinkedListNode p2 = head;

		while (p1 != null && p2 != null && p2.next != null) {

			p1 = p1.next;
			p2 = p2.next.next;

			if (p1 == p2)
				return true;
		}
		return hasCycle;
	}

	public static int HasCycle(SinglyLinkedListNode head) {
		if (head == null)
			return 0;

		SinglyLinkedListNode p1 = head;
		SinglyLinkedListNode p2 = head;
		int hascycle = 0;
		while (p1 != null && p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				hascycle = 1;
				break;
			}
		}
		return hascycle;
	}

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */

	public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {

		SinglyLinkedListNode mergeLlist = mergeSort(llist);

		// printLinkedList(mergeLlist);

		SinglyLinkedListNode head = mergeLlist;
		SinglyLinkedListNode prev = null;

		while (mergeLlist != null) {

			// System.out.print(" " + mergeLlist.data);
			if (prev != null) {

				if (prev.data == mergeLlist.data) {

					prev.next = mergeLlist.next;

					mergeLlist = prev;

				}

			}

			prev = mergeLlist;
			mergeLlist = mergeLlist.next;
		}

		return head;
	}

	public static SinglyLinkedListNode mergeSort(SinglyLinkedListNode llist) {

		if (llist == null || llist.next == null) {
			return llist;
		}
		SinglyLinkedListNode middle = getMiddle(llist);

		SinglyLinkedListNode nextofmiddle = middle.next;

		middle.next = null;

		// Apply mergeSort on left list
		SinglyLinkedListNode left = mergeSort(llist);

		// Apply mergeSort on right list
		SinglyLinkedListNode right = mergeSort(nextofmiddle);

		SinglyLinkedListNode node = mergeLists(left, right);

		return node;

	}

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

		int list1length = getLength(head1);
		int list2length = getLength(head2);

		if (list1length != list2length)
			return false;

		while (head1 != null && head2 != null) {
			if (head1.data != head2.data)
				return false;

			head1 = head1.next;
			head2 = head2.next;

		}

		return true;
	}

	public static int getLength(SinglyLinkedListNode llist) {

		if (llist == null)
			return 0;

		return 1 + getLength(llist.next);
	}

	public static SinglyLinkedListNode getMiddle(SinglyLinkedListNode llist) {

		if (llist == null)
			return llist;

		int length = 0;
		SinglyLinkedListNode middle = llist;
		while (llist.next != null) {

			length++;
			if (length % 2 == 0) {
				middle = middle.next;
			}

			llist = llist.next;

		}

		return middle;

	}

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

		boolean loop = true;

		SinglyLinkedListNode headList = new SinglyLinkedListNode(-1);

		SinglyLinkedListNode tailList = headList;

		while (loop) {

			if (head1 == null) {

				tailList.next = head2;
				// head2 = head2.next;
				break;
			}
			if (head2 == null) {
				tailList.next = head1;
				// head2 = head2.next;
				break;

			}

			if (head1.data <= head2.data) {

				SinglyLinkedListNode node1 = new SinglyLinkedListNode(head1.data);

				tailList.next = node1;

				head1 = head1.next;

			} else {

				SinglyLinkedListNode node1 = new SinglyLinkedListNode(head2.data);
				tailList.next = node1;
				head2 = head2.next;

			}

			tailList = tailList.next;
			if (head1 == null && head2 == null)
				loop = false;

		}
		return headList.next;
	}

	/*
	 * Complete the 'reverse' function below.
	 *
	 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST. The
	 * function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
	 */
	public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {

		SinglyLinkedListNode prev = null;
		SinglyLinkedListNode revlist = null;
		SinglyLinkedListNode revhead = null;

		while (llist != null) {

			if (prev == null) {
				revlist = new SinglyLinkedListNode(llist.data);
				revhead = revlist;
			} else {
				revhead = new SinglyLinkedListNode(llist.data);
				revhead.next = revlist;
				revlist = revhead;
			}

			prev = llist;
			llist = llist.next;

		}

		return revlist;
	}

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */

	public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {

		SinglyLinkedListNode node = new SinglyLinkedListNode(data);

		if (llist == null)
			return node;

		SinglyLinkedListNode head = llist;
		SinglyLinkedListNode prev = null;

		prev = llist;
		int pos = 0;
		boolean change = true;
		while (llist != null && change) {

			if (pos == position) {

				if (prev == llist) {
					node.next = llist;
					llist = node;
					return llist;
				}

				prev.next = node;
				node.next = llist;
				change = false;
			}

			prev = llist;
			llist = llist.next;
			pos++;

		}

		return head;

	}

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {

		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
		newNode.next = llist;

		return newNode;
	}

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */

	public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {

		SinglyLinkedListNode head = llist;
		SinglyLinkedListNode prev = null;

		boolean change = true;
		int pos = 0;
		while (llist != null && change) {
			if (pos == position) {

				if (prev == null) {
					head = llist.next;
					return head;
				}

				prev.next = llist.next;
				change = false;
			}

			prev = llist;
			llist = llist.next;
			pos++;
		}

		return head;
	}

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */

	public static void reversePrint(SinglyLinkedListNode llist) {

		if (llist == null)
			return;
		reversePrint(llist.next);
		System.out.println(llist.data);

	}

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

		SinglyLinkedListNode current = head;
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

		if (head == null) {
			head = newNode;
			return head;
		}

		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;

		return head;

	}

	// Complete the printLinkedList function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static void printLinkedList(SinglyLinkedListNode head) {

		while (head != null) {

			System.out.print(" " + head.data);
			head = head.next;

		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */

	public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {

		if (llist == null)
			return 0;

		int list1length = getLength(llist);

		int length = list1length - 1;

		while (llist != null) {

			System.out.println(" postion " + length + " data at the position " + llist.data);

			if (length == positionFromTail)
				return llist.data;

			llist = llist.next;
			length--;
		}

		return length;

	}

	public static SinglyLinkedListNode getMiddleNode(SinglyLinkedListNode head) {
		if (head == null)
			return head;

		SinglyLinkedListNode slow = head, fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		SinglyLinkedList llist = new SinglyLinkedList();

		SinglyLinkedList llist2 = new SinglyLinkedList();

//        int llistCount = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < llistCount; i++) {
//            int llistItem = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            llist.insertNode(llistItem);
//        }

		// llist.insertNode(16);
		// llist.insertNode(23);

		// printLinkedList(llist.head);

		int[] arr = { 1, 2, 3, 4 };

		int[] arr2 = { 4, 5, 6 };

		for (int val : arr) {
			SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, val);
			llist.head = llist_head;
		}
//
//		for (int val : arr2) {
//			SinglyLinkedListNode llist_head = insertNodeAtHead(llist2.head, val);
//			llist2.head = llist_head;
//		}
		printLinkedList(llist.head);
		// printLinkedList(insertNodeAtPosition(llist.head, 300, 4));
		System.out.println();
		// printLinkedList(deleteNode(llist.head, 0));
		// reverse(llist.head);

		// printLinkedList(reverse(llist.head));
		// System.out.println(llist.head.data);

		// System.out.println(getLength(llist.head));

		// System.out.println(compareLists(llist.head, llist2.head));

		// SinglyLinkedListNode head = mergeLists(llist.head, llist2.head);
		// System.out.println(head.data);

		// System.out.println(getNode(llist.head, 0));
		// getNode(llist.head, 0);

		// removeDuplicates(llist.head);

//		llist.head=mergeSort(llist.head);

		// SinglyLinkedListNode mNode = getMiddleNode(llist.head);

		// System.out.println(mNode.data);

		// SinglyLinkedListNode middle = getMiddle(llist.head);

		// System.out.println(middle.data);

		// printLinkedList(removeDuplicates(llist.head));

		// printLinkedList(head);

		System.out.println(hasCycle(llist.head));

		scanner.close();
	}
}
