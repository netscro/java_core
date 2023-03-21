package com.javacore.lesson4.interfaces;

public interface SuperQueue<Type> {

    Type poll();

    void add(Type value);

    int size();

    Type getFirst();

}
