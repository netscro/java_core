package com.javacore.lesson4.interfaces;

public interface SuperList<Type> {

    Type get(int index);

    void set(int index, Type value);

    Type remove(int index);

    void add(int index, Type value);

    void add(Type value);

    void addFirst(Type value);

    int getSize();

}
