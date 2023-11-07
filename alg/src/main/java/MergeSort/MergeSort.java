package MergeSort;

import java.io.*;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int a = 7 / 2;
        String s;
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
        int[] arrOne = length == 0 ? new int[0] :
                Arrays.stream(textArr[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder resultString = new StringBuilder();
        int[] resultArr = sort(arrOne);
        for (int i = 0; i < length; i++) {
            resultString.append(resultArr[i]).append(" ");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write(resultString.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static int[] merge(int[] arrOne, int lengthOne, int[] arrTwo, int lengthTwo) {
        int[] result = new int[lengthOne + lengthTwo];
        int indexOne = 0;
        int indexTwo = 0;
        for (int i = 0; i < lengthOne + lengthTwo; i++) {
            if (indexOne == lengthOne) {
                result[i] = arrTwo[indexTwo];
                indexTwo++;
            } else if (indexTwo == lengthTwo) {
                result[i] = arrOne[indexOne];
                indexOne++;
            } else if (arrOne[indexOne] < arrTwo[indexTwo]) {
                result[i] = arrOne[indexOne];
                indexOne++;
            } else if (arrOne[indexOne] > arrTwo[indexTwo]) {
                result[i] = arrTwo[indexTwo];
                indexTwo++;
            } else {
                result[i] = arrOne[indexOne];
                indexOne++;
            }
        }
        return result;
    }

    private static int[] sort(int[] arr) {
        if(arr.length < 2) return arr;
        int[] left = sort(Arrays.copyOfRange(arr, 0, arr.length / 2));
        int[] right = sort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        return merge(left, left.length, right, right.length);
    }
}
