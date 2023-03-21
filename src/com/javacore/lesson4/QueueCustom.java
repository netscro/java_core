package com.javacore.lesson4;

import com.javacore.lesson4.interfaces.SuperQueue;

import java.util.Arrays;

public class QueueCustom<Type> implements SuperQueue<Type> {

    private static Object[] temporaryArray;
    private static final int INIT_SIZE = 0;
    private static Object[] queueArray = new Object[INIT_SIZE];


    @Override
    public Type poll() {
        Type lastValue = getFirst();
        temporaryArray = new Object[size() - 1];
        for (int i = 1, j = 0; i < size(); i++) {
            temporaryArray[j] = queueArray[i];
            j++;
        }
        queueArray = temporaryArray;
        return lastValue;
    }

    @Override
    public void add(Type value) {
        temporaryArray = new Object[size() + 1];
        if (size() != INIT_SIZE) {
            Object[] firstArray = Arrays.copyOfRange(queueArray, 0, size());
            System.arraycopy(firstArray, 0, temporaryArray, 0, firstArray.length);
        }
        int index = getIndex();
        temporaryArray[index] = value;
        queueArray = temporaryArray;
    }

    @Override
    public int size() {
        return queueArray.length;
    }

    public String toString() {
        return Arrays.toString(queueArray);
    }

    private void emptyValidation() {
        if (size() == INIT_SIZE) {
            System.out.println("Nothing is there. The Queue is empty :(");
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

    @Override
    public Type getFirst() {
        emptyValidation();
        return (Type) queueArray[INIT_SIZE];
    }

}
