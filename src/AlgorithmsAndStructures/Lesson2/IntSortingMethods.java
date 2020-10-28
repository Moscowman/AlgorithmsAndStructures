package AlgorithmsAndStructures.Lesson2;

import java.util.Arrays;
import java.util.Random;

public class IntSortingMethods {
    public static void main(String[] args) {
        int[] array = new int[100_000];
        Random random = new Random();

        for(int i = 0; i < array.length; ++i) {
            array[i] = random.nextInt();
        }

        int[] array1 = (int[])array.clone();
        int[] array2 = (int[])array.clone();
        int[] array3 = (int[])array.clone();
        long currentTime = System.currentTimeMillis();
        bubbleSort(array1);
        System.out.println("Сортировка пузырьком: " + (System.currentTimeMillis() - currentTime) + " ms");
        currentTime = System.currentTimeMillis();
        selectionSort(array2);
        System.out.println("Сортировка выбором: " + (System.currentTimeMillis() - currentTime) + " ms");
        currentTime = System.currentTimeMillis();
        insertionSort(array3);
        System.out.println("Сортировка вставками: " + (System.currentTimeMillis() - currentTime) + " ms");
        currentTime = System.currentTimeMillis();
        Arrays.sort(array);
        System.out.println("Встроенный метод сортировки: " + (System.currentTimeMillis() - currentTime) + " ms");
    }

    private boolean delete (int[] array, int index) {
        if (index < 0 || index >= array.length) {
            return false;
        }
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array[array.length - 1] = 0;
        return true;
    }

    private boolean insertByIndex (int[] array, int index, int value) {
        if (index < 0 || index >= array.length) {
            return false;
        }
        System.arraycopy(array, index, array, index + 1, array.length - index - 1);
        array[index] = value;
        return true;
    }

    private int find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
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