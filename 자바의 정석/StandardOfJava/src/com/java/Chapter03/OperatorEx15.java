package com.java.Chapter03;

public class OperatorEx15 {
    public static void main(String[] args) {
        char lowerCase = 'a';
        char upperCase = (char)(lowerCase - 32);
        //대문자 A가 소문자 코드값이 32가 적으므로 소문자 a의 코드값에서 32를 빼면 된다. 반대로 대문자 소문자 방식은 더해주면 됨.
        System.out.println(upperCase);
    }
}
