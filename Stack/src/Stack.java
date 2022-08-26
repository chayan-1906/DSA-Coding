public class Stack {
    
    private static ListNode top;
    private static int length;
    
    public Stack () {
        top = null;
        length = 0;
    }
    
    /// choice 1
    private static void push (int data) {
        ListNode newNode = new Stack.ListNode (data);
        newNode.next = top;
        top = newNode;
        length++;
    }
    
    /// choice 2
    private static void display () {
        ListNode currentNode = top;
        while (currentNode != null) {
            System.out.print (currentNode.data + " --> ");
            currentNode = currentNode.next;
        }
        System.out.println ("null");
    }
    
    /// choice 3
    private static int pop () {
        if (top == null) throw new java.util.EmptyStackException ();
        int dataToBeDeleted = top.data;
        top = top.next;
        length--;
        return dataToBeDeleted;
    }
    
    /// choice 4
    private static int peek () {
        if (top == null) throw new java.util.EmptyStackException ();
        return top.data;
    }
    
    public static void main (String[] args) {
        java.util.Scanner scanner = new java.util.Scanner (System.in);
        int choice, data;
        do {
            System.out.print ("Enter your choice: ");
            choice = scanner.nextInt ();
            if (choice == 1) {
                System.out.print ("Enter data to be added: ");
                data = scanner.nextInt ();
                push (data);
            } else if (choice == 2) {
                display ();
            } else if (choice == 3) {
                System.out.println ("Deleted element: " + pop ());
            } else if (choice == 4) {
                System.out.println ("Topmost element: " + peek ());
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
        
        public ListNode (int data, Stack.ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
