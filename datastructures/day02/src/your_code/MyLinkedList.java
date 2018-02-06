package your_code;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }

        private Node(Chicken d) {
            this.val = d;
            prev = null;
            next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {

        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public void add(Chicken c) {

        addLast(c);
    }

    public Chicken pop() {

        return removeLast();
    }

    public void addLast(Chicken c) {
        Node new_node;
        if (size == 0) {
            new_node = new Node(c, null, null);
            head = new_node;
            tail = new_node;
        }
        else {
            new_node = new Node(c, tail, null);
            tail.next = new_node;
            tail = new_node;
        }
        size++;

    }

    public void addFirst(Chicken c) {
        Node new_node;
        if (size == 0) {
            new_node = new Node(c, null, null);
            head = new_node;
            tail = head;
        }
        new_node = new Node(c, null, head);
        head = new_node;
        size++;
    }

    public Chicken get(int index) {
        indexCheck(index);
        Node new_node = head; // don't have to create a new node since I already have head!
        for (int i=0; i<index; i++) {
            new_node = new_node.next;
        }
        // add in if statement for tail!

        Chicken foundChicken = new_node.val;
        return foundChicken;
    }

    public Chicken remove(int index) {
        Chicken chickenRun;
        indexCheck(index);
        Node new_node = head;
        if (index == size()-1) {
            chickenRun = tail.val;
            tail = tail.prev;
            size--;
            return chickenRun;
        }
        else {
            for (int i=0; i<index; i++) {
                new_node = new_node.next;
            }
            chickenRun = new_node.val;
            new_node.val = new_node.next.val;
            new_node.next = new_node.next.next;
            for (int i = index; i == size()-1; i++) {
                new_node = new_node.next;
            }
            tail = new_node;
            size--;
            return chickenRun;
        }
    }

    public Chicken removeFirst() {
        Chicken chickenRun;
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        else if (size == 1) {
            chickenRun = head.val;
            head = null;
            tail = head;
            size--;
            return chickenRun;
        }
        else {
            chickenRun = head.val;
            head = head.next;
            size--;
            return chickenRun;
        }
    }

    public Chicken removeLast() {
        Chicken chickenRun;
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        else if (size == 1) {
            chickenRun = tail.val;
            tail = null;
            head = tail;
            size--;
            return chickenRun;
        }
        chickenRun = tail.val;
        tail = tail.prev;
        size--;
        return chickenRun;
    }

    private void indexCheck(int index) {
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException();
    }
}