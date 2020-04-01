package com.luban.server;

/**
 * @author
 * @date 2020/2/29
 **/
public class mySingleton {
    private static mySingleton instance;
    private  mySingleton(){}

    public static mySingleton getInstance(){
        if (instance==null){
            instance = new mySingleton();
        }
        return instance;
    }
}
