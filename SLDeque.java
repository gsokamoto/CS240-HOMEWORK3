/*
 * A class implementing an ADT DOUBLE ENDED QUEUE using a singly linked node
 * @author Grant Okamoto
 * @version 1.0
 * 
 */

public class SLDeque<T> implements DequeInterface<T>{

	private SLNode<T> head;	
	private SLNode<T> tail;
	
	public SLDeque()
	{
		head = null;
		tail = null;
	}
	
	public void print()
	{
		SLNode<T> current = head;
		while(current != null)
		{
			System.out.println(current.getEntry());
			current = current.getNext();
		}
	}
	
	public void addToFront(T newEntry) 
	{
		SLNode<T> node = new SLNode<T>();
		if(isEmpty())
		{
			node.setNext(null);
			node.setEntry(newEntry);
			head = node;
			tail = node;
		}
		else
		{
			node.setNext(head);
			node.setEntry(newEntry);
			head = node;
		}
	}

	public void addToBack(T newEntry) 
	{
		SLNode<T> node = new SLNode<T>();
		if(isEmpty())
		{
			node.setNext(null);
			node.setEntry(newEntry);
			head = node;
			tail = node;
		}
		else
		{
			tail.setNext(node);
			node.setNext(null);
			node.setEntry(newEntry);
			tail = node;
		}
		
	}

	public T removeFront()
	{
		if(isEmpty())
		{
			return null;
		}
		else{
			T tempEntry = head.getEntry();
			head.setEntry(null);
			head = head.getNext();
			return tempEntry;
		}
	}

	public T removeBack()
	{
		SLNode<T> current = head;
		if(isEmpty())
		{
			return null;
		}
		else
		{
			T tempEntry = tail.getEntry();
			tail.setEntry(null);
			while(current.getNext().getNext() != null)
			{
				current = current.getNext();
			}
			current.setNext(null);
			tail = current;
			return tempEntry;
		}
		
	}

	public T getFront()
	{
		return head.getEntry();
	}

	public T getBack()
	{
		return tail.getEntry();
	}

	public boolean isEmpty() 
	{
		if(head == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void clear() 
	{
		
		while(isEmpty() != true)
		{
			removeFront();
		}
	}
}