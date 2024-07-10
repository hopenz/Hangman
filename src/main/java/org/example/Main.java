package org.example;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String[] spisokSlov = new String[]{"кошка",
            "здание", "улитка", "школа", "универ",
            "посуда", "стол", "кровать", "лимонад", "соска"};
    private static final Random random = new Random();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Начать новую игру");
            System.out.println("2. Выход из игры");
            String menu = scanner.nextLine();
            if (menu.equals("2")) {
                break;
            } else if (menu.equals("1")) {
                game();
            } else {
                System.out.println("Дебил, введи правильно!");
            }
        }
    }

    private static void game() {
        String word = spisokSlov[random.nextInt(10)];
        char[] correctWord = word.toCharArray();
        char[] gameWord = new char[word.length()];
        Arrays.fill(gameWord, '*');
        int mistake = 0;
        while (mistake < 4) {
            printWord(gameWord);
            char letter = inputLetter();
            boolean check = checkLetter(letter, correctWord, gameWord);
            if (!check) {
                mistake++;
                System.out.println("Количество ошибок: " + mistake);
                if (mistake > 3){
                    System.out.println("Лох! Проиграл( ");
                }
            } else {
                boolean checkWord = checkFullWord(correctWord, gameWord);
                if (checkWord) {
                    System.out.println("Красавчик, выебал :3, но все равно лох");
                    break;
                }
            }
        }
        System.out.println("Game over");

    }

    private static boolean checkFullWord(char[] correctWord, char[] gameWord) {
        for (int i = 0; i < correctWord.length; i++) {
            if (correctWord[i] != gameWord[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printWord(char[] gameWord) {
        System.out.print("Загаданное слово: ");
        for (char c : gameWord) {
            System.out.print(c);
        }
        System.out.println();
    }

    private static char inputLetter() {
        while (true) {
            System.out.println("дебил, букву введи: ");
            String letter = scanner.nextLine();
            if (letter.length() == 1) {
                return letter.charAt(0);
            }
            System.out.println("Ну ты и даун");
        }
    }

    private static boolean checkLetter(char x, char[] correctWord, char[] gameWord) {
        boolean check = false;
        for (int i = 0; i < correctWord.length; i++) {
            if (correctWord[i] == x) {
                gameWord[i] = x;
                check = true;
            }
        }
        return check;
    }

}