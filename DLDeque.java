/*
 * A class implementing an ADT DOUBLE ENDED QUEUE using a doubly linked node
 * @author Grant Okamoto
 * @version 1.0
 * 
 */

public class DLDeque<T> implements DequeInterface<T>
{
	private DLNode<T> head;		//pointer to begin of line
	private DLNode<T> tail;		//pointer to end of line
	
	public DLDeque()
	{
		head = null;
		tail = null;
	}

	public void addToFront(T newEntry)
	{
		if(isEmpty())
		{
			DLNode<T> node = new DLNode<T>();
			node.setEntry(newEntry);
			node.setNext(null);
			node.setPrev(null);
			head = node;
			tail = node;
		}
		else
		{
			DLNode<T> node = new DLNode<T>();
			node.setEntry(newEntry);
			node.setPrev(null);
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
	}
	
	public void addToBack(T newEntry)
	{
		if(isEmpty())
		{
			DLNode<T> node = new DLNode<T>();
			node.setEntry(newEntry);
			node.setNext(null);
			node.setPrev(null);
			head = node;
			tail = node;
		}
		else
		{
			DLNode<T> node = new DLNode<T>();
			node.setEntry(newEntry);
			node.setPrev(tail);
			node.setNext(null);
			tail.setNext(node);
			tail = node;
		}
	}
	
	public T removeFront()
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			T tempEntry= head.getEntry();
			head.setEntry(null);
			if(head.getNext() != null)
			{
				
				head = head.getNext();
				head.setPrev(null);
			}
			else
			{
				return null;
			}
			return tempEntry;
		}
	}
	public T removeBack()
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			T tempEntry= tail.getEntry();
			tail.setEntry(null);
			if(tail.getPrev() != null)
			{
				
				tail = tail.getPrev();
				tail.setNext(null);
			}
			else
			{
				return null;
			}
			return tempEntry;
		}
	}
	public void clear()
	{
		while(removeFront() != null)
		{
			removeFront();
		}
	}
	
	public void print()
	{
		DLNode<T> current = head;
		while(current != null)
		{
			System.out.println(current.getEntry());
			current = current.getNext();
		}
	}

	public T getFront() {
		return head.getEntry();
	}

	public T getBack() {
		return tail.getEntry();
	}

	public boolean isEmpty() {
		if(head == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}