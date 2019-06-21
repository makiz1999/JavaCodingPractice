package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class HW1 {
    //private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        LinkedList<String> cities = new LinkedList<>();
        addCity(cities, "Alabama");
        addCity(cities, "Knoxville");
        addCity(cities, "Detroit");
        printCities(cities);

    }
    private static void addCity(LinkedList<String> myCities, String city){
        ListIterator<String> listIterator = myCities.listIterator();
        while(listIterator.hasNext()){
            int index = listIterator.next().compareTo(city);
            if(index == 0){
                System.out.println("City already exists");
                return;
            } else if ( index > 0){
                listIterator.previous();
                listIterator.add(city);
                return;
            } else if ( index < 0){
                listIterator.add(city);
                return;
            }
        }
        listIterator.add(city);
        return;
    }
    private static void printCities(LinkedList cities){
        ListIterator<String> myList = cities.listIterator();
        while(myList.hasNext()){
            System.out.println(myList.nextIndex() + 1 + ". " + myList.next());
        }
    }
}

