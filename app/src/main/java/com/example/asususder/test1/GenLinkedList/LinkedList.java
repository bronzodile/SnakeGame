package com.example.asususder.test1.GenLinkedList;

public class LinkedList<T>{
	private int size;
	private ListNode<T> head;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	public void add (T what) {
		size++;
		ListNode<T> temp = new ListNode<T>(what, head);
		head = temp;
	}
	
	public boolean equals(Object obj) {
		return (this.head == ((LinkedList)obj).head) && (this.size == ((LinkedList)obj).size);		
	}
	
	public T getValue(int index) {
		ListNode<T> lnLoop = head;
		while (index != 0) {
			index--;
			lnLoop = lnLoop.ln;
		}
		return lnLoop.k;
	}
	
	public int length() {
		return size;
	}
	
	
	public void print () {
		ListNode lnLoop = head;
		while (lnLoop != null ) {
			System.out.println(" " + lnLoop.k);
			lnLoop = lnLoop.ln ;
		}
		System.out.println("The current size is " + size);
	}
	
	public boolean search (T what){
		ListNode lnLoop = head;
		while (lnLoop != null) {
			if (lnLoop.k.equals(what))
			{
				return true;
			}
			lnLoop = lnLoop.ln;
		}
		return false;
	}
	
	public void delete (T what) {
		if (head == null) {
			return;
		}
		ListNode<T> lnPrev = head;
		ListNode<T> lnLoop = head.ln;
		if (head.k.equals(what)) {
			head = head.ln;
			size--;
			return;
		}
		while (lnLoop != null) {
			if (what.equals(lnLoop.k)){
				lnPrev.ln = lnLoop.ln;
				size--;
				return;
			}
			lnPrev = lnLoop;
			lnLoop = lnLoop.ln;
		}	
	}
	
	public void append(T what) {
		ListNode<T> lnLoop = head;
			if (lnLoop == null) {
				head = new ListNode<T>(what, null);
				size++;
				return;
			}
			while (lnLoop.ln != null){
				lnLoop = lnLoop.ln;
			}
			lnLoop.ln = new ListNode<T>(what, null);
			size++;
	}
	
	public int findPos(T what) {
		int position = 0;
		ListNode<T> lnLoop = head;
		while (lnLoop != null) {
			if (lnLoop.k.equals(what)) {
				return position;
			}
			position++;
			lnLoop = lnLoop.ln;
		}
		return -1;
	}
	
	public void deletePosition(int position) {
		head = deletePositionHelper(position,head);
		size--;
	}
	private ListNode<T> deletePositionHelper(int position,ListNode<T> currNode){
		if (position == 0) {
			return (currNode.ln);
		} else {
			currNode.ln = deletePositionHelper(position - 1,currNode.ln);
			return(currNode);
		}
		
	}
	
}
