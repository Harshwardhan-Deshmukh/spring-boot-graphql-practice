package com.springboot.graphql.graphqlDemo.utils;

public class ExceptionHandler {
    public static RuntimeException throwResourceNotFound(Long id, String type) {
        String message = String.format("%s not found with id : %d", type, id);
        return new RuntimeException(message);
    }
}
