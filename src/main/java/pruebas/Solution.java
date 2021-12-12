package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        final int min = Collections.min(arr);
        final int max = Collections.max(arr);
        boolean dontSumNumberMax = true;
        boolean dontSumNumberMin = true;
        int sumMax = 0;
        int sumMin = 0;

        for (int n : arr) {
            if (n == min && dontSumNumberMin) {
                dontSumNumberMin = false;
            } else {
                sumMin += n;
            }

            if (n == max && dontSumNumberMax) {
                dontSumNumberMax = false;
            } else {
                sumMax += n;
            }
        }

        final StringBuilder sb = new StringBuilder();
        sb.append(sumMin).append(" ").append(sumMax);
        System.out.println(sb);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
