package Advanced.JavaMD5;

/*
https://www.hackerrank.com/challenges/java-md5/problem

INPUT
HelloWorld

OUTPUT
68e109f0f40ca72a15e05cc22786f8e6


 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

public class Solution {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    final Scanner scanner = new Scanner(System.in);
    final String str = scanner.next();
    final MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(str.getBytes());
    final byte[] digest = md.digest();
    final String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();
    System.out.println(myHash);
  }
}
