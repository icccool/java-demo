package com.jdk18;

public class MyDataSource implements AutoCloseable{

    boolean isClosed;


    public MyDataSource(boolean bool){
        isClosed = bool;
    }

    @Override
    public void close() throws Exception {
        isClosed = false;
        System.out.println("MyDataSource closed");
    }


}