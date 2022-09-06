package com.java.Chapter03;

public class OperatorEx17 {
    public static void main(String[] args) {
        double pi = 3.141592;
        double shortPi = (int)(pi * 1000 + 0.5) / 1000.0;
        //연산의 순서상 곱하기가 제일 번저 이루어진다.
        System.out.println(shortPi);
    }
}
