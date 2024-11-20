package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import input.ConsoleInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input input = new ConsoleInput(new Scanner(System.in));
        System.out.println();
        App app = new App(input);
        app.run();
    }
}