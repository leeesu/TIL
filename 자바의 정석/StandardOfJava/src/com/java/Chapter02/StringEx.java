package com.java.Chapter02;

public class StringEx {
    public static void main(String[] args) {
        String name="Ja" + "va";
        String str = name + 8.0; // 문자 하나라도 있으면 걍 다 문자됨

        System.out.println(name);
        System.out.println(str);
        System.out.println(7 + " "); // 기본형 타입을 문자열로 변환할 때 아무내용도 없는 빈 문자열을 더해주면 됨
        System.out.println(" " + 7);
        System.out.println(7 + "");
        System.out.println("" + 7);
        System.out.println("" + "");
        System.out.println(7 + 7 + "");
        System.out.println("" + 7 + 7);
    }
}
