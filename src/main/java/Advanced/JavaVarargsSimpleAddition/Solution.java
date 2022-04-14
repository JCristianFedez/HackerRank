package Advanced.JavaVarargsSimpleAddition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/simple-addition-varargs/problem
 *
 * Input 1 2 3 4 5 6
 *
 * Output 1+2=3 1+2+3=6 1+2+3+4+5=15 1+2+3+4+5+6=21
 */
class Add {

  public void add(int... numbers) {
    int sum = 0;
    final StringBuilder sb = new StringBuilder();

    for (int n : numbers) {
      sum += n;
    }

    final String str = Arrays.toString(numbers)
        .replace(", ", "+")
        .replace("[", "")
        .replace("]", "");

    sb.append(str).append("=").append(sum);
    System.out.println(sb.toString());
  }
}

public class Solution {

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n1 = Integer.parseInt(br.readLine());
      int n2 = Integer.parseInt(br.readLine());
      int n3 = Integer.parseInt(br.readLine());
      int n4 = Integer.parseInt(br.readLine());
      int n5 = Integer.parseInt(br.readLine());
      int n6 = Integer.parseInt(br.readLine());
      Add ob = new Add();
      ob.add(n1, n2);
      ob.add(n1, n2, n3);
      ob.add(n1, n2, n3, n4, n5);
      ob.add(n1, n2, n3, n4, n5, n6);
      Method[] methods = Add.class.getDeclaredMethods();
      Set<String> set = new HashSet<>();
      boolean overload = false;
      for (int i = 0; i < methods.length; i++) {
        if (set.contains(methods[i].getName())) {
          overload = true;
          break;
        }
        set.add(methods[i].getName());

      }
      if (overload) {
        throw new Exception("Overloading not allowed");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
