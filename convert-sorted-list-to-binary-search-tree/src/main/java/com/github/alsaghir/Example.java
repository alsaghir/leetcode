package com.github.alsaghir;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("c");
        List<String>b = a.subList(0,1);
        a.add("c");
        System.out.println(b.size());
    }

    public static void edit(ArrayList<Integer> y) {
        y.add(5);
    }

}
