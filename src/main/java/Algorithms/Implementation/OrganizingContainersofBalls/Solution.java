package Algorithms.Implementation.OrganizingContainersofBalls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Sample Input 0
 * <p>
 * 2 2 1 1 1 1 2 0 2 1 1 Sample Output 0
 * <p>
 * Possible Impossible
 */

/**
 * Sample Input 1
 * <p>
 * 2
 * 3
 * 1 3 1
 * 2 1 2
 * 3 3 3
 * 3
 * 0 2 1
 * 1 1 1
 * 2 0 0
 * Sample Output 1
 * <p>
 * Impossible
 * Possible
 */
class Result {

  /*
   * Complete the 'organizingContainers' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts 2D_INTEGER_ARRAY container as parameter.
   */

  public static String organizingContainers(List<List<Integer>> container) {
    final Map<Integer, Integer> ballsInContainerMap = new HashMap<>();
    final Map<Integer, Integer> typeBallsMap = new HashMap<>();

    for (int row = 0; row < container.size(); row++) {
      for (int col = 0; col < container.get(row).size(); col++) {
        final int val = container.get(row).get(col);
        ballsInContainerMap.put(col, (val + ballsInContainerMap.getOrDefault(col, 0)));
        typeBallsMap.put(row, (val + typeBallsMap.getOrDefault(row, 0)));
      }
    }

    final List<Integer> ballsInContainerList = ballsInContainerMap.values().stream().sorted().collect(Collectors.toList());
    final List<Integer> typeBallsList = typeBallsMap.values().stream().sorted().collect(Collectors.toList());

    return ballsInContainerList.equals(typeBallsList) ? "Possible" : "Impossible";
  }

}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> container = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
          try {
            container.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList()));
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });

        String result = Result.organizingContainers(container);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
