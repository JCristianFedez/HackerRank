package Algorithms.Implementation.ChocolateFeast;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sample Input
 * <p>
 * STDIN   Function -----   -------- 3       t = 3 (test cases) 10 2 5  n = 10, c = 2, m = 5 (first test case) 12 4 4  n = 12, c = 4, m = 4
 * (second test case) 6 2 2   n = 6,  c = 2, m = 2 (third test case) Sample Output
 * <p>
 * 6 3 5
 */
public class Solution {

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);

    final int testCases = scanner.nextInt();
    final List<Integer> results = new ArrayList<>();

    for (int i = 0; i < testCases; i++) {
      final int money = scanner.nextInt();
      final int cost = scanner.nextInt();
      final int numOfWrappersToReturnFree = scanner.nextInt();
      results.add(result(money, cost, numOfWrappersToReturnFree));
    }
    results.forEach(System.out::println);
  }

  /**
   * @param n Bobby's initial amount of money
   * @param c the cost of a chocolate bar
   * @param m the number of wrappers he can turn in for a free bar
   */
  private static int result(final int n, final int c, final int m) {
    int total = Math.floorDiv(n, c);
    int wrappers = total;
    while (wrappers >= m) {
      wrappers -= m;
      total++;
      wrappers++;
    }
    return total;
  }
}
