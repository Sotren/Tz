package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void printMenu() {
        System.out.println("|                        Меню                        |");
        System.out.println("| Выбор:                                             |");
        System.out.println("|1.Просмотр сведений об автомобиле из списка.        |");
        System.out.println("|2.Добавление нового автомобиля.                     |");
        System.out.println("|3.Удаление автомобиля из списка.                    |");
        System.out.println("|4.Редактирование информации об автомобиле из списка.|");
        System.out.println("|5.Выход.                                            |");
        System.out.println();
    }

    public static void printCars(List<CarClass> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(i + ".");
            cars.get(i).shortInfo();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       List<CarClass> Cars = new ArrayList();
       try {
           ObjectInputStream ois = new ObjectInputStream(new FileInputStream("CarsList.txt"));
           Cars = ((ArrayList<CarClass>) ois.readObject());
           ois.close();
       }
       catch (Exception e){
           System.out.println("Список автомобилей пуст");
       }
        int swValue;
        boolean exit = false;
        while (!exit) {
            printMenu();
            printCars(Cars);
            swValue = Keyin.inInt("Выберите действие: ");
            if (swValue!=2 && swValue!=5 && Cars.size()==0){
                System.out.println("Действие не возможно");
                continue;
            }
            switch (swValue) {
                case 1:
                    System.out.println("1.Просмотр сведений об автомобиле из списка. ");
                    System.out.println("Введите номер автомобиля");
                   int number = Keyin.inInt("Выбрать номер : ");
                    while (number>=Cars.size())
                    {
                        System.out.println("Выбрали не сущестующтй атомабиль ");
                        number = Keyin.inInt("выбрать номер : ");
                    }
                    Cars.get(number).getInfo();
                    System.in.read();
                    break;

                case 2:
                    System.out.println("2.Добавление нового автомобиля.");
                    CarClass car = new CarClass();
                    car.setParameters();
                    Cars.add(car);
                    break;
                case 3:
                    System.out.println("3.Удаление автомобиля из списка.");
                    try {
                        int numberDel = Keyin.inInt("Выбрать номер автомобиля для удаления : ");
                        Cars.remove(numberDel);
                    }
                    catch (Exception e){
                        System.out.println("Выбрали не существует автомобиль");
                    }
                    break;
                case 4:
                    System.out.println("4.Редактирование информации об автомобиле из списка.");
                    int numberEd=Keyin.inInt("Выбор автомобиля");
                    Cars.get(numberEd).setParameters();
                    break;
                case 5:
                    System.out.println("Выход.");
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CarsList.txt"));
                    oos.flush();
                    oos.writeObject(Cars);
                    oos.close();
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный ввод");
                    break;
            }

        }
    }

    }











