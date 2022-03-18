package org.tqsexercises;

import java.util.ArrayList;


public class BoundedStack<T> extends Stack<T> {


    private int limit;

    public BoundedStack(int limit) {
        super();
        this.limit = limit;
    }

    public void push(T object){

        if (stack.size() >= limit){
            throw new IllegalStateException();
        }
        else {
            this.stack.add(object);
        }
    };

    public void setlimit(int limit){
        this.limit = limit;
    }

    public int getlimit(){
        return this.limit;
    }

}
