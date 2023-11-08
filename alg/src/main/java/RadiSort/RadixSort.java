package RadiSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RadixSort {
    public static void main(String[] args) {
        String s;
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            while ((s = br.readLine()) != null) {
                text.append(s).append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        List<String> textArr = List.of(text.toString().split("\n"));

        int arrLength = Integer.parseInt(textArr.get(0));
        int numberLength = textArr.get(1).length();

        System.out.println("Initial array:");
        StringBuilder textB = new StringBuilder();
        for (int i = 1; i < textArr.size(); i++) {
            textB.append(textArr.get(i));
            if (i < textArr.size() - 1) textB.append(",").append(" ");
        }
        System.out.println(textB);

        List<List<String>> result = sort(textArr, arrLength, List.of(), numberLength, 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                stringBuilder.append(result.get(i).get(j)).append(", ");
            }

        }
        String resultStr = stringBuilder.length() > 2 ?
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).toString() :
                stringBuilder.toString();
        System.out.println("**********");
        System.out.println("Sorted array:");
        System.out.println(resultStr);
    }

    private static List<List<String>> sort(List<String> textArr, int arrLength, List<List<String>> buckets, int i,
                                            int phaseNumber) {
        if (i == 0) return buckets;
        List<List<String>> resultB = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            resultB.add(new ArrayList<>());
        }
        if (buckets.size() == 0) {
            for (int j = 1; j < arrLength + 1; j++) {
                String stringN = textArr.get(j);
                int r = Character.getNumericValue(textArr.get(j).charAt(i - 1));
                resultB.get(r).add(stringN);
            }
        } else {
            for (List<String> b : buckets) {
                for (String n : b) {
                    int r = Character.getNumericValue(String.valueOf(n).charAt(i - 1));
                    resultB.get(r).add(n);
                }
            }
        }
        printPhase(resultB, phaseNumber);
        return sort(textArr, arrLength, resultB, --i, ++phaseNumber);
    }

    private static void printPhase(List<List<String>> resultB, int phaseNumber) {
        System.out.println("**********");
        System.out.println("Phase " + phaseNumber);
        for (int i = 0; i < 10; i++) {
            StringBuilder s = new StringBuilder();
            if (resultB.get(i).size() == 0) s.append("empty");
            else {
                for (int j = 0; j < resultB.get(i).size(); j++) {
                    s.append(resultB.get(i).get(j));
                    if (j < resultB.get(i).size() - 1) s.append(",").append(" ");
                }
            }
            String result = String.format("Bucket %s: %s", i, s);
            System.out.println(result);
        }
    }

}
