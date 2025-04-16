/*
* Create a Calculator class which will help us to calculate the area of Triangle, Circle, Cone and Square.
* it should accept arguments from the console depending on the number of arguments required.
* */

import java.util.Scanner;

public class Calculator {

    public double areaOfTriangle(double b, double h){
        return 0.5 * b * h;
    }

    public double areaOfCircle(double r){
        return 3.141 * r * r;
    }

    public double areaOfCone(double r, double l){
        return 3.141 * r * (r + l);
    }

    public double areaOfSquare(double s){
        return Math.pow(s, 2);
    }

    public static void main(String[] args){
        System.out.println("Please let us know what is the shape you want to find area");
        Scanner input = new Scanner(System.in);
        String shape = "";
        double length = 0;
        double radius = 0;
        double height = 0;

        do{
            if(!shape.isBlank()){
                System.out.println("Please select a valid shape : ");
            }
            shape = input.nextLine();

        }while(!(shape.equalsIgnoreCase("Circle") || shape.equalsIgnoreCase("Square")
                || shape.equalsIgnoreCase("Cone") || shape.equalsIgnoreCase("Triangle")));

        if(shape.equalsIgnoreCase("Circle")){
            System.out.println("Please enter the radius of circle you want to find area : ");
            radius = input.nextDouble();
        }else if(shape.equalsIgnoreCase("Square")){
            System.out.println("Please enter the length of the square you want to find area : ");
            length = input.nextDouble();
        }else if(shape.equalsIgnoreCase("Cone")){
            System.out.println("Please enter the radius & height of cone you want to find area : ");
            radius = input.nextDouble();
            height = input.nextDouble();
        }else if(shape.equalsIgnoreCase("Triangle")){
            System.out.println("Please enter the length & height of triangle you want to find area : ");
            length = input.nextDouble();
            height = input.nextDouble();
        }
        input.close();
        Calculator calculator = new Calculator();
        String result = switch (shape.toLowerCase()) {
            case "circle" -> "Area of " + shape + " is : " + calculator.areaOfCircle(radius);
            case "square" -> "Area of " + shape + " is : " + calculator.areaOfSquare(length);
            case "cone" -> "Area of " + shape + " is : " + calculator.areaOfCone(radius, height);
            case "triangle" -> "Area of " + shape + " is : " + calculator.areaOfTriangle(length, height);
            default -> "Unable to calculate area";
        };
        System.out.println(result);


    }
}
