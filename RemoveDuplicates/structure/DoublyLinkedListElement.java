// Elements used in implementation of doubly linked lists.
// (c) 1998 McGraw-Hill
package structure;

public class DoublyLinkedListElement
{
    protected Object data;
    protected DoublyLinkedListElement nextElement;
    protected DoublyLinkedListElement previousElement;

    public DoublyLinkedListElement(Object v,
                            DoublyLinkedListElement next,
                            DoublyLinkedListElement previous)
    // post: constructs new element with list
    //       prefix referenced by previous and
    //       suffix referenced by next
    {
        data = v;
        nextElement = next;
        if (nextElement != null)
            nextElement.previousElement = this;
        previousElement = previous;
        if (previousElement != null)
            previousElement.nextElement = this;
    }

    public DoublyLinkedListElement(Object v)
    // post: constructs a single element
    {
        this(v,null,null);
    }

    public DoublyLinkedListElement next()
    // post: returns the element that follows this
    {
        return nextElement;
    }

    public DoublyLinkedListElement previous()
    // post: returns element that precedes this
    {
        return previousElement;
    }

    public Object value()
    // post: returns value stored here
    {
        return data;
    }

    public void setNext(DoublyLinkedListElement next)
    // post: sets value associated with this element
    {
        nextElement = next;
    }

    public void setPrevious(DoublyLinkedListElement previous)
    // post: establishes a new reference to a previous value
    {
        previousElement = previous;
    }

    public void setValue(Object value)
    // post: sets a new value for this object
    {
        data = value;
    }

    public boolean equals(Object other)
    // post: returns true if this object and other are equal
    {
        DoublyLinkedListElement that = (DoublyLinkedListElement)other;
        if (that == null) return false;
        if (that.value() == null || value() == null)
        {
            return value() == that.value();
        } else {
            return value().equals(that.value());
        }
    }

    public int hashCode()
    // post: generates hash code for element
    {
        if (value() == null) return super.hashCode();
        else return value().hashCode();
    }

    public String toString()
    // post: returns string representation of element
    {
        return "<DoublyLinkedListElement: "+value()+">";
    }
}       

