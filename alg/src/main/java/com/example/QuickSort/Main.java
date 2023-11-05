package com.example.QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        String arrStr = reader.readLine();
        int[] arr = arrStr.isBlank() ? new int[0] :
                Arrays.stream(arrStr.split(" ")).mapToInt(Integer::parseInt).toArray();
        int number = Integer.parseInt(reader.readLine());

        sort(arr, number, 0, arr.length -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < number) sum++;
        }
        int sum2 = arr.length - sum;
        System.out.print(sum + "\n" + sum2);

    }

    public static void sort(int[] arr, int number, int from, int to) {
        if (arr.length == 0) {
            return;
        }
        if (from >= to) {
            return;
        }

        int i = from;
        int j = to;
        while (i <= j) {
            while (arr[i] < number) {
                i++;
            }
            while (arr[j] > number) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (from < j) {
            sort(arr, getElem(arr, from, j), from, j);
        }
        if (to > i) {
            sort(arr, getElem(arr, i, to), i, to);
        }
    }
    private static int getElem(int[] arr, int from, int to){
        int middle = from + (to - from) / 2;
        return arr[middle];
    }

    private static void swap(int[] arr, int indexOne, int indexTwo) {
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
}
