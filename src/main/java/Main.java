package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        int min = arr[0]; // Предполагаем, что первый элемент минимальный

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i]; // Обновляем минимальное значение
            }
        }

        return min;
    }

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] counter = {0, 0, 0};
        int[] sum = {0, 0, 0};
        int[] fine = {0, 0, 0};
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            list.add(k);
        }

        int i = 0;
        while (i < n) {
            if (sum[2] + list.get(i) <= 300) {
                sum[2] += list.get(i);
                counter[2]++;
                fine[2] +=sum[2];
            }
            i++;
        }

        i = n - 1;
        while (i >= 0) {
            if (sum[1] + list.get(i) <= 300) {
                sum[1] += list.get(i);
                counter[1]++;
                fine[1] += sum[1];
            }
            i--;
        }

        Collections.sort(list);
        i = 0;
        while (i < n) {
            if (sum[0] + list.get(i) <= 300) {
                sum[0] += list.get(i);
                counter[0]++;
                fine[0] +=sum[0];
            }
            i++;
        }


        int winner = -1;
        ArrayList<Integer> winners = new ArrayList<>();
        int maxCount = findMax(counter);
        for (int j = 0; j < 3; j++) {
            if (counter[j] == maxCount) {
                winners.add(j);
            }
        }


        int minFine = findMin(fine);
        System.out.println(Arrays.toString(fine));
        ArrayList<Integer> newWinners = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            if (fine[j] == minFine && winners.contains(j)) {
                newWinners.add(j);
            }
        }


        winner = newWinners.stream().mapToInt(x -> x.intValue()).min().getAsInt();

        switch (winner) {
            case 0:
                System.out.println(1);
                break;
            case 1:
                System.out.println(2);
                break;
            case 2:
                System.out.println(5);
        }


    }
}