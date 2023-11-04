package com.example.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] x = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
        System.out.println("Было");
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        sort(x, low, high);
        System.out.println("Стало");
        System.out.println(Arrays.toString(x));
    }

    public static void sort(int[] arr, int from, int to) {
        if (arr.length == 0) {
            return;
        }
        if (from >= to) {
            return;
        }
        int middle = from + (to - from) / 2;
        int elem = arr[middle];
        int i = from;
        int j = to;
        while (i <= j) {
            while (arr[i] < elem) {
                i++;
            }
            while (arr[j] > elem) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if(from < j){
            sort(arr,from, j);
        }
        if(to > i){
            sort(arr,i, to);
        }
    }

    private static void swap(int[] arr, int indexOne, int indexTwo) {
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
}
