package test_01;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Quiz {
    String quiz;
    Question[] questions;
    void run(){
        System.out.println("Тест: " + quiz);
        int i=1;
        for(Question question: (Question[]) questions){
            if(question != null){
                System.out.println("\n" + i++ + ". ");
                question.show();
                this.result();
            }
        }
    }
    void result(){
    }
}
