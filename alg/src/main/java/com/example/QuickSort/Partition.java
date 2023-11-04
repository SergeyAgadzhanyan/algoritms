package com.example.QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Partition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int length = Integer.parseInt(reader.readLine());
//        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int number = Integer.parseInt(reader.readLine());
        sort(new int[]{3,1,5,2}, 4);
    }

    public static void sort(int[] arr, int numb) {
        int length = arr.length;
        if (length == 0) {
            System.out.println("0\n0");
            return;
        }
        if (length == 1) {
            System.out.println("0\n1");
            return;
        }
        int sum = 0;
        int i = 0;
        int j = length - 1;
        while (i < j) {
            while (arr[i] < numb && i < j) {
                i++;
                sum++;
            }

            while (arr[j] > numb && i < j) j--;
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
                sum++;
            }

        }
        System.out.println(sum);
        System.out.println(length - sum);
    }

    private static void swap(int[] arr, int indexOne, int indexTwo) {
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
}
