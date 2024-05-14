import java.util.*;

public class Main {
    // Публічний статичний метод nth_element знаходить n-те за порядком елемент у вхідному масиві
    public static void nth_element(int[] arr, int first, int last, int n) {
        // Безкінечний цикл для пошуку
        while (true) {
            int k = randomizedPartition(arr, first, last);
            if (n < k) {
                last = k;
            } else if (n > k) {
                first = k + 1;
            } else {
                return;
            }
        }
    }

    // Метод randomizedPartition використовується для випадкового розбиття масиву та повернення індексу роздільника
    static Random rnd = new Random();
    static int randomizedPartition(int[] arr, int first, int last) {
        swap(arr, first + rnd.nextInt(last - first), last - 1);
        int separator = arr[last - 1];
        int i = first - 1;
        for (int j = first; j < last; j++) {
            if (arr[j] <= separator) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, i + 1, last - 1);
        return i + 1;
    }

    // Головний метод програми
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10);
        }
        System.out.println(Arrays.toString(arr));

        int k = rnd.nextInt(10); // Випадкове число k
        nth_element(arr, 0, arr.length, k); // Знаходимо k-те за порядком значення
        System.out.println("Порядкова статистика масиву з індексом " + k + " містить значення: " + arr[k]);
    }

    // Метод swap для обміну двох елементів масиву
    static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
