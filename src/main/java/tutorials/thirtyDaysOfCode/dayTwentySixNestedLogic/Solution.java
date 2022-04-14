package tutorials.thirtyDaysOfCode.dayTwentySixNestedLogic;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);

    final int[] dateReturned = Arrays.stream(scanner.nextLine()
        .split(" ")).mapToInt(Integer::parseInt).toArray();
    final LocalDate localDateReturned = LocalDate.of(dateReturned[2], dateReturned[1], dateReturned[0]);

    final int[] dateDue = Arrays.stream(scanner.nextLine()
        .split(" ")).mapToInt(Integer::parseInt).toArray();
    final LocalDate localDateDue = LocalDate.of(dateDue[2], dateDue[1], dateDue[0]);

    final long hackos = calculateHackos(localDateReturned, localDateDue);
    System.out.println(hackos);

  }

  private static long calculateHackos(LocalDate localDateReturned, LocalDate localDateDue) {
    long diffDays = DAYS.between(localDateDue, localDateReturned);
    long diffMonths = MONTHS.between(localDateDue, localDateReturned);

    if (diffDays <= 0) {
      return 0L;

    } else if (localDateDue.getMonthValue() == localDateReturned.getMonthValue()
        && localDateDue.getYear() == localDateReturned.getYear()) {
      return diffDays * 15;

    } else if (localDateDue.getMonthValue() < localDateReturned.getMonthValue()
        && localDateDue.getYear() == localDateReturned.getYear()) {
      return diffMonths * 500;

    } else {
      return 10000L;
    }
  }
}
