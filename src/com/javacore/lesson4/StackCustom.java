package com.javacore.lesson4;

import com.javacore.lesson4.interfaces.SuperStack;

import java.util.Arrays;

public class StackCustom<Type> implements SuperStack<Type> {

    private static Object[] temporaryArray;
    private static final int INIT_SIZE = 0;
    private static Object[] stackArray = new Object[INIT_SIZE];


    @Override
    public Type pop() {
        Type lastValue = getLast();
        int length = size() - 1;
        temporaryArray = new Object[length];
        for (int i = 0, j = 0; i < length; i++) {
            temporaryArray[j] = stackArray[i];
            j++;
        }
        stackArray = temporaryArray;
        return lastValue;
    }

    @Override
    public void push(Type value) {
        temporaryArray = new Object[size() + 1];
        if (size() != INIT_SIZE) {
            Object[] firstArray = Arrays.copyOfRange(stackArray, 0, size());
            System.arraycopy(firstArray, 0, temporaryArray, 0, firstArray.length);
        }
        int index = getIndex();
        temporaryArray[index] = value;
        stackArray = temporaryArray;
    }

    @Override
    public Type peek() {
        return getLast();
    }

    @Override
    public int size() {
        return stackArray.length;
    }

    public String toString() {
        return Arrays.toString(stackArray);
    }

    private void emptyValidation() {
        if (size() == INIT_SIZE) {
            System.out.println("Nothing is there. The Stack is empty :(");
            throw new IllegalArgumentException();
        }
    }

    private int getIndex() {
        int index = INIT_SIZE;
        if (size() == index) {
            return index;
        }
        return size();
    }

    private Type getLast() {
        emptyValidation();
        return (Type) stackArray[size() - 1];
    }


}
