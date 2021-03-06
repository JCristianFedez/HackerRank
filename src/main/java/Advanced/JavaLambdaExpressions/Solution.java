package Advanced.JavaLambdaExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
https://www.hackerrank.com/challenges/java-lambda-expressions/problem

INPUT
5
1 4
2 5
3 898
1 3
2 12

OUTPUT
EVEN
PRIME
PALINDROME
ODD
COMPOSITE

 */

interface PerformOperation {

  boolean check(int a);
}

class MyMath {

  public static boolean checker(PerformOperation p, int num) {
    return p.check(num);
  }

  public PerformOperation isOdd() {
    return (int a) -> a % 2 != 0;
  }

  public PerformOperation isPrime() {
    return (int a) -> BigInteger.valueOf(a).isProbablePrime(1);
  }

  public PerformOperation isPalindrome() {
    return (int a) -> Integer.toString(a)
        .equals(new StringBuilder(Integer.toString(a)).reverse().toString());
  }
}

public class Solution {

  public static void main(String[] args) throws IOException {
    MyMath ob = new MyMath();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    PerformOperation op;
    boolean ret = false;
    String ans = null;
    while (T-- > 0) {
      String s = br.readLine().trim();
      StringTokenizer st = new StringTokenizer(s);
      int ch = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      if (ch == 1) {
        op = ob.isOdd();
        ret = MyMath.checker(op, num);
        ans = (ret) ? "ODD" : "EVEN";
      } else if (ch == 2) {
        op = ob.isPrime();
        ret = MyMath.checker(op, num);
        ans = (ret) ? "PRIME" : "COMPOSITE";
      } else if (ch == 3) {
        op = ob.isPalindrome();
        ret = MyMath.checker(op, num);
        ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

      }
      System.out.println(ans);
    }
  }
}

