package Algorithms.Implementation.TheTimeInWords;

/*
https://www.hackerrank.com/challenges/the-time-in-words/problem

Sample Input 0
5
47

Sample Output 0
thirteen minutes to six

Sample Input 1
3
00

Sample Output 1
three o' clock

Sample Input 2
7
15

Sample Output 2
quarter past seven
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        List<String> dictionary = Arrays.asList(
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
                "twenty six", "twenty seven", "twenty eight", "twenty nine");

        final StringBuilder time = new StringBuilder();

        if (m <= 30) {
            if (m == 0) {
                time.append(dictionary.get(h)).append(" o' clock");
            } else if (m == 15) {
                time.append("quarter past ").append(dictionary.get(h));
            } else if (m == 30) {
                time.append("half past ").append(dictionary.get(h));
            } else if (m == 1) {
                time.append(dictionary.get(m)).append(" minute past ").append(dictionary.get(h));
            } else {
                time.append(dictionary.get(m)).append(" minutes past ").append(dictionary.get(h));
            }
        } else {
            if (m == 45) {
                time.append("quarter to ").append(dictionary.get(h + 1));
            } else if (m == 59) {
                time.append(dictionary.get(60 - m)).append(" minute to ").append(dictionary.get(h + 1));
            } else {
                time.append(dictionary.get(60 - m)).append(" minutes to ").append(dictionary.get(h + 1));
            }
        }
        return time.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

