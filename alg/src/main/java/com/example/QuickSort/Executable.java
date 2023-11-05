package com.example.QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Executable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        String arrStr = reader.readLine();
        int[] arr = arrStr.isBlank() ? new int[0] :
                Arrays.stream(arrStr.split(" ")).mapToInt(Integer::parseInt).toArray();
        int number = Integer.parseInt(reader.readLine());

        sort(arr, number, 0, arr.length);
    }

    public static void sort(int[] arr, int numb, int i, int j) {

        if (j == 0) {
            System.out.println("0\n0");
            return;
        }
        int sum = 0;
        while (i < j) {
            while (i < j && arr[i] < numb) {
                i++;
                sum++;
            }

            while (i < j && arr[j-1] > numb) j--;
            if (i < j) {
                swap(arr, i, j-1);
                if (arr[i] < numb || arr[j-1] < numb) sum++;
                i++;
                j--;
            }

        }
        System.out.println(sum);
        System.out.println(arr.length - sum);
    }


    private static void swap(int[] arr, int indexOne, int indexTwo) {
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
}
