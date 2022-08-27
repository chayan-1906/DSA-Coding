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
    
    /// choice 5
    private static String reverseString (String string) {
        java.util.Stack<Character> characterStack = new java.util.Stack<Character> ();
        char[] chars = string.toCharArray ();
        for (char character : chars) characterStack.push (character);
        for (int i = 0; i < string.length (); i++) chars[ i ] = characterStack.pop ();
        return new String (chars);
    }
    
    /// choice 6
    private static int nextGreaterElement (int[] array, int keyIndex) {
        int result = - 1;
        for (int i = keyIndex; i < array.length; i++) {
            if (array[ i ] > array[ keyIndex ]) {
                result = array[ i ];
                break;
            }
        }
        return result;
    }
    
    /// choice 7
    private static int[] nextGreaterElements (int[] array) {
        int[] result = new int[ array.length ];
        java.util.Arrays.fill (result, - 1);
        for (int i = 0; i < array.length; i++) {
            result[ i ] = nextGreaterElement (array, i);
        }
        return result;
    }
    
    /// choice 8
    private static boolean checkValidParenthesis () {
        return false;
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
            } else if (choice == 5) {
                System.out.print ("Enter string to be reversed: ");
                String string = scanner.next ();
                System.out.println ("Reversed string: " + reverseString (string));
            } else if (choice == 6) {
                int arrayLength;
                System.out.print ("Enter no of elements: ");
                arrayLength = scanner.nextInt ();
                int[] array = new int[ arrayLength ];
                for (int i = 0; i < arrayLength; i++) {
                    System.out.print ("Enter data to be added: ");
                    array[ i ] = scanner.nextInt ();
                }
                System.out.print ("Enter index of key value: ");
                int keyIndex = scanner.nextInt ();
                System.out.println ("Next greater element to " + array[ keyIndex ] + " is: " + nextGreaterElement (array, keyIndex));
            } else if (choice == 7) {
                int arrayLength;
                System.out.print ("Enter no of elements: ");
                arrayLength = scanner.nextInt ();
                int[] array = new int[ arrayLength ];
                for (int i = 0; i < arrayLength; i++) {
                    System.out.print ("Enter data to be added: ");
                    array[ i ] = scanner.nextInt ();
                }
                for (int i = 0; i < arrayLength; i++)
                    System.out.print (nextGreaterElements (array)[ i ] + " ");
                System.out.println ();
            } else if (choice == 8) {
                System.out.println(checkValidParenthesis ());
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
