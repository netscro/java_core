package com.javacore.lesson4.interfaces;


public interface SuperStack<Type> {

    Type pop();

    void push(Type value);

    Type peek();

    int size();

}
