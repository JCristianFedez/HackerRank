package Algorithms.Implementation.LisaWorkbook;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Sample Input
 *
 * STDIN       Function -----       -------- 5 3         n = 5, k = 3 4 2 6 1 10  arr = [4, 2, 6, 1, 10] Sample Output
 *
 * 4
 */
public class Solution {

  public static void main(String[] args) {
    try (final Scanner scanner = new Scanner(System.in)) {
      scanner.nextInt();
      final int maxNumOfProblemsPerChapter = scanner.nextInt();
      scanner.nextLine();
      final List<Integer> problemsPerChapter = Arrays.stream(scanner.nextLine().split(" "))
          .map(Integer::parseInt)
          .collect(Collectors.toList());
      System.out.println(result(maxNumOfProblemsPerChapter, problemsPerChapter));
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  private static int result(final int maxNumOfProblemsPerChapter, final List<Integer> problemsPerChapter) {
    int specialProblem = 0;
    int page = 1;

    for (Integer problems : problemsPerChapter) {
      for (int i = 1; i <= problems; i++) {
        if (i == page) {
          specialProblem++;
        }
        if (i % maxNumOfProblemsPerChapter == 0 && i != problems) {
          page++;
        }
      }
      page++;
    }

    return specialProblem;
  }
}
