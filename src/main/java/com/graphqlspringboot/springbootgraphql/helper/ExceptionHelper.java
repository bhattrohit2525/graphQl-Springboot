package com.graphqlspringboot.springbootgraphql.helper;

public class ExceptionHelper {
    public static RuntimeException throwResourceNotFoundException(){
        return  new RuntimeException("!!!Resource not found!!!");
    }
}
