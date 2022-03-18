package org.tqsexercises;

import java.util.ArrayList;

public abstract class Stack<T> {

    private ArrayList<T> stack;
    protected int limit = -1;


    public void push(T object){

        if ((stack.size() >= limit) && (limit > 0)){
            throw new IllegalStateException();
        }

        this.stack.add(object);
    };

    public void remove(T object){
        this.stack.remove(object);
    };

    public T peek(){
        T object;
        int index = this.stack.size() - 1;
        object = this.stack.get(index);
        return object;
    }

    public int size(){
        return this.stack.size();
    };

    public boolean isEmpty(){
      if(this.stack.size()==0){
          return true;
      };
      return false;
    }

    public T pop(){
        T object = this.peek();
        this.stack.remove(object);
        return object;
    }


}
