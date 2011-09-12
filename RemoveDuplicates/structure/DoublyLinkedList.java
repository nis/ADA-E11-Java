// Implementation of lists, using doubly linked elements.
// (c) 1998 McGraw-Hill
package structure;

public class DoublyLinkedList implements List
{
    protected int count;
    protected DoublyLinkedListElement head;
    protected DoublyLinkedListElement tail;

    public DoublyLinkedList()
    // post: constructs an empty list
    {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(Object value)
    // post: adds value to beginning of list.
    {
        addToHead(value);
    }
    
    public void addToHead(Object value)
    // pre: value is not null
    // post: adds element to head of list
    {
        // construct a new element, making it the head
        head = new DoublyLinkedListElement(value, head, null);
        // fix tail, if necessary
        if (tail == null) tail = head;
        count++;
    }

    public Object removeFromHead()
    // pre: list is not empty
    // post: removes first value from list
    {
        Assert.pre(!isEmpty(),"List is not empty.");
        DoublyLinkedListElement temp = head;
        head = head.next();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null; // remove final value
        }
        temp.setNext(null);// helps clean things up; temp is free
        count--;
        return temp.value();
    }

    public void addToTail(Object value)
    // pre: value is not null
    // post: adds new value to tail of list
    {
        // construct new element
        tail = new DoublyLinkedListElement(value, null, tail);
        // fix up head
        if (head == null) head = tail;
        count++;
    }

    public Object removeFromTail()
    // pre: list is not empty
    // post: removes value from tail of list
    {
        Assert.pre(!isEmpty(),"List is not empty.");
        DoublyLinkedListElement temp = tail;
        tail = tail.previous();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        count--;
        return temp.value();
    }

    public Object peek()
    // pre: list is not empty
    // post: returns first value in list.
    {
        return head.value();
    }

    public Object tailPeek()
    // pre: list is not empty
    // post: returns last value in list.
    {
        return tail.value();
    }

    public boolean contains(Object value)
    // pre: value not null
    // post: returns true iff value is in the list
    {
        DoublyLinkedListElement finger = head;
        while ((finger != null) && (!finger.value().equals(value)))
        {
            finger = finger.next();
        }
        return finger != null;
    }

    public Object remove(Object value)
    // pre: value is not null.  List can be empty.
    // post: first element matching value is removed from list
    {
        DoublyLinkedListElement finger = head;
        while (finger != null &&
               !finger.value().equals(value))
        {
            finger = finger.next();
        }
        if (finger != null)
        {
            // fix next field of element above
            if (finger.previous() != null)
            {
                finger.previous().setNext(finger.next());
            } else {
                head = finger.next();
            }
            // fix previous field of element below
            if (finger.next() != null)
            {
                finger.next().setPrevious(finger.previous());
            } else {
                tail = finger.previous();
            }
            count--;            // fewer elements
            return finger.value();
        }
        return null;
    }

    public int size()
    // post: returns the number of elements in list
    {
        return count;
    }

    public boolean isEmpty()
    // post: returns true iff the list has no elements.
    {
        return size() == 0;
    }

    public void clear()
    // post: removes all the elements from the list
    {
        head = tail = null;
        count = 0;
    }

    public Iterator elements()
    // post: returns iterator that allows the traversal of list.
    {
        return new DoublyLinkedListIterator(head);
    }

    public String toString()
    // post: returns a string representing list
    {
        StringBuffer s = new StringBuffer();
        s.append("<DoublyLinkedList:");
        Iterator li = elements();
        while (li.hasMoreElements())
        {
            s.append(" "+li.nextElement());
        }
        s.append(">");
        return s.toString();
    }
}


class DoublyLinkedListIterator implements Iterator
{
    protected DoublyLinkedListElement head;
    public DoublyLinkedListElement current;

    public DoublyLinkedListIterator(DoublyLinkedListElement h)
    // post: constructs an iterator rooted at list head, h
    {
        head = h;
        reset();
    }

    public void reset()
    // post: resets iterator to list head
    {
        current = head;
    }

    public boolean hasMoreElements()
    // post: returns true iff current element is valid
    {
        return current != null;
    }

    public Object nextElement()
    // post: returns current element and increments iterator
    {
        Object result = current.value();
        current = current.next();
        return result;
    }

    public Object value()
    // pre: hasMoreElements
    // post: returns current element
    {
        return current.value();
    }	

	public DoublyLinkedListElement currentElement()
	// post: returns current element and increments iterator
	{
	    return current;
	}
}
