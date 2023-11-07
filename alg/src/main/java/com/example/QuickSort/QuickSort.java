package com.example.QuickSort;

import java.io.*;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        String s;
        StringBuilder result = new StringBuilder();
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            while ((s = br.readLine()) != null) {
                text.append(s).append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String[] textArr = text.toString().split("\n");

        int length = Integer.parseInt(textArr[0]);
        if (length == 0) return;
        int[] arr = Arrays.stream(textArr[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        sort(arr, arr[getRandomNumber(0,length-1)], 0, length - 1);
        for (int j : arr) {
            result.append(j).append(" ");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write(result.toString());
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


    public static void sort(int[] arr, int number, int from, int to) {

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
            sort(arr, arr[getRandomNumber(from,j)], from, j);
        }
        if (to > i) {
            sort(arr, arr[getRandomNumber(i,to)], i, to);
        }
    }

    private static int getMiddle(int[] arr, int from, int to) {
        if (arr.length == 0) return 0;
        int middle = from + (to - from) / 2;
        return arr[middle];
    }

    private static void swap(int[] arr, int indexOne, int indexTwo) {
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
