import java.util.Objects;
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

    // choice 1
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

    // choice 2
    public static void displayLinkedList() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print ( currentNode.data + " --> " );
            currentNode = currentNode.next;
        }
        System.out.print ( "null\n" );
    }

    // choice 3
    public static int length() {
        int noOfNodes = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            noOfNodes++;
            currentNode = currentNode.next;
        }
        return noOfNodes;
    }

    // choice 4
    public static void insertNodeAtBeginning(int value) {
        ListNode newnode = new ListNode ( value );
        if (head != null) {
            newnode.next = head;
        }
        head = newnode;
    }

    // choice 5
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

    // choice 6
    public static void insertNodeAtPosition(int value, int pos) {
        ListNode newnode = new ListNode ( value );
        if (pos > length ( ) + 1) {
            System.out.println ( "Length must be greater than " + pos );
            return;
        }
        if (head == null) {
            head = newnode;
        } else if (pos == 1) {
            newnode.next = head;
            head = newnode;
        } else {
            ListNode current = head;
            for (int i = 1; i < pos - 1 && current.next != null; i++) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }

    // choice 7
    public static ListNode deleteFirstNode() {
        if (head == null) {
            System.out.println ( "Linked List is already empty" );
            return null;
        }
        ListNode firstNode = head;
        head = head.next;
        firstNode.next = null;
        return firstNode;
    }

    // choice 8
    public static int deleteLastNode() {
        if (head == null) {
            System.out.println ( "Linked List already empty" );
            return -1;
        } else if (head.next == null) {
            int dataToBeDeleted = head.data;
            head = null;
            return dataToBeDeleted;
        }
        ListNode prevLastNode = null;
        ListNode currentNode = head;
        while (currentNode.next != null) {
            prevLastNode = currentNode;
            currentNode = currentNode.next;
        }
        prevLastNode.next = null;
        return currentNode.data;
    }

    // choice 9
    public static int deleteNodeAtPosition(int pos) {
        if (pos >= length ( ) + 1) {
            System.out.println ( "Length must be greater than " + pos );
            return 0;
        }
        if (head == null) {
            System.out.println ( "Linked List already empty" );
            return -1;
        } else if (pos == 1) {
            head = head.next;
            return pos;
        } else {
            ListNode currentNode;
            ListNode previousNode = head;
            for (int i = 1; i < pos - 1; i++)
                previousNode = previousNode.next;
            currentNode = previousNode.next;
            previousNode.next = currentNode.next;
            return pos;
        }
    }

    public static void main(String[] args) {
//        SinglyLinkedList singlyLinkedList = new SinglyLinkedList ( );
        Scanner scanner = new Scanner ( System.in );
        int length, nodeData, pos;
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
            } else if (choice == 6) {
                System.out.print ( "Enter position: " );
                pos = scanner.nextInt ( );
                if (pos == 0) {
                    System.out.println ( "Pos value must be greater than 0" );
                    System.out.print ( "Enter your choice: " );
                    choice = scanner.nextInt ( );
                }
                System.out.print ( "Enter data to be added at position " + pos + ": " );
                nodeData = scanner.nextInt ( );
                insertNodeAtPosition ( nodeData, pos );
            } else if (choice == 7) {
                System.out.println ( Objects.requireNonNull ( deleteFirstNode ( ) ).data + " deleted" );
            } else if (choice == 8) {
                System.out.println ( deleteLastNode ( ) + " deleted successfully" );
            } else if (choice == 9) {
                System.out.print ( "Enter position: " );
                pos = scanner.nextInt ( );
                if (pos == 0) {
                    System.out.println ( "Pos value must be greater than 0" );
                    System.out.print ( "Enter your choice: " );
                    choice = scanner.nextInt ( );
                }
                System.out.println ( "Data from " + deleteNodeAtPosition ( pos ) + " deleted successfully" );
            }
        } while (choice != 100);
    }
}
