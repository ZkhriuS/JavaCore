package com.gb.grizzle;

public class Calculator {
    /**
     * Метод вычисления суммы чисел
     * @param a слагаемое
     * @param b слагаемое
     * @return сумма a и b
     */
    public static int sum(int a, int b){
        return a+b;
    }
    /**
     * Метод вычисления разности чисел
     * @param a уменьшаемое
     * @param b вычитаемое
     * @return разность a и b
     */
    public static int sub(int a, int b){
        return a-b;
    }
    /**
     * Метод умножения чисел
     * @param a множитель
     * @param b множитель
     * @return произведение a и b
     */
    public static int mul(int a, int b){
        return a*b;
    }
    /**
     * Метод деления чисел
     * @param a делимое
     * @param b делитель
     * @return частное a и b
     */
    public static int div(int a, int b){
        return a/b;
    }
}
