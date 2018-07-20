package com.algorithms.algs4th.chapter0;

import java.util.ArrayList;

/**
 * 栈简单实现
 * Created by WANG on 2018/6/21.
 */
public class Stack<T> extends ArrayList {

    public Stack() {
        super();
    }

    public Stack(int size) {
        super(size);
    }

    public boolean push(T t) {
        return this.add(t);
    }

    public T pop() {
        if (super.size() == 0) {
            return null;
        } else {
            return (T) this.remove(super.size() - 1);
        }
    }

    public boolean isEmpty(){
        return super.isEmpty();
    }

}
