import java.util.Scanner;

public class ArrayUtil {
    
    // choice 1
    public static void addUpdateElement (int[] array, int index, int data) {
        array[ index ] = data;
    }
    
    // choice 2
    public static void printArray (int[] array) {
        System.out.print ("Array elements are: ");
        for (int i = 0; i < array.length; i++) System.out.print (array[ i ] + " ");
        System.out.println ();
    }
    
    // choice 3
    public static int[] removeEvenIntegers (int[] array) {
        int oddCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[ i ] % 2 == 0) oddCount++;
        }
        int[] result = new int[ oddCount ];
        int resultIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[ i ] % 2 != 0) {
                result[ resultIndex ] = array[ i ];
                resultIndex++;
            }
        }
        return result;
    }
    
    // choice 4
    public static void reverseArray (int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int left = array[ i ];
            array[ i ] = array[ array.length - 1 - i ];
            array[ array.length - 1 - i ] = left;
        }
    }
    
    // choice 5
    public static int findMinimumValue (int[] array) {
        int min = array[ 0 ];
        for (int i = 0; i < array.length; i++) {
            if (array[ i ] < min) min = array[ i ];
        }
        return min;
    }
    
    // choice 6
    public static int findSecondMaximumValue (int[] array) {
        int maximum = array[ array.length - 1 ];
        int secondMaximum = array[ array.length - 2 ];
        for (int i = 0; i < array.length; i++) {
            if (array[ i ] > maximum) {
                secondMaximum = maximum;
                maximum = array[ i ];
            } else if (array[ i ] > secondMaximum && array[ i ] != maximum)
                secondMaximum = array[ i ];
        }
        return secondMaximum;
    }
    
    // choice 7
    public static void moveZeroesToEnd (int[] array) {
    
    }
    
    // choice 8
    public static void resizeArray (int[] array) {
    
    }
    
    public static void main (String[] args) {
        int choice, length, data;
        int[] array = new int[ 0 ];
        Scanner scanner = new Scanner (System.in);
        do {
            System.out.print ("Enter your choice: ");
            choice = scanner.nextInt ();
            if (choice == 1) {
                System.out.print ("Enter the length of array: ");
                length = scanner.nextInt ();
                array = new int[ length ];
                for (int index = 0; index < length; index++) {
                    System.out.print ("Enter data to be inserted at index - " + index + ": ");
                    data = scanner.nextInt ();
                    addUpdateElement (array, index, data);
                }
            } else if (choice == 2) {
                printArray (array);
            } else if (choice == 3) {
                int[] resultArray = removeEvenIntegers (array);
                printArray (resultArray);
            } else if (choice == 4) {
                reverseArray (array);
                printArray (array);
            } else if (choice == 5) {
                int minimumValue = findMinimumValue (array);
                System.out.println ("Minimum value of the array: " + minimumValue);
            } else if (choice == 6) {
                int secondMaximumValue = findSecondMaximumValue (array);
                System.out.println ("Second maximum value of the array: " + secondMaximumValue);
            } else if (choice == 7) {
                moveZeroesToEnd (array);
                printArray (array);
            } else if (choice == 8) {
                resizeArray(array);
                printArray (array);
            }
        } while (choice != 100);
    }
}
