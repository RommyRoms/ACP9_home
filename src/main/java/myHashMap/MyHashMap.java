package myHashMap;

import java.util.*;


public class MyHashMap<K,V> implements Map<K,V> {
    Map<Integer,String> map = new HashMap<>();
    public static final int DEFAULT_TABLE_SIZE = 16;

    private Node[] table;
    private int size;
    private double loadFactor = 0.75;
    //TODO:ensureCapacity();

    public MyHashMap() {
        table = new Node[DEFAULT_TABLE_SIZE];
    }

    public MyHashMap(int capasity){
        table = new Node[capasity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean rez = false;
        int hash = key.hashCode();
        int pos = Math.abs(hash % table.length);
        Node iter = table[pos];
        while(iter != null){
            if(iter.key.equals(key)){
                rez = true;
            }
            iter = iter.next;
        }
        return rez;
    }

    @Override
    public boolean containsValue(Object value) {
        Node[] tab; V v;
        if ((tab = table) != null && size > 0) {
            for (int i = 0; i < tab.length; ++i) {
                for (Node e = tab[i]; e != null; e = e.next) {
                    if ((v = (V)e.getValue()) == value ||
                            (value != null && value.equals(v)))
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {

        if(!containsKey(key)){
            return null;
        }

        int hash = key.hashCode();
        int position = Math.abs(hash % table.length);

        Node iter = table[position];
        while(iter != null){
            if(iter.key.equals(key)){
                return (V) iter.val;
            }
            iter = iter.next;
        }

        return null;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode());
    }


    @Override// K must override hashCode and equals
    public V put(K key, V value) {


        if(containsKey(key)){
            throw new ContainsKeyException("MayHashMap contains this key" + key);
        }


        int hash = key.hashCode();
        int position = Math.abs(hash % table.length);

        if(table[position] == null){
            table[position] = new Node(key,value, null);
            size++;
        } else {
            Node iter = table[position];
            while(iter.next != null){
                iter = iter.next;
            }
            iter.next = new Node(key,value, null);
            size++;
        }

        return null;
    }

    @Override
    public V remove(Object key) {
        int position = Math.abs(key.hashCode() % table.length);
        Node node = table[position];
        return getNodeVal(node);
    }

    private V getNodeVal(Node node){
        if (node.next!=null ){
            return getNodeVal(node.next);
        }else {
            V rez = (V)node.val;
            node.key = null;
            node.val =null;
            node.next = null;
            return rez;
        }
    }
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        table = new Node[table.length];
        size = 0;

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {


        return null;
    }

    private static class MyHashMapTableIterator implements Iterator<Node>{

        private Node curr;

        public MyHashMapTableIterator() {
            // find first current
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Node next() {
            return null;
        }
    }



    private static class Node implements Entry {

        Object key;
        Object val;
        Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return val;
        }

        @Override
        public Object setValue(Object value) {
            Object old = val;
            val = value;
            return old;
        }
    }
}