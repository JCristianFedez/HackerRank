package Algorithms.Implementation.Encryption;

/*
https://www.hackerrank.com/challenges/encryption/problem

Sample Input
haveaniceday

Sample Output 0
hae and via ecy

Sample Input 1
feedthedog

Sample Output 1
fto ehg ee dd
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String sentence) {
        int l = sentence.length();
        int row = (int) Math.floor(Math.sqrt(l));
        int column = (int) Math.ceil(Math.sqrt(l));
        if (row * column < l) {
            row++;
        }
        int counter = 0;
        String encrypted = "";
        for (int i = 0; i < column; i++) {
            counter = 0;
            for (int j = 0; j < row; j++) {
                if (i + counter < sentence.length()) {
                    encrypted = encrypted + sentence.charAt(i + counter);
                    counter += column;
                }
            }
            if (i != column) {
                encrypted = encrypted + " ";
            }
        }
        return encrypted;
    }
}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
