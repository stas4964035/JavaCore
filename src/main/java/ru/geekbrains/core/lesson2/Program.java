package ru.geekbrains.core.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static char[][] field;
    private static int aiTargetX = 0;
    private static int aiTargetY = 0;


    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {

                humanTurn();
                printField();
                if (checkState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.println("Сыграть еще раз?(Y/N)");
            if (!scanner.next().equalsIgnoreCase("Y")) break;
        }
    }

    /**
     * Инициализация
     **/
    static void initialize() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /*
     * Печать текущего состояния поля
     * */
    static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print("-" + (x + 1));
        }
        System.out.println("-");

        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }
        for (int x = 0; x < fieldSizeX * 2 + 2; x++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("%d %d\n", aiTargetX + 1, aiTargetY + 1);
    }

    /*
     * Ход человека
     * */
    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите кооры хода X и Y\n(от 1 до 3) через пробел:");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    static void aiTurn() {
        int x;
        int y;
        if (aiTargetY > 0 || aiTargetX > 0) {
            System.out.println("THIS");
            field[aiTargetX][aiTargetY] = DOT_AI;
            aiTargetX = 0;
            aiTargetY = 0;
        } else {
            do {
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            } while (!isCellEmpty(x, y));
            field[x][y] = DOT_AI;
        }
    }

    /*
     * Проверка пустоты ячейки
     * */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /*
     * проверка валидности координат хода
     * */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /*
     * проверка на ничью
     * */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    /**
     * Проверка на победу по линии
     *
     * @param x
     * @param y
     * @param axisX true - по оси X, false - по оси Y
     * @param dot
     * @return
     */
    static boolean checkWinLine(int x, int y, boolean axisX, char dot) {
        byte count = 1;
        if (axisX) {
            while (isCellValid(x, y + 1) && field[x][y + 1] == dot) {
                y++;
                count++;
                if (count == WIN_COUNT) return true;
            }
            if (count >= WIN_COUNT - 2 && isCellValid(x, y + 1) && isCellEmpty(x, y + 1)) {
                aiTargetX = x;
                aiTargetY = y + 1;
            }
            if (count >= WIN_COUNT - 2 && isCellValid(x, y - WIN_COUNT + 2) && isCellEmpty(x, y - WIN_COUNT + 2)) {
                aiTargetX = x;
                aiTargetY = y - WIN_COUNT + 2;
            }
        } else {
            while (isCellValid(x + 1, y) && field[x + 1][y] == dot) {
                x++;
                count++;
                if (count == WIN_COUNT) return true;
            }
            if (count >= WIN_COUNT - 2 && isCellValid(x + 1, y) && isCellEmpty(x + 1, y)) {
                aiTargetX = x + 1;
                aiTargetY = y;
            }
            if (count >= WIN_COUNT - 2 && isCellValid(x - WIN_COUNT + 2, y) && isCellEmpty(x - WIN_COUNT + 2, y)) {
                aiTargetX = x - WIN_COUNT + 2;
                aiTargetY = y;
            }
        }

        return false;
    }

    /**
     * Проверка на победу по диагонали
     *
     * @param x
     * @param y
     * @param dot
     * @return
     */
    static boolean checkWinDiagonal(int x, int y, char dot) {
        byte count = 1;

        while (isCellValid(x + 1, y + 1) && field[x + 1][y + 1] == dot) {
            x++;
            y++;
            count++;
            if (count == WIN_COUNT) return true;
        }
        if (count >= WIN_COUNT - 2 && isCellValid(x + 1, y + 1) && isCellEmpty(x + 1, y + 1)) {
            aiTargetX = x + 1;
            aiTargetY = y + 1;
        }
        if (count >= WIN_COUNT - 2 && isCellValid(x - WIN_COUNT + 2, y - WIN_COUNT + 2) && isCellEmpty(x - WIN_COUNT + 2, y - WIN_COUNT + 2)) {
            aiTargetX = x - WIN_COUNT + 2;
            aiTargetY = y - WIN_COUNT + 2;
        }

        return false;
    }

    /*
     * Проверка на победу
     *
     * */
    static boolean checkWin(char dot) {

        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == dot) {
                    if (checkWinLine(x, y, true, dot)) return true;
                    if (checkWinLine(x, y, false, dot)) return true;
                    if (checkWinDiagonal(x, y, dot)) return true;
                }
            }
        }
        return false;
    }

    /**
     * Проверка состояния игры
     *
     * @param dot фишка игрока
     * @param s   победный слоган
     * @return
     */
    static boolean checkState(char dot, String s) {
        if (checkWin(dot)) {
            System.out.println(s);
            return true;
        } else if (checkDraw()) {
            System.out.println("Ничья");
            return true;
        }
        return false;
    }
}
