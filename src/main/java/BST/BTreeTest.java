package BST;

import java.util.Comparator;

public class BTreeTest {

    private BST<Integer> bTree = null;

    public BTreeTest() {

        bTree = new BST<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    private void testSimpleAdd(){
        bTree.add(2);
        bTree.add(1);
        bTree.add(3);
        bTree.add(5);
        bTree.add(7);
        bTree.add(4);

        if(bTree.size() != 6){
            System.out.println("Test add failed");
        } else {
            System.out.println("Test add success");
        }
    }


    private void testContains(){
        bTree.add(88);
        if(bTree.contains(88)){
            System.out.println("Test contains success");
        } else {
            System.out.println("Test contains failed");
        }
    }

    private void remove(){
        System.out.println(bTree);
        bTree.remove(5);
        System.out.println(bTree);
    }

    public void start(){
        testSimpleAdd();
        System.out.println(bTree.getMax());
        System.out.println(bTree.getMin());
        testContains();
        remove();
    }



}