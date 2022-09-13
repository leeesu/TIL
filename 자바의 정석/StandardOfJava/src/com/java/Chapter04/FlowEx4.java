package com.java.Chapter04;

import java.util.Scanner;

public class FlowEx4 {
    public static void main(String[] args) {
        int score = 0; //점수를 저장하기 위한 변수
        char grade = ' '; //학점을 저장하기 위한 변수, 공백으로 초기화

        System.out.println("점수를 입력하세요.>");
        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();

        if(score >= 90) { //score가 90점 보다 같거나 크면 A학점
            grade = 'A';
        }else if(score >=80) { //socre가 80보다 같거나 크면 B학점
            grade = 'B';
        }else if(score >=70) {// socre가 70보다 같거나 크면 C학점
            grade = 'C';
        }else { //score가 70보다 작으면 D학점
            grade = 'D';
        }
        System.out.println("당신의 학점은 " + grade +"입니다.");

    }
}
