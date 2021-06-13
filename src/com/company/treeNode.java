package com.company;
import java.util.*;
public class treeNode {
    Set<Character> charList = new LinkedHashSet<>();
    char curr;
    treeNode[] childrens = new treeNode[26];
    boolean affix = false;



    public void addNode(String word)
    {
        // check if the character is already a child of this node
        if(!charList.contains(word.charAt(0))){
            int ascii = (int) word.charAt(0);
            //if not then proceed to create a children with this character
            treeNode child = new treeNode();
            child.curr = word.charAt(0);
            //adding the current character and the tree node to their own respective list.
            charList.add(word.charAt(0));
            childrens[ascii - 97] = child;
            //create a substring of word excluding the first character, then recursively run the add note again.
            String temp = word.substring(1);
            /*recursive the addNode function with the child Node.
            This will only run if there are some words left to be processed, else if is is empty, break*/
            if(temp.length() != 0){
            child.addNode(temp);
            }else{
                child.affix = true;
            }
        }else if(charList.contains(word.charAt(0)) && word.length() > 1){
            //create a temp string containing everything except the first letter
            String temp = word.substring(1);
            //Since the letter already exist, find that child
            int index = (int) word.charAt(0);
            //Using that child and call addNode using the above word
            childrens[index -97].addNode(temp);
        }else if(charList.contains(word.charAt(0)) && word.length() == 1){
            int index = (int) word.charAt(0);
            childrens[index - 97].affix = true;
        }
    }

    public String to_string()
    {
        String childString = "";
        for(int i=0; i < 26; i++){
            if(childrens[i] != null){
                childString = childString + childrens[i].to_string();
            }
        }
        String output = "("+this.curr+childString+")";
        return output;
    }
    public boolean exist(String word){
        //each node will check for its child whether or not it matches with the current character or not.
        //separate word into temp, which contains the first character
        String temp = word.substring(1);
        //cast an integer as index, using that index perform recursion
        int index = (int) word.charAt(0);
        //checks if the character exist or not and whether it is the last char.
        if(charList.contains(word.charAt(0)) && word.length() > 1){
            return  childrens[index - 97].exist(temp);
        }
        //if not, we r pretty sure this is the last character, so checks whether the last character exist in the list and if that children has an affix of true
        else return charList.contains(word.charAt(0)) && this.childrens[index - 97].affix;
    }

}

