import java.util.*;

public class Queue {
    
    private static ListNode front;
    private static ListNode rear;
    private static int length;
    
    public Queue () {
        front = null;
        rear = null;
        length = 0;
    }
    
    /// choice 1
    public static void enqueue (int data) {
        ListNode newnode = new ListNode (data);
        if (front == null && rear == null) {
            front = newnode;
        } else {
            rear.next = newnode;
        }
        rear = newnode;
        length++;
    }
    
    /// choice 2
    public static void display () {
        ListNode currentNode = front;
        while (currentNode != null) {
            System.out.print (currentNode.data + " --> ");
            currentNode = currentNode.next;
        }
        System.out.println ("null");
    }
    
    /// choice 3
    public static int dequeue () {
        if (front == null && rear == null) {
            System.out.println ("Queue is already empty");
            throw new NoSuchElementException ();
        }
        int elementToBeDeleted = front.data;
        front = front.next;
        if (front == null) rear = null;
        length--;
        return elementToBeDeleted;
    }
    
    /// choice 4
    public static int firstElement () {
        if (front == null && rear == null) {
            System.out.println ("Queue is empty");
            throw new NoSuchElementException ();
        }
        return front.data;
    }
    
    /// choice 5
    public static int lastElement() {
        if (front == null && rear == null) {
            System.out.println ("Queue is empty");
            throw new NoSuchElementException ();
        }
        return rear.data;
    }
    
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int choice, data;
        do {
            System.out.print ("Enter your choice: ");
            choice = scanner.nextInt ();
            if (choice == 1) {
                System.out.print ("Enter data to be added: ");
                data = scanner.nextInt ();
                enqueue (data);
            } else if (choice == 2) {
                display ();
            } else if (choice == 3) {
                System.out.println ("Dequeued element: " + dequeue ());
            } else if (choice == 4) {
                System.out.println ("First element: " + firstElement ());
            } else if (choice == 5) {
                System.out.println ("Last element: " + lastElement ());
            }
        } while (choice != 100);
    }
    
    
    private static class ListNode {
        int data;
        ListNode next;
        
        public ListNode (int data) {
            this.data = data;
            this.next = null;
        }
        
        public ListNode (int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
