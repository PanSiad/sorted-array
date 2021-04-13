import java.lang.reflect.Array;
import java.util.*;

public class Main {

    private static int maxNumbersInput = 30;
    private static int[] inputArray = new int[maxNumbersInput];
    private static int[] exactInputArray;
    private static int[] sortedArray;
    private static int index = 0;

    public static void main(String[] args) {

        getInput();
        if (index > 0) {
            sort();
            print();
        } else {
            System.out.println("There was no user input!");
        }
    }

    private static void print() {
//        System.out.println(Arrays.toString(inputArray));
        System.out.println("Initial input array: " + Arrays.toString(exactInputArray));
        System.out.println("Sorted input array: " + Arrays.toString(sortedArray));
    }


    private static void getInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number as input for the array or type 'n' to stop:");
        String input = scanner.nextLine();

        while (!input.equals("n") && index < maxNumbersInput) {
            try {
                inputArray[index] = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Following error occured: " + e);
            }
            System.out.println("Enter a number as input for the array or type 'n' to stop:");
            input = scanner.nextLine();
            index++;
        }
    }

    private static void sort() {

        exactInputArray = new int[index];
        sortedArray = new int[index];

        System.arraycopy(inputArray, 0, exactInputArray, 0, index);

        for (int i = 0; i < index; i++) {

            int sortedArrayIndex = 0;

            while (exactInputArray[i] < sortedArray[sortedArrayIndex]) {
                sortedArrayIndex++;
            }

            for (int y = i; y > sortedArrayIndex; y--) {
                sortedArray[y] = sortedArray[y-1];
            }
            sortedArray[sortedArrayIndex] = exactInputArray[i];

        }
    }
}