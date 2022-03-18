package org.tqsexercises;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public abstract class Stack<T> {

    protected ArrayList<T> stack;

    public Stack(){
        this.stack = new ArrayList<T>();
    }

    public abstract void push(T object);

    public void remove(T object){
        this.stack.remove(object);
    };

    public T peek() throws NoSuchElementException {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            T object;
            int index = this.stack.size() - 1;
            object = this.stack.get(index);
            return object;
        }
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
