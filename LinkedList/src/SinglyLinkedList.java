import java.util.Objects;
import java.util.Scanner;

public class SinglyLinkedList {
    
    private static ListNode head;
    private static ListNode tail;
    
    // choice 1
    public static ListNode createSinglyLinkedList (int value) {
        ListNode newnode = new ListNode (value);
        if (head == null) {
            // for first node
            head = newnode;
        } else {
            // second node onwards
            tail.next = newnode;
        }
        tail = newnode;
        return head;
    }
    
    // choice 2
    public static void displaySinglyLinkedList (ListNode currentNode) {
        while (currentNode != null) {
            System.out.print (currentNode.data + " --> ");
            currentNode = currentNode.next;
        }
        System.out.print ("null\n");
    }
    
    // choice 3
    public static int length () {
        int noOfNodes = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            noOfNodes++;
            currentNode = currentNode.next;
        }
        return noOfNodes;
    }
    
    // choice 4
    public static void insertNodeAtBeginning (int value) {
        ListNode newnode = new ListNode (value);
        if (head != null) {
            newnode.next = head;
        }
        head = newnode;
    }
    
    // choice 5
    public static void insertNodeAtEnd (int value) {
        ListNode newnode = new ListNode (value);
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
    public static void insertNodeAtPosition (int value, int pos) {
        ListNode newnode = new ListNode (value);
        if (pos > length () + 1) {
            System.out.println ("Length must be greater than " + pos);
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
    public static ListNode deleteFirstNode () {
        if (head == null) {
            System.out.println ("Linked List is already empty");
            return null;
        }
        ListNode firstNode = head;
        head = head.next;
        firstNode.next = null;
        return firstNode;
    }
    
    // choice 8
    public static int deleteLastNode () {
        if (head == null) {
            System.out.println ("Linked List already empty");
            return - 1;
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
    public static int deleteNodeAtPosition (int pos) {
        if (pos >= length () + 1) {
            System.out.println ("Length must be greater than " + pos);
            return 0;
        }
        if (head == null) {
            System.out.println ("Linked List already empty");
            return - 1;
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
    
    // choice 10
    public static int searchNode (int value) {
        ListNode current = head;
        int keyPos = 1;
        while (current != null) {
            if (current.data == value) return keyPos;
            current = current.next;
            keyPos++;
        }
        return - 1;
    }
    
    // choice 11
    public static ListNode reverseList (ListNode head) {
        if (head == null) return head;
        ListNode current = head;
        ListNode previous = null;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    
    // choice 12
    public static ListNode middleNode () {
        // Using length() function
        if (head == null) return head;
        /*ListNode current = head;
        for (int i = 0; i < length ( ) / 2; i++)
            current = current.next;
        return current;*/
        // Using slow & fast pointer
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
    
    // choice 13
    public static int nthNodeFromLast (int n) {
        if (head == null || n > length () || n <= 0) return - 1;
        ListNode current = head;
        for (int i = 0; i < length () - n; i++)
            current = current.next;
        return current.data;
    }
    
    // choice 14  83. https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public static void removeDuplicateFromSortedLinkedList () {
        if (head == null) return;
        ListNode current = head;
        while (current.next != null) {
            if (current.data == current.next.data) current.next = current.next.next;
            else current = current.next;
        }
    }
    
    // choice 15
    public static void insertNodeSortedLinkedList (int value) {
        ListNode currentNode = head;
        ListNode newnode = new ListNode (value);
        if (head == null || head.data >= newnode.data) {
            // insert beginning
            newnode.next = head;
            head = newnode;
        } else {
            // locate node before point of insertion i.e. once when newnode is going to be larger than current node.next node
            while (currentNode.next != null && currentNode.next.data < newnode.data) currentNode = currentNode.next;
            newnode.next = currentNode.next;
            currentNode.next = newnode;
        }
    }
    
    // choice 16
    public static void deleteGivenKey (int key) {
        if (head == null) return;
        ListNode currentNodeToBeDeleted = head;
        ListNode previousNode = head;
        if (head.data == key) {
            // if key is the first node
            head = head.next;
            return;
        }
        while (currentNodeToBeDeleted.data != key && currentNodeToBeDeleted.next != null) {
            previousNode = currentNodeToBeDeleted;
            currentNodeToBeDeleted = currentNodeToBeDeleted.next;
        }
        previousNode.next = currentNodeToBeDeleted.next;
        
    }
    
    // choice 17
    public static Integer detectLoop (int choice) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                if (choice == 19) {
                    Integer loopStartingValue = getStartingOfLoop (slowPtr);
                    System.out.println ("Loop starts at " + loopStartingValue);
                    return loopStartingValue;
                } else if (choice == 20) {
                    removeLoop (slowPtr);
                }
                return slowPtr.data;
            }
        }
        return - 1;
    }
    
    public static void createLoopLinkedList () {
        ListNode firstNode = new ListNode (1);
        ListNode secondNode = new ListNode (2);
        ListNode thirdNode = new ListNode (3);
        ListNode fourthNode = new ListNode (4);
        ListNode fifthNode = new ListNode (5);
        ListNode sixthNode = new ListNode (6);
        
        head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;
        sixthNode.next = thirdNode;
//        sixthNode.next = null;
    }
    
    // choice 18  2095. https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
    public static void deleteMiddleNode () {
        if (head == null) return;
        ListNode currentNode = head;
        ListNode previousNode = head;
        if (head.next == null) {
            head = null;
            return;
        }
        for (int i = 0; i < length () / 2; i++) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        previousNode.next = currentNode.next;
    }
    
    // 82. https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
    public static void removeDuplicateNodesFromSortedLinkedList () {
        // solved in leetcode editor, couldn't understand
    }
    
    // choice 19
    public static Integer getStartingOfLoop (ListNode slowPtr) {
        ListNode temp = head;
        while (slowPtr != temp) {
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        return temp.data;
    }
    
    // choice 20
    public static void removeLoop (ListNode slowPtr) {
        ListNode temp = head;
        if (slowPtr != temp) {
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        slowPtr.next = null;
        System.out.println ("Loop removed");
    }
    
    // choice 21  21. https://leetcode.com/problems/merge-two-sorted-lists/
    public static ListNode mergeTwoSortedList (ListNode p, ListNode q) {
        /*if (p == null) {
            return q;
        } else if (q == null) {
            return p;
        }
        if (p.data < q.data) {
            p.next = mergeTwoSortedList ( p.next, q );
            return p;
        } else {
            q.next = mergeTwoSortedList ( p, q.next );
            return q;
        }*/
        if (p == null) return q;
        else if (q == null) return p;
        if (p.data < q.data) {
            p.next = mergeTwoSortedList (p.next, q);
            return p;
        } else {
            q.next = mergeTwoSortedList (p, q.next);
            return q;
        }
    }
    
    // choice 22  2. https://leetcode.com/problems/add-two-numbers/
    public static ListNode addTwoLists (ListNode list1, ListNode list2) {
        ListNode head = new ListNode (0);
        ListNode currentNode = head;
        int carry = 0;
        while (list1 != null || list2 != null) {
            int x = list1 != null ? list1.data : 0;
            int y = list2 != null ? list2.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            currentNode.next = new ListNode (sum % 10);
            currentNode = currentNode.next;
            if (list1 != null) list1 = list1.next;
            if (list2 != null) list2 = list2.next;
        }
        if (carry > 0) currentNode.next = new ListNode (carry);
        return head.next;
    }
    
    // choice 23. https://www.sanfoundry.com/c-program-find-first-common-element-linked-lists/
    public static int firstCommonElementsInTwoLists () {
        // TODO
        return - 1;
    }
    
    // choice 24. https://www.sanfoundry.com/c-program-find-occurrences-all-elements-linked-list/
    public static int countOccurrencesOfElement () {
        // TODO
        return - 1;
    }

    // choice 25. https://www.sanfoundry.com/c-program-check-2-lists-same/
    public static boolean isTwoListSame () {
        // TODO
        return false;
    }

    // choice 26. https://www.sanfoundry.com/c-program-linked-list-reverse-using-recursion/
    public static void reverseWithRecursion () {
        // TODO
    }

    // choice 27. https://www.sanfoundry.com/c-program-alternate-nodes-without-recursion/
    public static void displayAlternateNode () {
        // TODO
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int length, nodeData, pos, key, choice;
        do {
            System.out.print ("Enter your choice: ");
            choice = scanner.nextInt ();
            if (choice == 1) {
                System.out.print ("Enter no. of nodes: ");
                length = scanner.nextInt ();
                for (int i = 0; i < length; i++) {
                    System.out.print ("Node - " + (i + 1) + ": ");
                    nodeData = scanner.nextInt ();
                    createSinglyLinkedList (nodeData);
                }
            } else if (choice == 2) {
                displaySinglyLinkedList (head);
            } else if (choice == 3) {
                System.out.println ("Length: " + length ());
            } else if (choice == 4) {
                System.out.print ("Enter data to be added at beginning: ");
                nodeData = scanner.nextInt ();
                insertNodeAtBeginning (nodeData);
            } else if (choice == 5) {
                System.out.print ("Enter data to be added at end: ");
                nodeData = scanner.nextInt ();
                insertNodeAtEnd (nodeData);
            } else if (choice == 6) {
                System.out.print ("Enter position: ");
                pos = scanner.nextInt ();
                if (pos == 0) {
                    System.out.println ("Pos value must be greater than 0");
                    System.out.print ("Enter your choice: ");
                    choice = scanner.nextInt ();
                }
                System.out.print ("Enter data to be added at position " + pos + ": ");
                nodeData = scanner.nextInt ();
                insertNodeAtPosition (nodeData, pos);
            } else if (choice == 7) {
                System.out.println (Objects.requireNonNull (deleteFirstNode ()).data + " deleted");
            } else if (choice == 8) {
                System.out.println (deleteLastNode () + " deleted successfully");
            } else if (choice == 9) {
                System.out.print ("Enter position: ");
                pos = scanner.nextInt ();
                if (pos == 0) {
                    System.out.println ("Pos value must be greater than 0");
                    System.out.print ("Enter your choice: ");
                    choice = scanner.nextInt ();
                }
                System.out.println ("Data from " + deleteNodeAtPosition (pos) + " deleted successfully");
            } else if (choice == 10) {
                System.out.print ("Enter data to be searched: ");
                key = scanner.nextInt ();
                int keyPos = searchNode (key);
                if (keyPos == - 1) {
                    System.out.println (key + " not available in linked list");
                } else {
                    System.out.println (key + " found at " + keyPos);
                }
            } else if (choice == 11) {
                ListNode reversedList = reverseList (head);
                displaySinglyLinkedList (reversedList);
            } else if (choice == 12) {
                System.out.println ("Middle node of list: " + middleNode ().data);
            } else if (choice == 13) {
                System.out.print ("Enter value of n from last: ");
                int n = scanner.nextInt ();
                System.out.println ("nth node from last: " + nthNodeFromLast (n));
            } else if (choice == 14) {
                removeDuplicateFromSortedLinkedList ();
            } else if (choice == 15) {
                System.out.print ("Enter data to be added in sorted linked list: ");
                nodeData = scanner.nextInt ();
                insertNodeSortedLinkedList (nodeData);
            } else if (choice == 16) {
                System.out.print ("Enter key to be deleted: ");
                key = scanner.nextInt ();
                deleteGivenKey (key);
            } else if (choice == 17) {
                createLoopLinkedList ();
                System.out.println ((detectLoop (choice)));
            } else if (choice == 18) {
                deleteMiddleNode ();
            } else if (choice == 19) {
                // get starting of loop
                createLoopLinkedList ();
                detectLoop (choice);
            } else if (choice == 20) {
                // remove loop
                createLoopLinkedList ();
                detectLoop (choice);
            } else if (choice == 21) {
                // mergeTwoSortedList code should work fine, LeetCode #21, not able to run in IntelliJ
            } else if (choice == 22) {
                // addTwoLists code should work fine, LeetCode #2, not able to run in IntelliJ
            } else if (choice == 23) {
                System.out.println ("First common element is " + firstCommonElementsInTwoLists ());
            } else if (choice == 24) {
                System.out.print ("Enter data to be count: ");
                key = scanner.nextInt ();
                System.out.println (key + " found " + countOccurrencesOfElement () + " times");
            } else if (choice == 25) {
                System.out.println ("Two list are same: " + isTwoListSame ());
            } else if (choice == 26) {
                reverseWithRecursion ();
                displaySinglyLinkedList (head);
            } else if (choice == 27) {
                displayAlternateNode ();
            }
        } while (choice != 100);
    }
    
    private static class ListNode {
        private int data;
        private ListNode next;
        
        public ListNode () {
        }
        
        public ListNode (int data) {
            this.data = data;
            this.next = null;
        }
    }
}
