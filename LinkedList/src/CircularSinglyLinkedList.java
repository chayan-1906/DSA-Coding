import java.util.Scanner;

public class CircularSinglyLinkedList {

    public static ListNode head;
    public static ListNode tail;
    private static int length;

    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        tail = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    // choice 1
    public static void createCircularSinglyLinkedList(int data) {
        ListNode newnode = new ListNode ( data );
        if (head == null) {
            head = tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
        newnode.next = head;
    }

    // choice 2
    public static void displayCircularSinglyLinkedList() {
        if (head == null) {
            System.out.println ( "List is empty" );
            return;
        }
        ListNode currentNode = head;
        System.out.println ( "Nodes of circular linked list: " );
        do {
            System.out.print ( currentNode.data + " -- > " );
            currentNode = currentNode.next;
        } while (currentNode.next != head);
        System.out.println ( currentNode.data );
    }

    // choice 3
    public static void insertNodeAtBeginning(int nodeData) {
        ListNode newnode = new ListNode ( nodeData );
        if (head == null) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
        tail.next = head;
        length++;
    }

    // choice 4
    public static void insertNodeAtEnd(int nodeData) {
        ListNode newnode = new ListNode ( nodeData );
        if (head == null) {
            head = tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
        newnode.next = head;
        length++;
    }

    // choice 5
    public static void deleteNodeFromBeginning() {
        if (head == null) {
            System.out.println ( "Linked list is already empty" );
            return;
        } else if (head.next == head) {
            head = tail = null;
        } else {
            tail.next = head.next;
            head = head.next;
        }
        length--;
        System.out.println ( "Successfully deleted" );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner ( System.in );
        int nodeData, choice;
        do {
            System.out.print ( "Enter your choice: " );
            choice = scanner.nextInt ( );
            if (choice == 1) {
                System.out.print ( "Enter no. of nodes: " );
                length = scanner.nextInt ( );
                for (int i = 0; i < length; i++) {
                    System.out.print ( "Node - " + (i + 1) + ": " );
                    nodeData = scanner.nextInt ( );
                    createCircularSinglyLinkedList ( nodeData );
                }
            } else if (choice == 2) {
                displayCircularSinglyLinkedList ( );
            } else if (choice == 3) {
                System.out.print ( "Enter data to be inserted at beginning: " );
                nodeData = scanner.nextInt ( );
                insertNodeAtBeginning ( nodeData );
            } else if (choice == 4) {
                System.out.print ( "Enter data to be inserted at end: " );
                nodeData = scanner.nextInt ( );
                insertNodeAtEnd ( nodeData );
            } else if (choice == 5) {
                deleteNodeFromBeginning ( );
            }
        } while (choice != 100);
    }

}
