package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;

        ArrayList<Month> months = new ArrayList<Month>();

	    Month m1 = new Month("Ocak",31);
        Month m2 = new Month("Şubat",28);
        Month m3 = new Month("Mart",31);
        Month m4 = new Month("Nisan",30);
        Month m5 = new Month("Mayıs",31);
        Month m6 = new Month("Haziran",30);
        Month m7 = new Month("Temmuz",31);
        Month m8 = new Month("Ağustos",31);
        Month m9 = new Month("Eylül",30);
        Month m10 = new Month("Ekim",31);
        Month m11 = new Month("Kasım",30);
        Month m12 = new Month("Aralık",31);

        months.add(m1);
        months.add(m2);
        months.add(m3);
        months.add(m4);
        months.add(m5);
        months.add(m6);
        months.add(m7);
        months.add(m8);
        months.add(m9);
        months.add(m10);
        months.add(m11);
        months.add(m12);


        System.out.print("exit = 1010\n");

        boolean chosen = true;

        while(chosen) {
            System.out.print("enter numbers of days ==> ");
            input = scanner.nextInt();

            if(input==1010){
                System.out.println("bye !");
                break;
            }
            if(input>=365 || input<=0){
                System.out.println("wrong entery !");
                break;
            }
            for (int i=0; i<months.size(); i++) {
                input-=months.get(i).getGün();
                if(input<=31) {
                    System.out.println(input + " " +months.get(i+1).getName());
                    break;
                }
            }
        }




    }
}
