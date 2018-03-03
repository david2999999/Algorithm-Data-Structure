package Trees;

import java.nio.BufferUnderflowException;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{

    // the binary node that keep track of its left and right nodes
    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        BinaryNode(AnyType theElement){
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt){
            element = theElement;
            left = lt;
            right = rt;
        }
    }

    // keeps track of the root of the tree
    private BinaryNode<AnyType> root;

    // initialize the root to null
    public BinarySearchTree(){
        root = null;
    }

    public void makeEmpty(){
        root = null;
    }

    // checks if the tree is empty
    public boolean isEmpty(){
        return root == null;
    }

    // check if the tree contains an element x
    public boolean contains(AnyType x){
        return contains(x, root);
    }

    // find the minimum element data in the tree
    public AnyType findMin(){
        if (isEmpty()) throw new BufferUnderflowException();
        return findMin(root).element;
    }

    // find the maximum element data in the tree
    public AnyType findMax(){
        if (isEmpty()) throw new BufferUnderflowException();
        return findMax(root).element;
    }

    // insert an element x into the tree
    public void insert(AnyType x){
        root = insert(x, root);
    }
    // remove an element x from the tree
    public void remove(AnyType x){
        root = remove(x, root);
    }

    // print the whole tree
    public void printTree(){
        if (isEmpty())
            System.out.println("Empty Tree");
        else
            printTree(root);
    }

    // checks if an element x is in the tree using recursion
    private boolean contains(AnyType x, BinaryNode<AnyType> t){
        // if no such element is in the tree
        if (t == null){
            return false;
        }

        int compareResult = x.compareTo(t.element);

        // check if we should traverse to the right or left
        if (compareResult < 0){
            return contains(x, t.left);
        }else if(compareResult > 0){
            return contains(x, t.right);
        }else
            return true; // match
    }

    // Find the minimum value from the root using recursion
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){

        if (t == null){
            return null;    // nothing is found
        }else if(t.left == null){
            return t;       // found the last element
        }

        return findMin(t.left); // decrement the element value
    }

    // finding the maximum value in the tree using while loop
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){

        if (t != null){
            while (t.right != null){
                t = t.right;
            }
        }

        return t;
    }

    // insert an element into the tree
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
        // found a place to insert the element
        if (t == null){
            return new BinaryNode<AnyType>(x, null, null);
        }

        int compareResult = x.compareTo(t.element);

        // traverse through the tree
        // checks if the element should be inserted into the left or right
        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            ; // duplicate, do nothing

        return t;
    }

    // removes an element from the tree
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t){
        // there is no such element
        if (t == null)
            return t;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if(compareResult > 0)
            t.right = remove(x , t.right);
        else if (t.left != null && t.right != null){
            // if the node has 2 child elements
            // replace the node with the smallest value from the right
            // then remove the smallest value from the right
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        }else
            // remove the element by replacing it with its right or left value
            t = (t.left != null) ? t.left : t.right;

        return t;
    }

    // print the whole tree using recursion
    private void printTree(BinaryNode<AnyType> t){
        if (t != null){
            printTree(t.left);  // left side of the node
            System.out.println(t.element);  // the node itself
            printTree(t.right); // right side of the node
        }
    }

}




















