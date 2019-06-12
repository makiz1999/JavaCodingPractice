package com.company;

import java.util.Scanner;

public class HW1 {
    public static void inputThenPrintSumAndAverage(){
        int sum = 0;
        int num = 0;
        long avg = 0;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            boolean isInt = scanner.hasNextInt();
            if (isInt) {
                counter ++;
                num = scanner.nextInt();
                sum += num;
            } else if ( counter == 0 ){
                System.out.println("SUM = 0 AVG = 0");
            } else {
                break;
            }
            scanner.nextLine();
        }
        avg = Math.round((double)sum/counter);
        System.out.println("SUM = " + sum + " AVG = " + avg);
        scanner.close();
    }
    public static void main(String[] args){
        inputThenPrintSumAndAverage();

    }
}

