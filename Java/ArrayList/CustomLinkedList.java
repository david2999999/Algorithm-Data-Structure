//1. The CustomLinkedList class itself, which contains links to both ends, the size of the list, and
//   a host of methods.
//2. The Node class, which is likely to be a private nested class. A node contains the data
//   and links to the previous and next nodes, along with appropriate constructors.
//3. The LinkedListIterator class, which abstracts the notion of a position and is a private
//   inner class, implementing the Iterator interface. It provides implementations of next,
//   hasNext, and remove.

public class CustomLinkedList<AnyType> implements Iterable<AnyType> {

    // create the node for the doubly linked list
    // create nodes that points to the previous and the next node
    private static class Node<AnyType>{
        public AnyType data;
        public Node<AnyType> prev, next;

        public Node(AnyType d, Node<AnyType> p , Node<AnyType> n){
            data = d;
            prev = p;
            next = n;
        }
    }

    // declaring theSize of the linkedList
    // the Modification count
    // The start of the list
    // the end of the list
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    // constructor and initializer
    public CustomLinkedList(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    // creates a new list with a size of 0 and modification of 0
    // creates the start and end markers
    private void doClear(){
        beginMarker = new Node<AnyType>(null, null , null);
        endMarker = new Node<AnyType>(null, beginMarker, null );
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    // return the size of the list
    public int size(){
        return theSize;
    }

    // check if the list has no elements
    public boolean isEmpty(){
        return size() == 0;
    }

    // add an element to the end of list
    public boolean add(AnyType x){
        add(size(), x);
        return true;
    }

    // add an element to a specific index
    public void add(int idx, AnyType x){
        // getNode function divides the list in half
        // before finding the element in the list
        // then we use the addBefore function to add
        // the element x before the node that was found
        addBefore( getNode(idx, 0, size()), x);
    }

    // get the data from a specific index
    public AnyType get(int idx){
        return getNode(idx).data;
    }

    // update the data at a specific index
    public AnyType set(int idx, AnyType newVal){
        Node<AnyType> p = getNode(idx);
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    // removes an element from the list
    public AnyType remove(int idx){
        return remove( getNode(idx));
    }

    // add a value before a specific node
    private void addBefore(Node<AnyType> p , AnyType x){
        Node<AnyType> newNode = new Node<>(x, p.prev, p);
        p.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    // removes the specific node from the list
    private AnyType remove(Node<AnyType> p){
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;

        return p.data;
    }

    // get node at a specific index
    private Node<AnyType> getNode( int idx){
        return getNode(idx, 0, size() - 1);
    }

    // divides the list in half before finding for the node
    // at the index idx
    private Node<AnyType> getNode(int idx, int lower, int upper){
        Node<AnyType> p;

        if(idx < lower || idx > upper){
            throw new ArrayIndexOutOfBoundsException();
        }

        // if the idx is below half of the list
        if (idx < size() / 2){
            p = beginMarker.next;
            for (int i = 0; i < idx ; i++){
                p = p.next;
            }
        }else {
            // if idx is above half of the list
            p = endMarker;
            for (int i = size(); i > idx; i--){
                p = p.prev;
            }
        }

        return p;
    }


    public java.util.Iterator<AnyType> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements java.util.Iterator<AnyType>{
        // set the current to the beginning of the list
        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        // check if there is still next element
        public boolean hasNext(){
            return current != endMarker;
        }

        // goes to the next element in the list
        public AnyType next(){
            if (modCount != expectedModCount){
                throw new java.util.ConcurrentModificationException();
            }

            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }

            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        // removes the current element
        public void remove(){
            if (modCount != expectedModCount){
                throw new java.util.ConcurrentModificationException();
            }

            if (!hasNext()){
                throw new java.util.NoSuchElementException();
            }

            CustomLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }


}


















