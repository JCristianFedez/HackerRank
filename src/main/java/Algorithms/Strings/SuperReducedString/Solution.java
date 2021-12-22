package Algorithms.Strings.SuperReducedString;

/*
https://www.hackerrank.com/challenges/reduced-string/problem

Sample Input 0
aaabccddd

Sample Output 0
abd

Explanation 0
Perform the following sequence of operations to get the final string:
aaabccddd → abccddd → abddd → abd


Sample Input 1
aa

Sample Output 1
Empty String

Explanation 1
aa → Empty String


Sample Input 2
baab

Sample Output 2
Empty String

Explanation 2
baab → bb → Empty String
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String superReducedString(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                s = s.substring(0, i - 1) + s.substring(i + 1);
                return superReducedString(s);
            }
        }
        return s.length() == 0 ? "Empty String" : s;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String s = bufferedReader.readLine();
        final String result = Result.superReducedString(s);

        System.out.println(result);

        bufferedReader.close();
    }
}
 