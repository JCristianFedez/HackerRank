package pruebas;


import java.io.IOException;


class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {

        if (reverse(s).equals(s)) {
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {
            final StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            final String uno = reverse(sb.toString());
            final String dos = sb.toString();
            if (reverse(sb.toString()).equals(sb.toString())) {
                return i;
            }
        }

        return -1;
    }

    private static String reverse(String s) {
        final StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        final String s = "123421";
        System.out.println(Result.palindromeIndex(s));
    }
}

