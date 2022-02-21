package test_01;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuizApp {
    static Question question;
    static int userAnswer;
    static boolean userResult;

    public static void main(String[] args) {

        question = new Question("Как стать программистом?");
        question.options = new Option[3];

        question.options[0] = new Option("необходимо устроиться на работу ... грузчиком",false);
        question.options[1] = new Option("необходимо много думать и практиковаться",true);
        question.options[2] = new Option("никак",false);

        System.out.println("Запуск теста по дисциплине: \"Программист\"");
        System.out.println(question.textQuestion);
        int num = 1;
        System.out.println("\nВопрос №" + num + ":");
        int i = 1;
        for(Option opt: question.options){
            System.out.print(i + ") ");
            System.out.println(opt.textOption);
            i++;
        }
        System.out.println();

        System.out.println("Выберите правильный вариант ответа:");
        userAnswer = checkCorrectInput(new Scanner(System.in), i );

        if(question.options[userAnswer - 1].correct) {
            System.out.println("Ответ правильный!");
            userResult = true;
        } else {
            System.out.println("Ответ неверный.");
            userResult = false;
        }

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("c:/test/quiz-save.txt");
            save(fileOutputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static int checkCorrectInput(Scanner scanner, int m){

        int answer = 0;

        boolean isCorrectOption;

        try {

            answer = scanner.nextInt();

            if(answer < 1 || answer > m) throw new IllegalArgumentException();

        } catch (InputMismatchException e) {
            System.out.println("Введена не цифра: ");
        } catch (IllegalArgumentException e){
            System.out.println("Введен не существующий вариант: ");
        }

        return answer;
    public static void save (OutputStream outputStream) throws Exception{
            PrintWriter printWriter = new PrintWriter(outputStream);

            int i = 1;
            if(question != null) {
                printWriter.println("Вопрос №");
                printWriter.println(question.textQuestion);

                printWriter.println("N)\t[уст]\t[польз]\t Описание ответа");
                for(Option option: question.options){
                    printWriter.print(i + ")\t");
                    printWriter.print("[" + option.correct + "]\t");
                    if(i == userAnswer )
                        printWriter.print("[true]\t");
                    else
                        printWriter.print("[    ]\t");

                    printWriter.println(option.textOption);
                    i++;
                }
            }

            printWriter.close();
        }
    }

}
