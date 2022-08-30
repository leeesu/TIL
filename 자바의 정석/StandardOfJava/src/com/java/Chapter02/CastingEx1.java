package com.java.Chapter02;

public class CastingEx1 {
    public static void main(String[] args) {
        double d = 85.4;
        int score = (int)d;
        System.out.println("score="+score);
        System.out.println("d="+d);

        //score변수에 담으면서 casting해줬지만 원래 double d는 변화가 없다. 당연한건데.
    }
}
