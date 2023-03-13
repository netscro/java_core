package com.javacore.lesson3;

public interface BestList<Type> {

    Type get(int index);

    void set(int index, Type value);

    void remove(int index);

    void add(int index, Type value);

    String toString();

    int size();

}
