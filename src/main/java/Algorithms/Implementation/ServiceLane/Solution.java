package Algorithms.Implementation.ServiceLane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TODO: Por terminar
//https://www.hackerrank.com/challenges/service-lane/problem
/**
 * Sample Input
 *
 * STDIN               Function
 * -----               --------
 * 8 5                 n = 8, t = 5
 * 2 3 1 2 3 2 3 3     width = [2, 3, 1, 2, 3, 2, 3, 3]
 * 0 3                 cases = [[0, 3], [4, 6], [6, 7], [3, 5], [0, 7]]
 * 4 6
 * 6 7
 * 3 5
 * 0 7
 * Sample Output
 *
 * 1
 * 2
 * 3
 * 2
 * 1
 */
public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        final int cantCases = scanner.nextInt();

        scanner.nextLine();

        final List<Integer> widths = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        final List<List<Integer>> cases = new ArrayList<>();

        for (int i = 0; i < cantCases; i++) {
            final String newLine = scanner.nextLine();
            final List<Integer> newCase = Arrays.stream(newLine.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            cases.add(newCase);
        }
        System.out.println(widths);
        System.out.println(cases);
    }
}
