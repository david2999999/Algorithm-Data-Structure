//1. The CustomArrayList will maintain the underlying array, the array capacity, and the current
//   number of items stored in the CustomArrayList.
//2. The CustomArrayList will provide a mechanism to change the capacity of the underlying
//   array. The capacity is changed by obtaining a new array, copying the old array into the
//   new array, and allowing the Virtual Machine to reclaim the old array.
//3. The CustomArrayList will provide an implementation of get and set.
//4. The CustomArrayList will provide basic routines, such as size, isEmpty, and clear, which are
//   typically one-liners; a version of remove; and also two versions of add. The add routines
//   will increase capacity if the size and capacity are the same.
//5. The CustomArrayList will provide a class that implements the Iterator interface. This class
//   will store the index of the next item in the iteration sequence and provide implementations
//   of next, hasNext, and remove. The MyArrayList’s iterator method simply returns
//   a newly constructed instance of the class that implements the Iterator interface.

public class CustomArrayList<AnyType> implements Iterable<AnyType> {

    // create a default capacity for the array
    private static final int DEFAULT_CAPACITY = 10;

    // holds the current size of the arraylist
    private int theSize;

    // holds all of the data
    private AnyType[] theItems;

    // function constructor
    public CustomArrayList(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    // initialize theSize to 0
    // set the default capacity of the arrayList
    public void doClear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    // returning the current size of the arrayList
    public int size(){
        return theSize;
    }

    // check if the arrayList is empty
    public boolean isEmpty(){
        return size() == 0;
    }

    // allows the arrayList to shrink down to the current
    // size of the arrayList
    public void trimToSize(){
        ensureCapacity(size());
    }

    // getting a value at a specific index
    public AnyType get(int idx){
        if( idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException();

        return theItems[idx];
    }

    // update a value at a specific index
    public AnyType set(int idx, AnyType newVal){
        if (idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException();

        AnyType old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    // changes the new capacity of the arrayList
    // by duplicating the values from the old arrayList
    // to the new ArrayList
    // Also the new ArrayList will have a larger size than the old ArrayList
    public void ensureCapacity(int newCapacity){
        if (newCapacity < theSize)
            return;

        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];

        for (int i = 0; i < size(); i++)
            theItems[i] = old[i];
    }

    // Adds an element to the rear
    public boolean add(AnyType x){
        add(size(), x);
        return true;
    }

    // adds an element to a specific index

    public void add(int idx, AnyType x){
        // if the current size is equal to the maximum size of the arrayList
        // adjust the size by creating a new ArrayList with a larger size
        if (theItems.length == size()){
            ensureCapacity(size() * 2 + 1);
        }

        // Shift all of the elements after the idx
        // to make room for the new element
        for (int i = theSize; i > idx; i--){
            theItems[i] = theItems[i-1];
        }

        theItems[idx] = x;

        // increase the current size of the ArrayList
        theSize++;
    }

    // removes an element from a specific index
    public AnyType remove(int idx){
        AnyType removedItem = theItems[idx];

        // shift the arrayList backward to
        // overwrite the element at that index
        for (int i = idx; i < size() - 1; i++){
            theItems[i] = theItems[i + 1];
        }

        // decrease the current size
        theSize--;

        return removedItem;
    }


    // creating a public iterator
    public java.util.Iterator<AnyType> iterator(){
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<AnyType>{

        private int current = 0;

        public boolean hasNext(){
            return current < size();
        }

        // returning the current element
        // then incrementing to the next index
        public AnyType next(){
            if (!hasNext()){
                throw new java.util.NoSuchElementException();
            }

            return theItems[current++];
        }

        // deleting the element before the current index
        public void remove(){
            CustomArrayList.this.remove(--current);
        }

    }
}
