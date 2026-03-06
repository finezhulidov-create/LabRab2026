package lr9.ex8;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SingleLinkedList  {
    private Node head;

    public SingleLinkedList() {

    }
    public void createHead(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter quantity elements");
            int num = Integer.parseInt(reader.readLine());
        for (int i = 0; i < num; i++) {
            System.out.print("Element: ");
            int value = Integer.parseInt(reader.readLine());
            addFirst(value);
        }
            } catch (IOException e){
            System.out.println("Input Output exception");
        }
    }
    public void createTail(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter quantity elements");
            int num = Integer.parseInt(reader.readLine());
            for (int i = 0; i < num; i++) {
                System.out.print("Element: ");
                int value = Integer.parseInt(reader.readLine());
                addLast(value);
            }
        } catch (IOException e){
            System.out.println("Input exception");
        }
    }

    public void insert(int index, int item){
        if (index < 1){
            throw new IndexOutOfBoundsException();
        }
        if (index == 1){
            addFirst(item);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current !=null; i++) {
            current = current.next;
        }
        if (current == null){
            throw new IndexOutOfBoundsException();

        }
        Node newNode = new Node(item);
        newNode.next = current.next;
        current.next = newNode;
    }
    public void removeFirst(){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }
    @Override
    public String toString() {
       if (head == null) return "[]";
       StringBuilder sb = new StringBuilder();
       sb.append("[");
       Node current = head;
       while (current != null){
           sb.append(current.item);
           if (current.next != null) sb.append(", ");
           current = current.next;
       }
       sb.append("]");
       return sb.toString();
    }

    public void addFirst(int item){
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int item){
        Node newNode = new Node(item);
        if (head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void createHeadRec()  {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter element amount");
            int n = Integer.parseInt(reader.readLine());
            head = createHeadHelper(n);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Node createHeadHelper(int n) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            if (n == 0) return null;
            System.out.print("Element:");
            int value = Integer.parseInt(reader.readLine());
            Node rest = createHeadHelper(n - 1);
            Node node = new Node(value);
            node.next = rest;
            return node;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTailRec(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Elements amount: ");
            int n = Integer.parseInt(reader.readLine());
            head = createTailHelper(0, n);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Node createTailHelper(int curr, int n) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            if (curr == n) return null;
            System.out.println("Element:");
            int value = Integer.parseInt(reader.readLine());
            Node node = new Node(value);
            node.next = createTailHelper(curr+1,n);
            return node;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toStringRec() {
        if (head == null) return "[]";
        return "[" + toStringRecHelper(head) + "]";
    }

    private String toStringRecHelper(Node node) {
        if (node == null) return "";
        if (node.next == null) return String.valueOf(node.item);
        return node.item + ", " + toStringRecHelper(node.next);
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
    public void remove(int index) {
        if (index < 1 || head == null) {
            System.out.println("Ошибка: неверный индекс или список пуст");
            return;
        }
        if (index == 1) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 1; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Ошибка: индекс за пределами списка");
            return;
        }
        current.next = current.next.next;
    }


    private static class Node  {
        int item;
        Node next;

        public Node(int item) {
            this.item = item;
            this.next = null;
        }
    }
}
