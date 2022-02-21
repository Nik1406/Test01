package test_01;

import java.sql.SQLOutput;
import java.util.ArrayList;
public class Question {
    String textQuestion;
    Option[] options;
    public Question(String textQuestion) { this.textQuestion = textQuestion; }
    public void show() {
        System.out.println(textQuestion);
        int i=1;
        for(Option option: (Option[]) options){
            System.out.println("\t" + i++ + ") " + option.textOption);
        }
    }
    void result(){

    }
}
