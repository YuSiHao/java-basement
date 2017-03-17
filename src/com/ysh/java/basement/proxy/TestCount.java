package com.ysh.java.basement.proxy;

public class TestCount {  
    public static void main(String[] args) {  
        CountImpl countImpl = new CountImpl();  
        CountProxy countProxy = new CountProxy(countImpl);  
        countProxy.updateCount();  
        countProxy.queryCount();  
  
    }  
} 
