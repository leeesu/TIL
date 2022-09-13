package com.java.Chapter03;

import java.util.Scanner;

public class OperatorEx25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char ch = ' ';

        System.out.println("문자를 하나 입력하세요.>");
        String input = scanner.nextLine();

        ch = input.charAt(0);
        //문자 하나니까 charAt, charAt(1)이면 두번째 문자를 출력한다.

        if('0' <=ch && ch <= '9'){
            System.out.printf("입력하신 문자는 숫자입니다.%n");
        }
        if(('a'<= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
            System.out.printf("입력하신 문자는 영문자입니다.%n");
        }
    }//main
}
