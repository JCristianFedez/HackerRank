package dataStructures.arrays.arraysDs;

// Input
//4
//1 4 3 2

// Outoyt
// 2 3 4 1

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    final Scanner scannr = new Scanner(System.in);

    scannr.nextLine();

    final List<String> arr = Arrays.stream(scannr.nextLine().split(" "))
        .collect(Collectors.toList());
    Collections.reverse(arr);
    System.out.println(String.join(" ", arr));
    scannr.close();
  }
}
