package com.javacore.lesson4;

import com.javacore.lesson4.interfaces.SuperList;
import com.javacore.lesson4.interfaces.SuperQueue;
import com.javacore.lesson4.interfaces.SuperStack;

public class HomeWork {

    public static void main(String[] args) {

        // Task 1
        SuperList<Integer> linked = new LinkedSuperList<>();

        System.out.println(linked.getSize());
        System.out.println(linked);

        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);

        System.out.println(linked);

        System.out.println(linked.get(0));

        linked.set(1, 66);
        System.out.println(linked);

        linked.remove(3);
        System.out.println(linked);

        linked.add(0, 55);
        System.out.println(linked);

        linked.add(4);
        System.out.println(linked);

        linked.addFirst(7777777);
        System.out.println(linked);

        linked.add(88888);
        System.out.println(linked);


        // Task 2
        // Stack
        SuperStack<Integer> stack = new StackCustom<>();
        System.out.println(stack);
        System.out.println(stack.size());
        stack.push(1);
        System.out.println(stack.size());
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack.size());
        stack.push(3);
        System.out.println(stack.size());
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);


        // Queue
        SuperQueue<Integer> queue = new QueueCustom<>();
        System.out.println(queue);
        queue.add(11);
        queue.add(22);
        queue.add(33);
        queue.add(44);
        System.out.println(queue);

        queue.poll();
        System.out.println(queue);

        System.out.println(queue.getFirst());
        System.out.println(queue);


        // Task 3
        // Map


    }

}
