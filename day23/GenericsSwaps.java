package day23;
import java.util.Arrays;

public class GenericsSwaps {

    public static <T> void swap(T[] array, int index1, int index2) {
        if (index1 >= 0 && index1 < array.length && index2 >= 0 && index2 < array.length) {
            T temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public static void main(String[] args) {
        // Integer array example
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Original Integer Array: " + Arrays.toString(intArray));
        swap(intArray, 1, 3);
        System.out.println("Swapped Integer Array: " + Arrays.toString(intArray));

        // String array example
        String[] strArray = {"one", "two", "three", "four", "five"};
        System.out.println("Original String Array: " + Arrays.toString(strArray));
        swap(strArray, 0, 4);
        System.out.println("Swapped String Array: " + Arrays.toString(strArray));

        // Double array example
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        System.out.println("Original Double Array: " + Arrays.toString(doubleArray));
        swap(doubleArray, 2, 4);
        System.out.println("Swapped Double Array: " + Arrays.toString(doubleArray));
    }
}