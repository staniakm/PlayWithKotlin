package javaToKotlin;

import org.mariusz.Car;

public class KotlinProcessor {
    public static void main(String[] args) {
        KotlinCar car = new KotlinCar("Fiat", "Panda", 2009, 1200);
        System.out.println(car);
        System.out.println(car.getMake());
        //componentN
        System.out.println(car.component1());

        System.out.println(KotlinClassForJavaKt.kotlinCalculations("my Name"));
    }
}
