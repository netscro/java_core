package com.javacore.lesson3;

import java.util.Arrays;

public class SuperArrayList<Type> implements BestList<Type> {

    private static final int LIST_SIZE = 0;
    private static Object[] array = new Object[LIST_SIZE];
    private static Object[] temporaryArray;

    @Override
    public Type get(int index) {
        indexValidation(index);
        return (Type) array[index];
    }

    @Override
    public void set(int index, Type value) {
        indexValidation(index);
        array[index] = value;
    }

    @Override
    public void remove(int index) {
        indexValidation(index);
        if (isNotEmptyArray()) {
            temporaryArray = new Object[size() - 1];
            for (int i = 0, j = 0; i < size(); i++) {
                if (array[i] != array[index]) {
                    temporaryArray[j] = array[i];
                    j++;
                }
            }
            array = temporaryArray;
        }
    }

    @Override
    public void add(int index, Type value) {
        indexValidation(index);
        temporaryArray = new Object[size() + 1];

        if (index != 0) {
            Object[] firstArray = Arrays.copyOfRange(array, 0, index);
            System.arraycopy(firstArray, 0, temporaryArray, 0, firstArray.length);
        }

        temporaryArray[index] = value;

        if (size() != index) {
            Object[] secondArray = Arrays.copyOfRange(array, index, size());
            System.arraycopy(secondArray, 0, temporaryArray, index + 1, secondArray.length);
        }

        array = temporaryArray;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    private boolean isNotEmptyArray() {
        if (size() == 0) {
            System.out.println("Nothing is there. The array is empty :(");
            return false;
        }
        return true;
    }

    private void indexValidation(int index){
        if (index > size() || index < 0){
            System.out.println("Incorrect index. Please choose the existing index.");
            throw new IndexOutOfBoundsException();
        }
    }

}
