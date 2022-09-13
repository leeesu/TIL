package com.java.Chapter04;

import java.util.Scanner;

public class FlowEx10 {
    public static void main(String[] args) {
        int score = 0;
        char grade = ' ';
        System.out.println("당신의 점수를 입력하세요. (1~100)>");

        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();

        //int형이기 때문에 88/10은 8.8이 아니라 8을 얻는다.
        switch(score/10) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
            case 7:
                grade = 'C';
            default:
                grade = 'F';
        }//end of switch
        System.out.println("당신의 학점은 "+grade+"입니다.");
    }
}
