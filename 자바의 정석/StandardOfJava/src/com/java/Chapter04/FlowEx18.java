package com.java.Chapter04;

public class FlowEx18 {
    public static void main(String[] args) {
        for(int i=2; i<=9; i++) { //얘가 한번 돌아가면
            for(int j=2; j<=9; j++) { //얘는 다 돌아가야 i가 돌아갈수 있음.
                System.out.printf("%d x %d = %d%n", i,j,i*j);
            }
        }
    }
}
