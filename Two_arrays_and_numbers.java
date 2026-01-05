// 241RDB316 Vladislav Ebert

import java.util.InputMismatchException;
import java.util.Scanner;

public class Two_arrays_and_numbers_thg_12_10_2024 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // a
            System.out.println("Ievadiet massiva A elementu skaitu: ");
            int k = sc.nextInt();
            int[] a = new int[k];
            //VVOD
            System.out.println("input items:");
            for (int i = 0; i < k; i++) {
                System.out.print("Ievadiet " + (i + 1) + " elementu: ");
                a[i] = sc.nextInt();
            }
            //isSorded?
            if (isSorted(a)) {
                System.out.println("Masivs A ir sakartots augosa seciba.");
            } else {
                System.out.println("invalid input data");
                System.exit(0);
            }
            //outPrint
            System.out.println("\narray a:");
            for (int i = 0; i < k; i++) {
                System.out.print(a[i] + " ");
            }

            // B
            System.out.println("\n\nIevadiet massiva B elementu skaitu: ");
            int j = sc.nextInt();
            int[] b = new int[j];

            // Input
            System.out.println("input items:");
            for (int i = 0; i < j; i++) {
                System.out.print("Ievadiet " + (i + 1) + " elementu: ");
                b[i] = sc.nextInt();
            }

            // isSorted?
            if (isSorted(b)) {
                System.out.println("Masivs B ir sakartots augosa seciba.");
            } else {
                System.out.println("invalid input data");
                System.exit(0);
            }

            // Print
            System.out.println("\narray b:");
            for (int i = 0; i < j; i++) {
                System.out.print(b[i] + " ");
            }

            // A and B to the C
            int[] c = MergeArrays(a, b);

            // Print C
            System.out.println("\n\nresult:");
            for (int i = 0; i < c.length; i++) {
                System.out.print(c[i] + " ");
            }
        } catch (InputMismatchException e) {
            System.out.println("Nav reāli skaitli");
        }
    }

    // A and B to the C
    public static int[] MergeArrays(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        // If one have element write "Tuksas " vietas
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < a.length) {
            c[k++] = a[i++];
        }

        while (j < b.length) {
            c[k++] = b[j++];
        }

        return c;
    }

    // Check if an array is sorted in ascending order
    public static boolean isSorted(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return true;
        }

        // Check if each element is less than or equal to the next
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
