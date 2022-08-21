import java.util.Scanner;

public class DoublyLinkedList {
    
    public static ListNode head;
    
    public static ListNode last;
    
    public static int length;
    
    public DoublyLinkedList () {
        head = null;
        last = null;
        length = 0;
    }
    
    public static boolean isEmpty () {
        return length == 0;
    }
    
    public static int getLength () {
        return length;
    }
    
    // choice 1
    public static ListNode createDoublyLinkedList (int value) {
        ListNode newnode = new ListNode (value);
        if (head == null) {
            // for first node
            head = last = newnode;
            head.previous = null;
            last.next = null;
        } else {
            // second node onwards
            last.next = newnode;
            newnode.previous = last;
            last = newnode;
            newnode.next = null;
        }
        return head;
    }
    
    // choice 2
    public static void displayDoublyLinkedList () {
        ListNode current = head;
        while (current != null) {
            System.out.print (current.data + " --> ");
            current = current.next;
        }
        System.out.println ("null");
    }
    
    // choice 2
    public static void displayDoublyLinkedListBackward () {
        ListNode current = last;
        while (current != null) {
            System.out.print (current.data + " --> ");
            current = current.previous;
        }
        System.out.println ("null");
    }
    
    // choice 3
    public static void insertNodeAtBeginning (int nodeData) {
        ListNode newnode = new ListNode (nodeData);
        if (isEmpty ()) last = newnode;
        else head.previous = newnode;
        newnode.next = head;
        head = newnode;
        length++;
    }
    
    // choice 4
    public static void insertNodeAtLast (int nodeData) {
        ListNode newnode = new ListNode (nodeData);
        System.out.println ("head: " + head);
        if (head == null) {
            head = last = newnode;
            head.previous = null;
            last.next = null;
        } else {
            last = head;
            while (last.next != null) last = last.next;
            last.next = newnode;
            newnode.previous = last;
            last = newnode;
            last.next = null;
        }
        length++;
    }
    
    // choice 5
    public static void deleteFirstNode () {
        if (head == null) {
            // empty list
            return;
        }
        if (head.next == null) {
            // only one node
            head = null;
            last = null;
            length--;
            return;
        }
        head = head.next;
        head.previous = null;
        length--;
    }
    
    // choice 6
    public static void deleteLastNode () {
        if (head == null) {
            // empty list
            return;
        }
        if (head.next == null) {
            // only one node
            head = null;
            last = null;
            return;
        }
        last.previous.next = null;
        last = last.previous;
        length--;
    }
    
    // choice 7 https://www.sanfoundry.com/c-program-find-largest-element-doubly-linked-list/
    public static int largestElementInList () {
        // TODO
        return - 1;
    }
    
    // choice 8
    
    
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int nodeData, pos, key;
        int choice;
        do {
            System.out.print ("Enter your choice: ");
            choice = scanner.nextInt ();
            if (choice == 1) {
                System.out.print ("Enter no. of nodes: ");
                length = scanner.nextInt ();
                for (int i = 0; i < length; i++) {
                    System.out.print ("Node - " + (i + 1) + ": ");
                    nodeData = scanner.nextInt ();
                    createDoublyLinkedList (nodeData);
                }
            } else if (choice == 2) {
                displayDoublyLinkedList ();
                displayDoublyLinkedListBackward ();
            } else if (choice == 3) {
                System.out.print ("Enter data to be inserted at beginning: ");
                nodeData = scanner.nextInt ();
                insertNodeAtBeginning (nodeData);
            } else if (choice == 4) {
                System.out.print ("Enter data to be inserted at end: ");
                nodeData = scanner.nextInt ();
                insertNodeAtLast (nodeData);
            } else if (choice == 5) {
                deleteFirstNode ();
            } else if (choice == 6) {
                deleteLastNode ();
            } else if (choice == 7) {
                System.out.println ("Largest element in list is: " + largestElementInList ());
            }
        } while (choice != 100);
    }
    
    public static class ListNode {
        private int data;
        
        private ListNode previous;
        
        private ListNode next;
        
        public ListNode () {
        }
        
        public ListNode (int data) {
            this.previous = null;
            this.data = data;
            this.next = null;
        }
    }
}
