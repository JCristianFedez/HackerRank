package tutorials.thirtyDaysOfCode.daytwentyFiveRunningTimeAndComplexity;

/*
https://www.hackerrank.com/challenges/30-running-time-and-complexity/problem

Sample Input
3
12
5
7

Sample Output
Not prime
Prime
Prime

 */

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        while (--n >= 0) {
            int num = scanner.nextInt();
            if (isPrime(num)) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }

    private static boolean isPrime(int num) {
        if(num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
