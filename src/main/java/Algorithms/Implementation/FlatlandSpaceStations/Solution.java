package Algorithms.Implementation.FlatlandSpaceStations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Sample Input STDIN   Function -----   -------- 5 2     n = 5, c[] size m = 2 0 4     c = [0, 4]
 * <p>
 * Sample Output 2
 */
public class Solution {

  public static void main(String[] args) {
    try (final Scanner scanner = new Scanner(System.in)) {
      final int numberOfCities = scanner.nextInt();
      scanner.nextLine();
      final List<Integer> citiesWithStations = Arrays.stream(scanner.nextLine().split(" "))
          .map(Integer::parseInt)
          .collect(Collectors.toList());
      System.out.println(result(numberOfCities, citiesWithStations));
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  private static int result(final int numberOfCities, final List<Integer> citiesWithStations) {
    Collections.sort(citiesWithStations);
    int maxDistance = citiesWithStations.get(0);

    for (int i = 1; i < citiesWithStations.size(); i++) {
      final int distance = (citiesWithStations.get(i) - citiesWithStations.get(i - 1)) / 2;
      if (maxDistance < distance) {
        maxDistance = distance;
      }
    }
    final int lastGap = (numberOfCities - 1) - citiesWithStations.get(citiesWithStations.size() - 1);
    return Math.max(lastGap, maxDistance);
  }
}