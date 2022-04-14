package Algorithms.Implementation.ACMICPCTeam;

/*
https://www.hackerrank.com/challenges/acm-icpc-team/problem

Sample Input
4 5
10101
11100
11010
00101

Sample Output
5
2

Explanation
Calculating topics known for all permutations of 2 attendees we get:
The 2 teams (1, 3) and (3, 4) know all 5 topics which is maximal.
(1,2) -> 4
(1,3) -> 5
(1,4) -> 3
(2,3) -> 4
(2,4) -> 4
(3,4) -> 5
 */

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Result {

  /*
   * Complete the 'acmTeam' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts STRING_ARRAY topic as parameter.
   */

  static List<Integer> acmTeam(List<String> topic) {
    int top = 0;
    final List<Integer> list = new ArrayList<>();
    for (int i = 0; i < topic.size() - 1; i++) {
      for (int j = i + 1; j < topic.size(); j++) {
        int tmp = 0;
        for (int k = 0; k < topic.get(i).length(); k++) {
          if (topic.get(i).charAt(k) == '1' || topic.get(j).charAt(k) == '1') {
            tmp++;
          }
        }
        list.add(tmp);
        if (tmp > top) {
          top = tmp;
        }
      }
    }
    return Arrays.asList(top, Collections.frequency(list, top));
  }

}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<String> topic = IntStream.range(0, n).mapToObj(i -> {
          try {
            return bufferedReader.readLine();
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .collect(toList());

    Result.acmTeam(topic).forEach(System.out::println);

    bufferedReader.close();
  }
}

