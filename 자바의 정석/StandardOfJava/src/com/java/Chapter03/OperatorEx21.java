package com.java.Chapter03;

public class OperatorEx21 {
    public static void main(String[] args) {
        System.out.printf("10 == 10.0f    \t %b%n", 10==10.0f);
        //이항연산자이므로 연산을 수행하기 전에 형변환을 통해 두 피연산자의 타입을 같게 맞춘 타음 비교한다.
        //int와 float르므로 float으로 변환해서 비교함. true
        System.out.printf("'0'==0      \t %b%n", '0'==0);
        //'A'는 유니코드 이므로 변환해서 65 ==0 이므로 false
        System.out.printf("'a' ==65      \t %b%n", 'A'==65);
        // 65 == 65 true
        System.out.printf("'A' > 'B'       \t %b%n", 'A' > 'B');
        // 65 > 66이므로 false
        System.out.printf("'A'+1 != 'B'     \t %b%n", 'A'+ 1 != 'B');
        // 66 != 66 이므로 false
    }
}
