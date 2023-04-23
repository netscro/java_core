package com.javacore.lesson12;

import java.lang.reflect.Field;


public class NotNullValueValidator {

    public void ValidateObjectFields(Object object) throws NotNullValueException, IllegalAccessException {
        Class<?> cl = object.getClass();
        Field[] fields = cl.getFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNullValue.class)) {
                if (field.get(object) == null) {
                    throw new NotNullValueException("\n" + field + " == null. Please set value to this field.");
                }
            }
        }

    }

}
