package org.example;
import java.util.Scanner;

public class WordManager {
        Scanner s = new Scanner(System.in);
        WordCRUD wordCRUD;

        WordManager() {
            wordCRUD = new WordCRUD(s);
        }
    public int select (){
        System.out.print("***Master english words***\n"
                + "*****************************\n"
                + "1. See all of words\n"
                + "2. See words by levels\n"
                + "3. Search words\n"
                + "4. Add words\n"
                + "5. Edit words\n"
                + "6. Delete words\n"
                + "7. Save the word\n"
                + "0. Exit\n"
                + "***What do you want?***\n");

        return s.nextInt();
    }

        public void start() {
            while (true) {
                int menu = select();
                System.out.println(menu);
                if(menu == 0) break;
                else if (menu == 1){
                    wordCRUD.listAll();
                }
                else if (menu ==2){
                    wordCRUD.list_by_level();
                }
                if(menu == 4){
                    wordCRUD.add_word();
                }

            }
        }


}
