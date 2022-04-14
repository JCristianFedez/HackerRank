package Algorithms.Implementation.TaumAndBDay;

/*
https://www.hackerrank.com/challenges/taum-and-bday/problem

Sample Input
5
10 10
1 1 1
5 9
2 3 4
3 6
9 1 1
7 7
4 2 1
3 3
1 9 2

Sample Output
20
37
12
35
12
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

class Result {

  /*
   * Complete the 'taumBday' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER b
   *  2. INTEGER w
   *  3. INTEGER bc
   *  4. INTEGER wc
   *  5. INTEGER z
   */

  public static long taumBday(int b, int w, int bc, int wc, int z) {
    final long black = (long) b * Math.min(bc, wc + z);
    final long white = (long) w * Math.min(wc, bc + z);
    return black + white;
  }

}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int b = Integer.parseInt(firstMultipleInput[0]);

        int w = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int bc = Integer.parseInt(secondMultipleInput[0]);

        int wc = Integer.parseInt(secondMultipleInput[1]);

        int z = Integer.parseInt(secondMultipleInput[2]);

        long result = Result.taumBday(b, w, bc, wc, z);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
