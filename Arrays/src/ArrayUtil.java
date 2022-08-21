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
            } else if (array[ i ] > secondMaximum && array[ i ] != maximum) secondMaximum = array[ i ];
        }
        return secondMaximum;
    }
    
    // choice 7
    public static void moveZeroesToEnd (int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[ i ] != 0 && array[ j ] == 0) {
                int temp = array[ i ];
                array[ i ] = array[ j ];
                array[ j ] = temp;
            }
            if (array[ j ] != 0) j++;
        }
    }
    
    public static int findMaximumValue (int[] array) {
        int max = array[ 0 ];
        for (int i = 0; i < array.length; i++) {
            if (array[ i ] > max) max = array[ i ];
        }
        return max;
    }
    
    // choice 8
    public static int[] resizeArray (int[] array, int capacity) {
        int[] newArray = new int[ capacity ];
        for (int i = 0; i < array.length; i++)
            newArray[ i ] = array[ i ];
        array = newArray;
        return array;
    }
    
    // choice 9
    public static double findMissingNumber (int[] array) {
        int min = findMinimumValue (array);
        int max = findMaximumValue (array);
        System.out.println ("min number: " + min);
        double totalSum = (double) (array.length + 1) / 2 * (min + max);    // AP formula: sum = min or first term + (length - 1) * common difference
        System.out.println ("Sum is: " + totalSum);
        int presentSum = 0;
        for (int i = 0; i < array.length; i++) presentSum += array[ i ];
        return totalSum - presentSum;
    }
    
    // choice 10
    public static boolean checkPalindromeString (String string) {
        return false;
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
                System.out.print ("Enter capacity of new array: ");
                int capacity = scanner.nextInt ();
                int[] resizedArray = resizeArray (array, capacity);
                printArray (array);
                printArray (resizedArray);
            } else if (choice == 9) {
                double missingNumber = findMissingNumber (array);
                System.out.println ("Missing number is: " + missingNumber);
            } else if (choice == 10) {
                System.out.print ("Enter a string to check palindrome string: ");
                String string = scanner.next ();
                System.out.println ("String is palindrome " + checkPalindromeString (string));
            }
        } while (choice != 100);
    }
}
