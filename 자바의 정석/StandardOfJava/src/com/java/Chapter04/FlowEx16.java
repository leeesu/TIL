package com.java.Chapter04;

public class FlowEx16 {
    public static void main(String[] args) {
        for(int i=1; i<=5; i++) {
            for(int j=1; j<=10; j++) {
                System.out.print("*"); //가로줄로 출력됨
            }
            System.out.println();
        }
    }
}
