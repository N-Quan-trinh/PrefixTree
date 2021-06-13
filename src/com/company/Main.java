package com.company;

public class Main {

    public static void main(String[] args) {
        treeList dictionary = new treeList();
        dictionary.add("butter");
        dictionary.add("butt");
        dictionary.add("aromatic");
        dictionary.add("air");
        System.out.println(dictionary.exist("aromatic"));
    }
}
