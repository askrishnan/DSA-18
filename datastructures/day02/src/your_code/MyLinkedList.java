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
<<<<<<< HEAD
=======
        // Constructor for LinkedList class, with head, tail, size.
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
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
<<<<<<< HEAD
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
=======
        // Adds chicken to the end of the linked list.
        // c : Chicken to add to the list.
        // Returns void.
        Node chicken_node = new Node(c, null, null);
        if(isEmpty()) {
            head = chicken_node;
            tail = chicken_node;
        }
        else {
            chicken_node.prev = tail;
            tail.next = chicken_node;
            tail = chicken_node;
        }
        size++;
    }

    public void addFirst(Chicken c) {
        // Adds chicken to the beginning of the linked list.
        // c : Chicken to add to the list.
        // Returns void.
        Node chicken_node = new Node(c, null, null);
        if(isEmpty()) {
            head = chicken_node;
            tail = chicken_node;
        }
        else {
            chicken_node.next = head;
            head.prev = chicken_node;
            head = chicken_node;
        }
        size++;

    }

    public Chicken get(int index) {
        // TODO
        if (index < 0 || index > size) {
            return null;
        }
        else if (isEmpty()) {
            return null;
        }
        else {
            int current_index = 0;
            Node current_node = head;
            while (current_index != index) {
                current_node = current_node.next;
                current_index++;
            }
            return current_node.val;
        }
    }

    public Chicken remove(int index) {
        // Removes chicken at index from the linked list.
        // index : The index of the chicken to remove.
        // Returns Chicken removed from the list.
        Chicken null_chicken = null;
        if (isEmpty()) {
            return null;
        }
        else if (size == 0) {
            null_chicken = head.val;
            head = null;
            tail = null;
        }
        else {
            if (index < 0 || index >= size) {
                return null;
            }
            else if (index == 0) {
                return removeFirst();
            }
            else if (index == size - 1) {
                return removeLast();
            }
            else {
                int current_index = 0;
                Node current_node = head;
                Node next_node;
                while (current_index != index) {
                    next_node = current_node.next;
                    current_node = next_node;
                    current_index++;
                }
                current_node.prev.next = current_node.next;
                current_node.next.prev = current_node.prev;
                null_chicken = current_node.val;
            }
        }
        size--;
        return null_chicken;
    }

    public Chicken removeFirst() {
        // Removes chicken at the front of the linked list.
        // Returns Chicken removed from the list.
        Chicken null_chicken = null;
        if (isEmpty()) {
            return null;
        }
        else if (size == 1) {
            null_chicken = head.val;
            head = null;
            tail = null;
        }
        else {
            null_chicken = head.val;
            head = head.next;
            head.prev = null;
        }
        size--;
        return null_chicken;
    }

    public Chicken removeLast() {
        // Removes chicken at the end of the linked list.
        // Returns Chicken removed from the list.
        Chicken null_chicken = null;
        if(isEmpty()) {
            return null;
        }
        if (size == 1) {
            null_chicken = head.val;
            head = null;
            tail = null;
        }
        else {
            null_chicken = tail.val;
            tail = tail.prev;
        }
        size--;
        return null_chicken;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }
}