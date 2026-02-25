package lr9.ex5;



public class TestLinkedListHead {
    static class Node{
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        private int value;
        private Node next;
        private Node head;
        private Node tail;

    }

    public static void main(String[] args) {
        Node node = new Node(0, null);
        Node node1 = new Node(1,null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        node.head = node;
        node.tail = node3;

        node.next = node1;
        node1.next =node2;
        node2.next = node3;

        Node iter = node;

        while (iter != null){
            System.out.println(" " + iter.value);
            iter = iter.next;
        }
    }
}
