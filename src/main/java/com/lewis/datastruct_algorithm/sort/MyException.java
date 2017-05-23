package com.lewis.datastruct_algorithm.sort;

/**
 * Created by Administrator on 2017/5/23.
 */
public class MyException extends Exception {

    private String msg;

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
