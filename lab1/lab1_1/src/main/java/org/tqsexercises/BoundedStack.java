package org.tqsexercises;

import java.util.ArrayList;

public class BoundedStack extends Stack {


    public BoundedStack(int limit) {
        super();
        this.limit = limit;
    }

    public void setlimit(int limit){
        this.limit = limit;
    }

    public int getlimit(){
        return this.limit;
    }

}
