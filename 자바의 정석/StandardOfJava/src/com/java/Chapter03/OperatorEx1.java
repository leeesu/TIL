package com.java.Chapter03;

public class OperatorEx1 {
    public static void main(String[] args) {
        int i=5;
        i++; // i=i+1; 과 같은 의미다. ++i;로 바꿔 써도 결과는 같다.
        System.out.println(i);

        i=5; //결과를 비교하기 위해서 다시 5로 변경
        ++i;
        System.out.println(i);        //결과값 둘다 6, 수식에 포함된게 아니고 단독적으로 사용된거기에 차이 없다.

    }
}
