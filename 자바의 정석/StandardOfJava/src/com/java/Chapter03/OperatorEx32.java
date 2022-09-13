package com.java.Chapter03;

public class OperatorEx32 {
    public static void main(String[] args) {
        int x, y, z;
        int absX, absY, absZ;
        char signX, signY, signZ;

        x = 10;
        y = -5;
        z = 0;

        absX = x >= 0 ? x : -x; //x값이 음수이면, 양수로 만든다.
        absY = y >= 0 ? y : -y;
        absZ = z >= 0 ? z : -z;

    }
}
