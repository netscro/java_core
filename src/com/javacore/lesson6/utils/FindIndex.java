package com.javacore.lesson6.utils;

import com.javacore.lesson6.models.OrderStatus;

import java.util.Arrays;

public class FindIndex {

    public static int indexOf(Enum<OrderStatus>[] arr, Enum<OrderStatus> orderStatus) {
        return Arrays.asList(arr).indexOf(orderStatus);

    }

}
