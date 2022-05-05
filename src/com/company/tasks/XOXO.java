package com.company.tasks;

import java.util.Scanner;

//разбирал на основе обучающих решений в инете. Читал словесные пошаговые объяснения, прописывал в код по описанию,
//вникая в значение каждого элемента (где получалось самостоятельно), затем уже сверяя с кодом в инете, все ли правильно понял

public class XOXO {
    static Scanner playdata = new Scanner(System.in);
    final char signX = 'x'; //объявил константу для крестика
    final char signO = 'o'; //объявил константу для нолика буквой о
    final char signNull = '_'; //объявил константу для значения пустого поля
    char[][] field; //объявил двухмерный массив для игрового поля

    public XOXO(){ //создал конструктор (метод для объявления значений по умолчанию при создании объектов класса)
    field = new char[3][3]; //задал стандартный размер игрового поля
    }

    void newTable(){ //создал невозвратный метод для стартового поля с пустыми ячейками
        for(int row = 0; row < 3; row++) //цикл отвечает за перебор рядов
            for(int pos = 0; pos < 3; pos++) //вложенный цикл отвечает за перебор ячеек в рядах
                field [row][pos] = signNull; //передаю значения рядов и ячеек в массив для заполнения знаками пробела
    }

    void actTable(){ //создал невозвратный метод для отслеживания состояния поля в течение игры
        for(int row = 0; row < 3; row++){ //цикл отвечает за перебор рядов
            for(int pos = 0; pos < 3; pos++) //вложенный цикл отвечает за перебор ячеек в рядах
                System.out.print(field[row][pos]+" "); //вывод игрового поля с учетом внесенных символов
            System.out.println();
        }
    }

    boolean draw(){ //создал метод для определения ничьей при заполнении поля
        for(int row = 0; row < 3; row++) { //цикл отвечает за перебор рядов
            for (int pos = 0; pos < 3; pos++) //вложенный цикл отвечает за перебор ячеек в рядах
                if (field [row][pos] == signNull) //проверка на наличие пустых ячеек
                    return false; //метод не выполняется, если есть пустые ячейки
        }
        return true; //метод выполняется, если пустых ячеек нет
    }

    boolean cellCheck(int x, int y){ //создал метод для проверки выбранной игроком ячейки
        if (x<0 || y<0 || x>=3 || y>=3)
            return false;//если принимаемое значение координат ячейки в массиве не существует,
        return field[x][y] == signNull;
    }

    void playerXTurn(){ //создал метод для обработки действий игрока с крестиками
        int x; //объявил переменные для координат
        int y;
        do{
            System.out.println("Игрок 1. Введите координаты ячейки для крестика");
            System.out.print("Координата Х (от 1 до 3): ");
            x = playdata.nextInt() - 1;
            System.out.print("Координата Y (от 1 до 3): ");
            y = playdata.nextInt() - 1;
        } while (!cellCheck(x, y));
        field[x][y] = signX;
        }

    void playerOTurn(){ //объявляю метод для обработки действий игрока c ноликами
        int x;
        int y;
        do{
            System.out.println("Игрок 2. Введите координаты ячейки для нолика");
            System.out.print("Координата Х (от 1 до 3): ");
            x = playdata.nextInt() - 1;
            System.out.print("Координата Y (от 1 до 3): ");
            y = playdata.nextInt() - 1;
        } while (cellCheck(x, y));
        field[x][y] = signO;
    }

    boolean winner(char sign){ //создал метод для определения победителя с универсальным символом sign (и под Х и под О)
        for(int i = 0; i <= 3; i++){
            if((field[i][0] == sign && field[i][1] == sign && field[i][2] == sign)
                    || (field[0][i] == sign && field[1][i] == sign && field[2][i] == sign))
                return true; //условие на проверку трех одинаковых символов в ряд или в столбик
            if((field[0][0] == sign && field[1][1] == sign && field[2][2] == sign)
                    || (field[2][0] == sign && field[1][1] == sign && field[0][2] == sign))
                return true; //условие на проверку трех одинаковых символов по диагоналям
        }
        return false;
    }

    public void game (){ //создал метод для непосредственно игрового процесса
        newTable(); //инициировал пустое игровое поле дефолтной размерности 3х3, в соответствии с конструктором
        while (true){
            playerXTurn(); //инициация хода первого игрока
            actTable(); //инициация актуального состояния поля
            if (winner(signX)) { //проверка на победу
                System.out.println("Победа!");
                break;
            }
            if (draw()){ //проверка на ничью
                System.out.println("Ничья");
                break;
            }
            playerOTurn(); //инициация хода второго игрока
            actTable();//инициация актуального состояния поля
            if (winner(signO)) { //проверка на победу
                System.out.println("Победа!");
                break;
            }
            if (draw()){ //проверка на ничью
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("КОНЕЦ ИГРЫ");//итоговое сообщение о конце игры
        actTable();//состояние поля на конец игры
    }
}
