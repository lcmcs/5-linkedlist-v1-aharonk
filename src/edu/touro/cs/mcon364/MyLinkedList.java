package edu.touro.cs.mcon364;


import java.util.*;

public class MyLinkedList implements List<String> {
    private static class Node
    {
        private String data;
        private Node next;

        public Node() {}

        public Node (String s) {
            data = s;
        }
    }

    private final Node head = new Node();
    private Node end = head;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(String s) {
        Node n = new Node(s), oldEnd = end;
        end = n;
        oldEnd.next = n;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
//        if (o != null && !(o instanceof String)) {
//            return false;
//        }
//
//        String target = (String) o;
        Node curr = head, prev;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
            if (Objects.equals(o, curr.data)) { //(o == null && curr.data == null) || curr.data.equals(target)
                prev.next = curr.next;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        head.next = null;
        end = head;
    }

    // Since we have no reference to prev, we need to get the prev to do many operations.
    private Node findPreceding(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", index, size));
        }

        Node curr = head;
        // `i` is the index of the node we actually want, i.e. when we want index 0 we return index -1.
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr;
    }

    @Override
    public String get(int index) {
        return findPreceding(index).next.data;
    }

    @Override
    public String set(int index, String element) {
        Node n = findPreceding(index).next;
        String oldData = n.data;
        n.data = element;
        return oldData;
    }

    // todo below

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void add(int index, String element) {

    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }


    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }


}