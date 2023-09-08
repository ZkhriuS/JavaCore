package com.gb.grizzle;

import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final char PLAYER = 'X';
    private static final char BOT = '0';
    private static final char EMPTY = '*';
    private static int winNumber = 4;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static int sizeX;
    private static int sizeY;
    private static char[][] field;

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            do {
                humanTurn();
                printField();
                if (checkGameState(PLAYER, "Победил игрок!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(BOT, "Победил компьютер!"))
                    break;
            } while (true);
            System.out.println("Сыграть ещё раз?");
            if (!scanner.next().equalsIgnoreCase("y"))
                break;
        }
    }
    /**
     * Запрос на ввод числового значения
     */
    private static int promptValue(String message, String errorMessage) {
        int value;
        do {
            System.out.println(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine();
                break;
            }
            System.out.println(errorMessage);
            scanner.nextLine();
        } while (true);
        return value;
    }

    /**
     * Проверка корректности размера поля
     * @param value
     * @return
     */
    private static boolean validFieldSize(int value) {
        return value > 0;
    }

    /**
     * Инициализация поля
     */
    private static void initialize() {
        int valueX = promptValue("Введите размер поля по горизонтали:", "Введенный размер содержит нечисловые символы");
        sizeX = (validFieldSize(valueX)) ? valueX : 3;
        int valueY = promptValue("Введите размер поля по вертикали:", "Введенный размер содержит нечисловые символы");
        sizeY = (validFieldSize(valueY)) ? valueY : 3;
        if (sizeX != valueX || sizeY != valueY)
            System.out.println("Для неверно заданных размеров установлено значение по умолчанию - 3");
        field = new char[sizeX][sizeY];
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                field[x][y] = EMPTY;
            }
        }
    }

    /**
     * Обработка вывода в консоль
     */
    private static void printField() {
        System.out.print(" ");
        for (int i = 0; i < 2 * sizeY + 1; i++) {
            System.out.print((i % 2 == 0) ? " " : i / 2 + 1);
        }
        System.out.println();
        for (int x = 0; x < sizeX; x++) {
            System.out.print((x + 1) + "|");
            for (int y = 0; y < sizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < 2 * (sizeY + 1); i++)
            System.out.print("-");
        System.out.println();
    }

    /**
     * Обработка хода человека
     */
    private static void humanTurn() {
        int posX, posY;
        do {
            posX = promptValue("Введите координату по горизонтали", "Введенная координата содержит нечисловые символы") - 1;
            posY = promptValue("Введите координату по вертикали", "Введенная координатаа содержит нечисловые символы") - 1;
        } while (!isCellValid(posX, posY) || !isCellEmpty(posX, posY));
        field[posX][posY] = PLAYER;
    }

    /**
     * Обработка хода компьютера
     */
    private static void botTurn() {
        int posX, posY;
        do {
            posX = random.nextInt(sizeX);
            posY = random.nextInt(sizeY);
        } while (!isCellEmpty(posX, posY));
        field[posX][posY] = BOT;
    }

    /**
     * Обработка хода умного компьютера
     */
    private static void aiTurn() {
        int tempWin = winNumber;
        while(winNumber>2){
            for (int x = 0; x < sizeX; x++) {
                for (int y = 0; y < sizeY; y++) {
                    if (isCellEmpty(x, y)) {
                        field[x][y] = BOT;
                        if(checkWin(BOT)) {
                            winNumber=tempWin;
                            return;
                        }
                        field[x][y] = PLAYER;
                        if(checkWin(PLAYER)){
                            field[x][y]=BOT;
                            winNumber=tempWin;
                            return;
                        }
                        field[x][y]=EMPTY;
                    }
                }
            }
            winNumber--;
        }
        winNumber=tempWin;
        botTurn();
    }

    /**
     * Проверка корректности координат поля
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < sizeX && y >= 0 && y < sizeY;
    }

    /**
     * Проверка на пустую клетку
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == EMPTY;
    }

    /**
     * Проверка текущего состояния игры
     * @param c фишка игрока
     * @param message сообщение о победе
     * @return
     */
    private static boolean checkGameState(char c, String message) {
        if (checkWin(c)) {
            System.out.println(message);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    /**
     * Проверка победы
     * @param c фишка игрока
     * @return
     */
    private static boolean checkWin(char c) {
        // Проверка по трем горизонталям
        boolean result = false;
        result = checkWinHorizon(c);
        result |= checkWinVertical(c);
        result |= checkWinLeftDiag(c);
        result |= checkWinRightDiag(c);
        return result;

    }

    /**
     * Проверка горизонтальной комбинации
     * @param c фишка игрока
     * @return
     */
    private static boolean checkWinHorizon(char c) {
        int counter = 0;
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (field[x][y] == c) {
                    counter++;
                } else
                    counter = 0;
                if (counter == winNumber)
                    return true;
            }
        }
        return false;
    }

    /**
     * Проверка вертикальной комбинации
     * @param c фишка игрока
     * @return
     */
    private static boolean checkWinVertical(char c) {
        int counter = 0;
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                if (field[x][y] == c) {
                    counter++;
                } else
                    counter = 0;
                if (counter == winNumber)
                    return true;
            }
        }
        return false;
    }

    /**
     * Проверка комбинации в левой диагонали
     * @param c фишка игрока
     * @return
     */
    private static boolean checkWinLeftDiag(char c) {
        int counter = 0;
        for (int x = 0; x <= sizeX - winNumber; x++) {
            for (int y = 0; y <= sizeY - winNumber; y++) {
                while (field[x + counter][y + counter] == c) {
                    counter++;
                    if (counter == winNumber)
                        return true;
                }
                counter = 0;
            }
        }
        return false;
    }

    /**
     * Проверка комбинации в правой диагонали
     * @param c фишка игрока
     * @return
     */
    private static boolean checkWinRightDiag(char c) {
        int counter = 0;
        for (int x = sizeX - 1; x >= winNumber - 1; x--) {
            for (int y = 0; y <= sizeY - winNumber; y++) {
                while (field[x - counter][y + counter] == c) {
                    counter++;
                    if (counter == winNumber)
                        return true;
                }
                counter = 0;
            }
        }
        return false;
    }

    /**
     * Проверка на ничью
     * @return
     */
    private static boolean checkDraw() {
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }
}
