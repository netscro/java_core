package com.javacore.lesson3;


public class HomeWork {

    public static void main(String[] args) {

        SuperArrayList<String> superArrayList = new SuperArrayList<>();

        superArrayList.add(0, "text_1");
        superArrayList.add(1, "text_2");
        superArrayList.add(2, "text_3");
        superArrayList.add(3, "text_4");

        System.out.println("superArrayList = " + superArrayList);

        System.out.println("superArrayList size before del = " + superArrayList.size());
        System.out.println("Removed value is - " + superArrayList.get(1));
        superArrayList.remove(1);
        System.out.println("superArrayList size after del = " + superArrayList.size());
        System.out.println("superArrayList = " + superArrayList);

        superArrayList.set(0, "hello");

        System.out.println("superArrayList index value = " + superArrayList.get(1));

        System.out.println("superArrayList = " + superArrayList);

    }

}
