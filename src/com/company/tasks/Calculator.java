package com.company.tasks;
import java.util.Scanner;

public class Calculator {
    static Scanner input = new Scanner(System.in);
    //сначала включил сканер в Мэйн, но по мере появления методов понял,
    //что надо вынести сразу в класс, чтобы иметь доступ из любого метода

    public double Calc(){
        System.out.print("Введите первое число: ");
        double num1 = input.nextDouble();
        System.out.print("Введите второе число: ");
        double num2 = input.nextDouble();
        char sign = getOperation();
        double result = operation(num1,num2,sign);
        System.out.println("Результат: " + result);
        return result;
    }

    public static double operation(double digit1, double digit2, char oper){
        // сначала прописал свич в мэйне, потом решил вывести в отдельный метод, чтобы не копировать в каждый кейс вывод результата
        double result;
        switch (oper) {
            case '+':
                result = digit1 + digit2;
                break;
            case '-':
                result = digit1 - digit2;
                break;
            case '*':
                result = digit1 * digit2;
                break;
            case '/':
                result = digit1 / digit2;
                break;
            case 'Z':
                System.out.println("Санкционная ситуация. Вы отменены в мировом сообществе. Ваши сбережения изъяты. Подумайте над своим поведением и...");
                result = operation(digit1,digit2,getOperation());
                break;
            default:
                //c возвратом result получил гемор, цикл потребовал дефолт и какое-то уведомление о некорректном вводе типа throw new, которое выводит ошибку кода,
                //по логике решил заменить его на инфу об ошибке своим уведомлением (далее решил добавить инфу об ошибках ввода и в плане вводимых чисел)
                //следовательно, потребовалось и решение для возврата к исполнению ввода знака операции
                //сначала на этом этапе код начал проваливаться в бесконечность, когда в result третьей позицией прописал просто oper.
                //начал гуглить по инициации повторного ввода данных, набрел на примеры таких калькуляторов, стал анализировать
                System.out.println("Неправославный математический знак. За вами уже выехали. Попробуйте реабилитироваться.");
                result = operation(digit1,digit2,getOperation());
        }
        return result;
    }

    public static char getOperation(){
        //ввод знака операции через отдельный метод помог в решении проблемы перезапуском ввода из свича
        System.out.print("Введите желаемую операцию (+ - / *): ");
        char signIn;
        if (input.hasNext()) {
            signIn = input.next().charAt(0); //не знал эту команду и команду hasNext - гуглил, как сделать ввод 1 символа и проверку на соответствие
        } else {
            //потом обратил внимание на такой параметр для рекурсии - input.next(); в примерах в инете,
            //понимашки его назначения в текущих условиях не сложилось, вроде и без него работает как предполагается.
            signIn = getOperation();
        }
        return signIn;
    }
}
