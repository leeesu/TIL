package com.java.Chapter04;

public class FlowEx13 {
    public static void main(String[] args) {
        int sum = 0; //합계를 저장하기 위한 변수

        for (int i = 0; i <= 10; i++) {
            sum += i;

            System.out.printf("1부터 %2d 까지의 합: %2%n", i, sum);
        }

    }
}
