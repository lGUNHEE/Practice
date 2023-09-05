package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    Scanner s ;
    ArrayList <Word> list;
    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }
    @Override
    public Object add() {
        System.out.print("Difficulty & Input new word : ");
        int level = s.nextInt();
        String word = s.nextLine();
        System.out.print("Input meaning : ");
        String mean = s.nextLine();
        return new Word(0,level, word, mean);
    }

    public void add_word() {
    Word one = (Word) add();
    list.add(one);
    System.out.print("The new word has been added in the vocabulary. ");
    }



    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }


    public void listAll() {
        System.out.println("---------------------");
        for(int i = 0; i<list.size(); i++){
            System.out.print((i+1)+" ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("------------------");
    }
}
