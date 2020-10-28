package AlgorithmsAndStructures.Lesson2;

import java.util.Arrays;
import java.util.Random;

public class IntSortingMethods {
    public static void main(String[] args) {
        int[] array = new int[100000000];
        Random random = new Random();

        for(int i = 0; i < array.length; ++i) {
            array[i] = random.nextInt();
        }

        int[] array1 = (int[])array.clone();
        int[] array2 = (int[])array.clone();
        int[] array3 = (int[])array.clone();
        long currentTime = System.currentTimeMillis();
        System.out.println("Сортировка пузырьком: " + (System.currentTimeMillis() - currentTime) + " ms");
        currentTime = System.currentTimeMillis();
        System.out.println("Сортировка выбором: " + (System.currentTimeMillis() - currentTime) + " ms");
        currentTime = System.currentTimeMillis();
        System.out.println("Сортировка вставками: " + (System.currentTimeMillis() - currentTime) + " ms");
        currentTime = System.currentTimeMillis();
        Arrays.sort(array);
        System.out.println("Встроенный метод сортировки: " + (System.currentTimeMillis() - currentTime) + " ms");
    }

    private static void bubbleSort(int[] array) {
        for(int i = 0; i < array.length; ++i) {
            for(int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }

    private static void selectionSort(int[] array) {
        for(int i = 0; i < array.length; ++i) {
            int min = array[i];
            int index = i;

            for(int j = i + 1; j < array.length; ++j) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }

            array[index] = array[i];
            array[i] = min;
        }

    }

    private static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; ++i) {
            int temp = array[i];

            int index;
            for(index = i; index > 0 && array[index - 1] >= temp; --index) {
                array[index] = array[index - 1];
            }

            array[index] = temp;
        }

    }
}