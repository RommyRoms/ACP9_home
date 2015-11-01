package BST;

import java.util.Comparator;


public class BST<E> implements iBST<E> {

    private TNode<E> root;
    private Comparator<E> comparator;
    private int size = 0;
    private TNode<E> temp;


    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void add(E obj) {
        // compareTo with root
        // <  hasFreeLeftPlace -> create new node link with parent
        // > hasFreeRightPlace -> create new node link with parent
        // false, recursion comparing ->

        if (root == null) {
            root = new TNode<E>(obj, null, null, null);
            size++;
        } else {
            TNode<E> iter = root;

            while (iter != null) {

                int compareRes = comparator.compare(obj, iter.value);
                if (compareRes < 0) {
                    if (iter.left == null) {
                        iter.left = new TNode<E>(obj, null, null, iter);
                        size++;
                        return;
                    } else {
                        iter = iter.left;
                    }
                } else if (compareRes > 0) {
                    if (iter.right == null) {
                        iter.right = new TNode<E>(obj, null, null, iter);
                        size++;
                        return;
                    } else {
                        iter = iter.right;
                    }
                }
            }

        }


    }

    @Override
    public boolean contains(E obj) {
        return find(obj, root) != null;
    }


    private TNode<E> find(E el, TNode<E> iter) {

        if (iter == null) {
            return null;
        }

        int compareRes = comparator.compare(el, iter.value);

        if (compareRes < 0) {
            return find(el, iter.left);
        } else if (compareRes > 0) {
            return find(el, iter.right);
        }

        //return compareRes < 0 ? find(el, iter.left) : compareRes > 0 ? find(el, iter.left) : iter;

        return iter;
    }

    @Override
    public boolean remove(E obj) {
        //Node to be removed has no children.
        //This case is quite simple. Algorithm sets corresponding link of the parent to NULL and disposes the node.
        TNode<E> findNode = find(obj, root);
        E val = (E) findNode.parent.value;
        int compareRezult = comparator.compare(findNode.value, val);
        if (findNode == null) {
            return false;
        }
        if (findNode.left == null && findNode.right == null) {
            if (compareRezult > 0) {
                findNode.parent.right = null;
                findNode.parent = null;
                return true;
            } else {
                findNode.parent.left = null;
                findNode.parent = null;
                return true;
            }
            // node with two children
        } else if (findNode.left != null && findNode.right != null) {
            findNode.value = findMinimumAndReturnWithDelete(findNode.left);
            findNode.left.parent = null;
            findNode.left = null;
            return true;

        } else {
            if (findNode.left == null) {
                findNode.right.parent = findNode.parent;
                findNode.parent.right = findNode.right;
                return true;
            } else {
                findNode.left.parent = findNode.parent;
                findNode.parent.left = findNode.left;
                return true;
            }
        }

    }

    private E findMinimumAndReturnWithDelete(TNode<E> node) {
        if (node.left == null){
            E v = node.value;
            node = null;
            return v;
        }
        return findMinimumAndReturnWithDelete(node.left);
    }

    public E getMax() {
        return getMax(root);
    }

    private E getMax(TNode<E> BSTRoot) {
        //check if root is null
        temp = BSTRoot;
        if(temp.right == null) {
            return (E)temp.value;
        } else {
            temp = BSTRoot.right;
            return getMax(temp);
        }
    }

    public E getMin() {
        return getMin(root);
    }

    private E getMin(TNode<E> BSTRoot) {
        //check if root is null
        temp = BSTRoot;
        if(temp.left == null) {
            return (E)temp.value;
        } else {
            temp = BSTRoot.left;
            return getMin(temp);
        }
    }
    @Override
    public int size() {
        return size;
    }

    private String toString(TNode<E> node) {

        String res = "";

        if (node == null) {
            return "";
        }

        String left = toString(node.left);
        String me = node.value.toString() + ",";
        String right = toString(node.right);

        return left + me + right;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private static class TNode<X> {

        X value;
        TNode<X> left;
        TNode<X> right;
        TNode<X> parent;

        public TNode(X value, TNode left,
                     TNode right, TNode parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}







