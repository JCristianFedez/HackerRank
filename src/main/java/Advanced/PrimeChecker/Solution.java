package Advanced.PrimeChecker;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/*
https://www.hackerrank.com/challenges/prime-checker/problem

Input
2
1
3
4
5

Output
2
2
2 3
2 3 5
 */

public class Solution {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
      int n1 = Integer.parseInt(br.readLine());
      int n2 = Integer.parseInt(br.readLine());
      int n3 = Integer.parseInt(br.readLine());
      int n4 = Integer.parseInt(br.readLine());
      int n5 = Integer.parseInt(br.readLine());
      Prime ob = new Prime();
      ob.checkPrime(n1);
      ob.checkPrime(n1, n2);
      ob.checkPrime(n1, n2, n3);
      ob.checkPrime(n1, n2, n3, n4, n5);
      Method[] methods = Prime.class.getDeclaredMethods();
      Set<String> set = new HashSet<>();
      boolean overload = false;
      for (Method method : methods) {
        if (set.contains(method.getName())) {
          overload = true;
          break;
        }
        set.add(method.getName());

      }
      if (overload) {
        throw new Exception("Overloading not allowed");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private static final class Prime {

    void checkPrime(int... numbers) {
      for (int n : numbers) {
        if (this.isPrime(n)) {
          System.out.print(n + " ");
        }
      }
      System.out.println();
    }

    private boolean isPrime(int number) {
      if (number < 2) {
        return false;
      } else if (number == 2) {
        return true;
      } else if (number % 2 == 0) {
        return false;
      }

      int sqrt = (int) Math.sqrt(number);
      for (int i = 3; i <= sqrt; i += 2) {
        if (number % i == 0) {
          return false;
        }
      }
      return true;
    }
  }

}
