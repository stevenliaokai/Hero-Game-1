package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Hero Steven;
        Steven = new Hero("Steven", 100, 50, 20, 5, 1);
        Hero Max;
        Max = new Hero("Max", 150, 30, 20, 5, 0.1);
        Max.becomeBoss();
        Steven.attackEachOther(Max);
        while (Steven.health > 0 && Max.health > 0) {
            Steven.attackEachOther(Max);
        }
    }

}

