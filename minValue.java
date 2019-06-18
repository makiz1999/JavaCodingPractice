package com.company;

import java.util.Scanner;


public class HW1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int [] myArray = readIntegers(5);
        int minValue = findMin(myArray);
        System.out.println("Minimum value is: " + minValue);

    }

    public static int[] readIntegers(int count){
        System.out.println("Enter " + count + " numbers for your array \r");
        int [] newArray = new int[count];
        for(int i = 0; i < newArray.length; i++){
            newArray[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return newArray;
    }
    public static int findMin(int[] minArray){
        int minValue = Integer.MAX_VALUE;
            for( int i = 0; i < minArray.length; i++) {
                if( minArray[i] < minValue){
                    minValue = minArray[i];

            }
        }
        return minValue;
    }
}

