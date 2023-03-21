package com.javacore.lesson4;

import com.javacore.lesson4.interfaces.SuperList;

public class LinkedSuperList<Type> implements SuperList<Type> {
    private int size = 0;
    private Node<Type> first;
    private Node<Type> last;

    private static class Node<Type> {
        Type value;
        Node<Type> next;

        public Node(Type value) {
            this.value = value;
        }
    }

    @Override
    public Type get(int index) {
        emptyValidation();
        indexValidation(index);
        Node<Type> currentValue = getNodeValue(index);
        return currentValue.value;
    }

    @Override
    public void set(int index, Type value) {
        emptyValidation();
        indexValidation(index);
        Node<Type> currentValue = getNodeValue(index);
        currentValue.value = value;
    }

    @Override
    public Type remove(int index) {
        emptyValidation();
        indexValidation(index);
        Type removedValue;
        if (index == 0) {
            removedValue = first.value;
            first = first.next;
            if (first == null) {
                last = first;
            }
        } else {
            Node<Type> previousValue = getNodeValue(index - 1);
            removedValue = previousValue.next.value;
            previousValue.next = previousValue.next.next;
            if (index == size - 1) {
                last = previousValue;
            }
        }
        size--;
        return removedValue;
    }

    @Override
    public void add(int index, Type value) {
        indexValidation(index);
        Node<Type> node = new Node<>(value);
        if (first == null) {
            first = last = node;
        } else if (index == size) {
            last.next = node;
            last = node;
        } else if (index == 0) {
            node.next = first;
            first = node;
        } else {
            Node<Type> previousValue = getNodeValue(index - 1);
            node.next = previousValue.next;
            previousValue.next = node;
        }
        size++;
    }

    @Override
    public void add(Type value) {
        Node<Type> node = new Node<>(value);
        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public void addFirst(Type value) {
        Node<Type> node = new Node<>(value);
        node.next = first;
        first = node;
        size++;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<Type> currentValue = first;
        for (int i = 0; i < size; i++) {
            s.append(currentValue.value);
            if (i < size - 1) {
                s.append(", ");
            }
            currentValue = currentValue.next;
        }
        return "[" + s + "]";
    }

    @Override
    public int getSize() {
        return size;
    }

    private Node<Type> getNodeValue(int index) {
        Node<Type> currentValue = first;
        for (int i = 0; i < index; i++) {
            currentValue = currentValue.next;
        }
        return currentValue;
    }

    private void indexValidation(int index) {
        if (index > size - 1 || index < 0) {
            System.out.println("Incorrect index. Please choose the existing index.");
            throw new IndexOutOfBoundsException();
        }
    }

    private void emptyValidation() {
        if (size == 0) {
            System.out.println("Nothing is there. The " + getClass().getSimpleName() + " is empty :(");
            throw new IllegalArgumentException();
        }
    }

}
