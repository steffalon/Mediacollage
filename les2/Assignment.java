import java.util.Scanner;
public class Assignment{
  public void showAssignment(){
    System.out.println("Assignment 1: Jay you just completed your first assignment");
    System.out.println("Assignment 2: create 3 variables here, one for your name, age and one for your postal code. Print the values to the commandline!");


    System.out.println("Assignment 3: Use the Scanner datatype to allow a user to enter the values for name, age, and postal code. ");
    System.out.println("Note: Find out about datatypes at the Application Programming Interface(API) reference https://docs.oracle.com/javase/7/docs/api/allclasses-noframe.html. Select the Scanner link.");

    Scanner in = new Scanner(System.in);
    String name = " ";
    int age = 0;
    String postalcode = " ";
    System.out.println("What is your name?");
    name = in.nextLine();
    System.out.println("How old are you?");
    try{
    age = Integer.parseInt(in.nextLine());
  }catch(NumberFormatException e){
    System.out.println("Invalid age, using default value of " + age);
  }
    System.out.println("What is your postal code?");
    postalcode = in.nextLine();
    System.out.println("Your age is "+ age + " and your name is "+ name +" and your postalcode is " + postalcode);

    }
  }
