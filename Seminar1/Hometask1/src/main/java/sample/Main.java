package sample;

import com.gb.grizzle.Calculator;
import com.gb.grizzle.Decorator;

public class Main {
    /**
     * Точка входа в программу
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Decorator.print(Calculator.sum(2,2));
        Decorator.print(Calculator.sub(2,2));
        Decorator.print(Calculator.mul(2,2));
        Decorator.print(Calculator.div(2,2));
    }
}
