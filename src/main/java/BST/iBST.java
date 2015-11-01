package BST;

/**
 * Created by ro on 25.09.2015.
 */
public interface iBST<T> {

    void add(T obj);

    boolean contains(T obj);

    boolean remove(T obj);

    int size();

}
