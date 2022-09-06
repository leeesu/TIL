package com.java.Chapter03;

public class OperatorEx6 {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        byte c = (byte)(a + b);
        //그냥 byte c = a + b를 하면 오류가 난다.
        System.out.println(c);
    }
}
