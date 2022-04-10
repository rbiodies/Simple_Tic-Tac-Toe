package tictactoe;

import java.util.Scanner;

public class Main {
    static char[][] array = new char[3][3];

    public static void main(String[] args) {
        initArray(array);
        printGrid(array);
        while (true) {
            enterCoordinates(array, 'X');
            printGrid(array);
            if (checkGrid(array) == 1)
                break;
            enterCoordinates(array, 'O');
            printGrid(array);
            if (checkGrid(array) == 1)
                break;
        }
    }

    static void initArray(char[][] array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = ' ';
            }
        }
    }

    static void printGrid(char[][] array) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static void enterCoordinates(char[][] array, char ch) {
        Scanner     scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the coordinates: ");
            String str = scanner.nextLine();
            String[] coordinates = str.split(" ");

            if (coordinates[0].equals("exit")) {
                System.exit(0);
            } else if (coordinates.length != 2) {
                System.out.println("You should enter 2 numbers!");
                continue;
            }
            try {
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (array[x - 1][y - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    array[x - 1][y - 1] = ch;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }

    static int checkGrid(char[][] array) {
        if (checkHorizonAndVertical(array) == 1) {
            return 1;
        } else if (array[0][0] != ' ' && array[0][0] == array[1][1] && array[1][1] == array[2][2]) {
            System.out.println(array[0][0] + " wins");
            return 1;
        } else if (array[0][2] != ' ' && array[0][2] == array[1][1] && array[1][1] == array[2][0]) {
            System.out.println(array[0][2] + " wins");
            return 1;
        } else {
            return countCharacters(array);
        }
    }

    static int  checkHorizonAndVertical(char[][] array) {
        for (int i = 0; i < 3; i++) {
            if (array[i][0] != ' ' && array[i][0] == array[i][1] && array[i][1] == array[i][2]) {
                System.out.println(array[i][0] + " wins");
                return 1;
            }
            if (array[0][i] != ' ' && array[0][i] == array[1][i] && array[1][i] == array[2][i]) {
                System.out.println(array[0][i] + " wins");
                return 1;
            }
        }
        return 0;
    }

    static int countCharacters(char[][] array) {
        int     x = 0;
        int     o = 0;
        int     space = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == 'X') {
                    x++;
                } else if (array[i][j] == 'O') {
                    o++;
                } else {
                    space++;
                }
            }
        }
        return checkCharacters(x, o, space);
    }

    static int  checkCharacters(int x, int o, int space) {
        if (Math.abs(x - o) > 1) {
            System.out.println("Impossible");
            return 1;
        } else if (space == 0) {
            System.out.println("Draw");
            return 1;
        }
        return 0;
    }
}
