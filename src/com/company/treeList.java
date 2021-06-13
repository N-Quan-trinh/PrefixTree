package com.company;

public class treeList {
    treeNode root = new treeNode();


    public boolean add(String word){
        if(word.length() != 0){
            root.addNode(word);
        }else{
            System.out.println("Can't be an empty word!");
            return false;
        }
        return true;
    }
    public String to_string(){
        return root.to_string();
    }

    public boolean exist(String word){
        if(word.length() == 0){
            return false;
        }else{
            return root.exist(word);
        }
        }
    }

