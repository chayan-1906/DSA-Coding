import java.util.Scanner;

public class SinglyLinkedList {

    private static ListNode head;
    private static ListNode tail;

    private static class ListNode {
        private final int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void createSinglyLinkedList(int value) {
        ListNode newnode = new ListNode ( value );
        if (head == null) {
            // for first node
            head = newnode;
        } else {
            // second node onwards
            tail.next = newnode;
        }
        tail = newnode;
    }

    public static void insertNodeAtBeginning(int value) {
        ListNode newnode = new ListNode ( value );
        if (head != null) {
            newnode.next = head;
        }
        head = newnode;
    }

    public static void insertNodeAtEnd(int value) {
        ListNode newnode = new ListNode ( value );
        // using 2 pointer, head & tail
        /*if (head == null) {
            head = newnode;
        } else {
            tail.next = newnode;
        }
        tail = newnode;*/
        // using single pointer, head
        if (head == null) {
            head = newnode;
            return;
        }
        ListNode currentNode = head;
        while (currentNode.next != null) currentNode = currentNode.next;
        currentNode.next = newnode;
    }

    public static void displayLinkedList() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print ( currentNode.data + " --> " );
            currentNode = currentNode.next;
        }
        System.out.print ( "null\n" );
    }

    public static int length() {
        int noOfNodes = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            noOfNodes++;
            currentNode = currentNode.next;
        }
        return noOfNodes;
    }

    public static void main(String[] args) {
//        SinglyLinkedList singlyLinkedList = new SinglyLinkedList ( );
        Scanner scanner = new Scanner ( System.in );
        int length, nodeData = 0;
        int choice;
        do {
            System.out.print ( "Enter your choice: " );
            choice = scanner.nextInt ( );
            if (choice == 1) {
                System.out.print ( "Enter no. of nodes: " );
                length = scanner.nextInt ( );
                for (int i = 0; i < length; i++) {
                    System.out.print ( "Node - " + (i + 1) + ": " );
                    nodeData = scanner.nextInt ( );
                    createSinglyLinkedList ( nodeData );
                }
            } else if (choice == 2) {
                displayLinkedList ( );
            } else if (choice == 3) {
                System.out.println ( "Length: " + length ( ) );
            } else if (choice == 4) {
                System.out.print ( "Enter data to be added at beginning: " );
                nodeData = scanner.nextInt ( );
                insertNodeAtBeginning ( nodeData );
            } else if (choice == 5) {
                System.out.print ( "Enter data to be added at end: " );
                nodeData = scanner.nextInt ( );
                insertNodeAtEnd ( nodeData );
            }
        } while (choice != 100);
    }
}
