package ru.mirea.task12;

import java.util.Comparator;

public class Sorting {
    // Сортировка Вставками
    public static void insertionSort(Comparable[] list) {
        int i, j;
        Comparable key;

        for (i = 1; i < list.length; i++) {
            // запоминаем значение элемента
            key = list[i];
            // затем перемещаемся по элементам, которые находятся перед выбранным элементом
            j = i - 1;
            while ((j >= 0) && (list[j].compareTo(key) > 0)) {
                // если получен элемент меньший, то передвигаем больший элемент дальше вправо
                // (при этом на его прошлом месте остается его копия - освободившееся место),
                // иначе останавливаемся
                list[j + 1] = list[j];
                j--;
            }
            // в освободившееся место вставляем выбранное значение
            list[j + 1] = key;
        }
    }

    // Сортировка Быстрая
    public static void quickSort(Student[] list, Comparator<Student> comparator) {
        quickSortHelper(list, 0, list.length - 1, comparator);
    }
    public static void quickSortHelper(Student[] array, int low, int high, Comparator<Student> comparator) {
        if (array.length == 0)
            return;

        if (low >= high)
            return; //завершить выполнение, если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        Student base = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(array[i], base) == 1) {
                i++;
            }

            while (comparator.compare(array[j], base) == -1) {
                j--;
            }

            if (i <= j) {
                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSortHelper(array, low, j, comparator);

        if (high > i)
            quickSortHelper(array, i, high, comparator);
    }

    // Сортировка Слиянием
    public static Student[] mergeSort(Student[] array1, Student[] array2, Comparator<Student> comparator) {
        Student[] arr = new Student[array1.length + array2.length];

        System.arraycopy(array1, 0, arr, 0, array1.length);
        System.arraycopy(array2, 0, arr, array1.length, array2.length);

        mergeSortHelper(arr, 0, arr.length - 1, comparator);

        return arr;
    }
    public static void mergeSortHelper(Student arr[], int l, int r, Comparator<Student> comparator)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            mergeSortHelper(arr, l, m, comparator);
            mergeSortHelper(arr, m + 1, r, comparator);

            // Merge the sorted halves
            mergeSortMerge(arr, l, m, r, comparator);
        }
    }
    public static void mergeSortMerge(Student arr[], int l, int m, int r, Comparator<Student> comparator)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        Student L[] = new Student[n1];
        Student R[] = new Student[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (comparator.compare(L[i], R[j]) >= 0) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}