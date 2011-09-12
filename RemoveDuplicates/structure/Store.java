// Interface for classes that store multiple values.
// (c) 1998 McGraw-Hill

package structure;

public interface Store
{
    public int size();
    // post: returns the number elements contained in the store.

    public boolean isEmpty();
    // post: returns true iff store is empty

    public void clear();
    // post: clears the store
}
