package com.company.tasks;
import java.util.Scanner;
/* Задачи на поиграться:
1. Хочу уметь создавать разные экземпляры фигур и узнавать их площадь в зависимости от их параметров.
  а) Есть длина и ширина прямоугольника, нужно получать площадь.
2) Радиус или диаметр круга - так же площадь. */
public class Squares {

        public double Sqr() {
        Scanner in = new Scanner(System.in);
        double figSqr = 0;
        String[] objects = {"прямоугольник", "круг", "диаметр", "радиус"};
        String[] parameters = {"Длина: ", "Ширина: ", "Задайте диаметр: ", "Задайте радиус: "};
        System.out.print("Выберите фигуру (прямоугольник или круг): ");
        String figure = in.next();
        System.out.println("Выбран " + figure);

        //1. Площадь прямоугольника
        if (figure.equals(objects[0])){
            System.out.println("Введите параметры");
            System.out.print(parameters[0]);
            double rectLength = in.nextDouble();
            System.out.print(parameters[1]);
            double rectWidth = in.nextDouble();
            figSqr = rectLength * rectWidth;
            System.out.println("Площадь прямоугольника равна " + figSqr);
        }
        //2. Площадь круга
        else if (figure.equals(objects[1])){
            System.out.print("Выберите параметр (диаметр или радиус): ");
            String diameter = in.next();
            if(diameter.equals(objects[2])) {
                System.out.print(parameters[2]);
                double circRadius = in.nextDouble()/2;
                figSqr = Math.PI * circRadius * circRadius;
                System.out.println("Площадь круга равна " + figSqr);
            } else if (diameter.equals(objects[3])) {
                System.out.print(parameters[3]);
                double circRadius = in.nextDouble();
                figSqr = Math.PI * circRadius * circRadius;
                System.out.println("Площадь круга равна " + figSqr);
            }
        }
            return figSqr;
    }
}
