package org.example.dataStructure;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(String data) {
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public static void main(String[] args) {
        LinkedList lista = new LinkedList("Elemento 1");
        lista.append("Elemento 2");
        lista.append("Elemento 3");
        lista.append("Elemento 4");
        lista.prepend("Elemento 0");

        lista.getHead();
        lista.getTail();
        lista.getLenght();
        lista.print();

        System.out.println("Item removido: " + lista.removeLast().data);

        System.out.println("Item removido: " + lista.removeFirst().data);

        System.out.println("Capturando item 2: " + lista.get(2).data);

        lista.insert("Elemento 2.5", 2);
        lista.set(1, "Elemento 0.99");

        lista.remove(2);
        lista.print();
    }

    public void append(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        length++;
    }

    public void prepend(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        length++;
    }

    public boolean insert(String data, int index) {
        if (index < 0 || index >= length) return false;

        if (index == 0) {
            prepend(data);
            return true;
        }

        if (index == length) {
            append(data);
            return true;
        }

        Node newNode = new Node(data);
        Node temp = get(index - 1);

        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public boolean set(int index, String data) {
        Node temp = get(index);

        if (temp != null) {
            temp.data = data;
            return true;
        }

        return false;
    }

    public Node removeLast() {
        if (length == 0) return null;

        Node temp = head;
        Node removedNode = null;

        while (temp.next != tail) {
            temp = temp.next;
        }

        removedNode = tail;
        tail = temp;
        tail.next = null;

        length--;

        return removedNode;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node remove(int index){
        if (index < 0 || index >= length) return null;
        if (index==0) return removeFirst();
        if (index==length-1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    public void getHead() {
        if (this.head == null) {
            System.err.println("Lista vazia");
        } else {
            System.out.println("Head: " + head.data);
        }
    }

    public void getTail() {
        if (this.tail == null) {
            System.err.println("Lista vazia");
        } else {
            System.out.println("Tail: " + tail.data);
        }
    }

    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void getLenght() {
        System.out.println("Length: " + this.length);
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }
}
