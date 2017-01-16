import java.util.Scanner;
import java.util.Random;
public class Game
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Start game....");
    System.out.print("What is your name? ");
    String name = input.nextLine();
    Battle start = new Battle(); // Ronden 1.
    Secret secret = new Secret();
    Battle2 start2 = new Battle2(); // Ronden 2.
    PlayMusic music = new PlayMusic();
    while(start.enemyDead() == false && start.userDead() == false) {
      start.fight(); // Start het gevecht.
    }
    if (start.enemyDead() == true){
      System.out.println("Good job " + name + ". You won this battle!");
    } else if (start.userDead() == true){
      System.out.println("You Lost the battle.");
      music.playSound("fail");
      System.exit(1);
    } else {
      System.out.println("No one won this battle.");
      music.playSound("fail");
      System.exit(1);
    }

    // Start verhaal.
    System.out.println(name+"'s adventure proceeds... While "+name+" is trying to find a new monster, "+name+" found a weapon laying down next of the tree. "+name+ " Picked up the sword and use it for his next target. After 2 minuts, "+name+" found a monster.");
    // Einde verhaal.

    // Start ronden 2!
    while(start2.enemyDead() == false && start2.userDead() == false) {
      start2.fight(); // Start het gevecht.
    }
    if (start2.enemyDead() == true){
      System.out.println("Good job " + name + ". You won this battle!");
    } else if (start2.userDead() == true){
      System.out.println("You Lost the battle.");
      music.playSound("fail");
      System.exit(1);
    } else {
      System.out.println("No one won this battle.");
      music.playSound("fail");
      System.exit(1);
    }
    System.out.println(name+" has reached the safe area were people are getting protected. "+name+" is going to stay and live here a good life.");
    music.playSound("victory");
  }
}
