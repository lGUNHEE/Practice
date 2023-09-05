package org.example;
import javax.lang.model.type.ArrayType;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class WordCRUD implements ICRUD {
    Scanner s ;
    final String filename = "dictionary.txt";
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
    public void update_list(){
        System.out.print("수정할 단어 검색 : ");
        String str = s.next();
        ArrayList <Integer> id_list = this.listAll(str);
        System.out.print("수정할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("뜻 입력");
        String meaning = s.nextLine();
        Word word =list.get(id_list.get(id-1));
        word.setMeaning(meaning);
        System.out.println("수정이 완료되었습니다.");


    }

    public ArrayList <Integer> listAll(String str){
        ArrayList <Integer> id_list = new ArrayList<>();
        int j=0;
        System.out.println("---------------------");
        for(int i = 0; i<list.size(); i++){
            String word = list.get(i).getWord();
            if(!word.contains(str)) continue;
            System.out.print((j+1)+" ");
            System.out.println(list.get(i).toString());
            id_list.add(i);
            j++;
        }
        System.out.println("------------------");
        return id_list;
    }

    public void delete_one(){
        System.out.print("삭제할 단어 검색 : ");
        String str = s.next();
        ArrayList <Integer> id_list = this.listAll(str);
        System.out.print("삭제할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print(" 정말로 삭제 하시겠습니까?(Y/N) ");
        String answer = s.next();
        if(answer.equalsIgnoreCase("y")){
            list.remove((int)id_list.get(id-1));
        }
        else System.out.print("삭제가 취소 되었습니다.");

        System.out.print("단어가 삭제 되었습니다.");

    }

    public void loadFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line;
            int counter=0;
            while(true) {
                line = br.readLine();
                if (line ==null) break;

                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                list.add(new Word(0,level,word,meaning));
                counter++;
            }

            br.close();
            System.out.print("... "+counter+" 개 로딩 완료!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void list_level(){
        System.out.print("---- 원하는 레벨은?(1~3)");
        int level = s.nextInt();
        listAll(level);
    }

    public void listAll(int level){
        int j=0;
        System.out.println("---------------------");
        for(int i = 0; i<list.size(); i++){
            int ilevel = list.get(i).getLevel();
            if(ilevel!=level) continue;
            System.out.print((j+1)+" ");
            System.out.println(list.get(i).toString());
            j++;
        }
        System.out.println("------------------");
    }


    public void saveFile(){
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(filename));
            for (Word one : list) {
                pr.write(one.toFileString() + "\n") ;
            }

            pr.close();

            System.out.println("--- 데이터 저장 완료");

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }


    public void listAll() {
        System.out.println("---------------------");
        for(int i = 0; i<list.size(); i++){
            System.out.print((i+1)+" ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("------------------");
    }

    public void searchWord() {
        System.out.print("----원하는 단어는?");
        String word = s.next();
        listAll(word);
    }
}
