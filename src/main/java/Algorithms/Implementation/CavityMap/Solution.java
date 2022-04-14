package Algorithms.Implementation.CavityMap;

//Sample Input
//
//STDIN   Function
//-----   --------
//4       grid[] size n = 4
//1112    grid = ['1112', '1912', '1892', '1234']
//1912
//1892
//1234
//Sample Output
//
//1112
//1X12
//18X2
//1234

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  private static List<String> result(final List<String> grid) {
    final List<List<String>> gridTransformed = grid.stream()
        .map(s -> s.chars().mapToObj(c -> (char) c).map(String::valueOf).collect(Collectors.toList()))
        .collect(Collectors.toList());
    final List<List<Integer>> gridDesglosed = grid.stream()
        .map(s -> s.chars().mapToObj(c -> (char) c).map(String::valueOf).map(Integer::parseInt).collect(Collectors.toList()))
        .collect(Collectors.toList());

    for (int i = 1; i < gridDesglosed.size() - 1; i++) {
      for (int j = 1; j < gridDesglosed.get(i).size() - 1; j++) {
        final int actualValue = gridDesglosed.get(i).get(j);
        final int topValue = gridDesglosed.get(i - 1).get(j);
        final int bottomValue = gridDesglosed.get(i + 1).get(j);
        final int leftValue = gridDesglosed.get(i).get(j - 1);
        final int rightValue = gridDesglosed.get(i).get(j + 1);

        if (actualValue > topValue && actualValue > bottomValue && actualValue > leftValue && actualValue > rightValue) {
          gridTransformed.get(i).set(j, "X");
        }
      }
    }
    return gridTransformed.stream().map(row -> String.join("", row)).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    try (final Scanner scanner = new Scanner(System.in)) {

      final int gridSize = scanner.nextInt();
      final List<String> grid = new ArrayList<>(gridSize);
      for (int i = 0; i < gridSize; i++) {
        grid.add(scanner.next());
      }
      result(grid).forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
