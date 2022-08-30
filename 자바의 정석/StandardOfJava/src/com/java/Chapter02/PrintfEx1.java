package com.java.Chapter02;

import org.w3c.dom.ls.LSOutput;

public class PrintfEx1 {

    public static void main(String[] args) {

        /*
        boolean형식으로 %b
        10진수 형식으로 %d demical
        8진수 형식으로 %o octal
        16진수 형식으로  %x he'x'a
        문자로 출력 %c character 1자
        문자열로 출력 %s String
        %n enter

         */

        byte b = 1;
        short s = 2;
        char c = 'A';

        int finger = 10;
        long big = 100_000_000_000L; //long big = 100000000000";
        long hex = 0xFFFF_FFFF_FFFF_FFFFL;

        int octNum = 010; // 8진수 10, 10진수로는 8
        int hexNum = 0x10; //16진수 10, 10진수로는 16
        int binNum = 0b10; // 2진수 10; // 2진수 10, 10진수로는 2

        System.out.printf("b=%d%n",b);
        System.out.printf("s=%d%n",s);
        System.out.printf("c=%c, %d%n", c, (int)c);
        System.out.printf("finger=[%5d]%n", finger);
        System.out.printf("finger=[%-5d]%n", finger);
        System.out.printf("finger=[%05d]%n", finger);
        System.out.printf("big=%d%n", big);
        System.out.printf("hex=%#x%n",hex); //'#'접두사 (16진수 0x 8진수0)
        System.out.printf("octNum=%o, %d%n", octNum, octNum);
        System.out.printf("hexNum=%x, %d%n", hexNum, hexNum);
        System.out.printf("binNum=%s, %d%n", Integer.toBinaryString(binNum), binNum); //Integer.toBinaryStirng (int i) 2진 문자열로 변환

    }


}
