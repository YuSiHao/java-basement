package com.ysh.java.basement.list;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveListElement {

    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");

        for (String s : list) {
            if (s.equals("B")) {
                list.remove(s);
            }
        }

        //foreach same as Iterator
        /*Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            String s=iterator.next();
            if (s.equals("B")) {
                list.remove(s);
            }
        }*/    
    }
}
