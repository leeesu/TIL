package com.java.Chapter04;

import java.util.Scanner;

public class FlowEx {
    public static void main(String[] args) {
        System.out.println("가위(1), 바위(2), 보(3) 중 하나를 입력하세요. >");
        Scanner scanner = new Scanner(System.in);
        int user = scanner.nextInt();
        int com = (int) (Math.random() * 3) + 1; //1,2,3중 하나가 저장
        // +1 1이상 *3 3이하의 난수 생성
        System.out.println("당신은 " + user + "입니다.");
        System.out.println("컴은 " + com + "입니다.");

        switch (user - com) {
            case 2:
            case -1:
                System.out.println("당신이 졌습니다.");
                break;
            case 1:
            case -2:
                System.out.println("당신이 이겼습니다.");
                break;
            case 0:
                System.out.println("비겼습니다.");
                break; //마지막 문장이므로 굳이 안써도 됨.
        }
    }
}
