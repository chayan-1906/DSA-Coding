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

    public static void main(String[] args) {
        Scanner scanner = new Scanner ( System.in );
        int nodeData, pos, key;
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
                    createCircularSinglyLinkedList ( nodeData );
                }
            } else if (choice == 2) {
                displayCircularSinglyLinkedList ( );
            }
        } while (choice != 100);
    }

}
