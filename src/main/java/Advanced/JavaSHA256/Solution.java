package Advanced.JavaSHA256;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/sha-256/problem

INPUT
HelloWorld

OUTPUT
872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4

 */
public class Solution {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        final Scanner scanner = new Scanner(System.in);
        final String str = scanner.next();
        final MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes());
        final byte[] digest = md.digest();
        final String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();
        System.out.println(myHash);
    }
}
