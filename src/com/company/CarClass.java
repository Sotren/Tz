package com.company;

import java.io.Serializable;

public class CarClass implements Serializable {
    private int year;
    private String model;
    private String manufacturer;
    private String bodyType;

    CarClass() {
        year = 0;
        model = "Default";
        bodyType = " Default";
        manufacturer = "Default";
    }
    CarClass (int year,String model,String manufacturer,String bodyType){
        this.year=year;
        this.model=model;
        this.bodyType=bodyType;
        this.manufacturer=manufacturer;
}
    public void getInfo(){
        System.out.println("Год: " + year);
        System.out.println("Модель: " + model);
        System.out.println("Тип кузова: " + bodyType);
        System.out.println("Производитель: " + manufacturer);

}
public  void shortInfo(){
    System.out.print(" " +year);
    System.out.print(" " +model);
   System.out.println(" ");
}

public void setParameters(){
    year = Keyin.inInt("Ввидте год выпуска");
    System.out.print("Введите модель ");
    model = Keyin.inString();
    System.out.print("Введите производителя ");
    manufacturer = Keyin.inString();
    System.out.print("Введите тип кузова ");
    bodyType = Keyin.inString();



}
}
