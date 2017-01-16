import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Battle2
{
  private int userLife = 100; // levens van speler.
  private int enemyLife = 125; // levens van enemy.
  private int choice = 0; // Keuzen van speler. als het fout gaat(string input) kan het nog naar 0 gaan(A.K.A attack) door exception.
  private int weapon = 15; // standaard maximale damage waarden.
  private int hidden = 1;
  public void fight()
  {
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    Secret secret = new Secret();
    PlayMusic music = new PlayMusic();
    secret.weapons(); // Kans voor een beter wapen!
    if (secret.verkrijgen() == true){
        System.out.println("You got the secret weapon!");
        weapon += 10; // Er is een hogere damage kans.
    }
    // Laat mogelijke commands zien voor user.
    System.out.println("______________");
    System.out.println("Its your turn!");
    System.out.println("0 = Atack");
    System.out.println("1 = Run away");
    System.out.println("2 = Heal");
    System.out.print("Your input: ");
    try{
    choice = Integer.parseInt(in.nextLine());
  }catch(NumberFormatException e){
    choice = 0;
    System.out.println("Invalid userinput, using default value of " + choice);
  }
  if (choice==0){
    System.out.println("You attacked the monster!");
    enemyLife -= rand.nextInt(weapon) + 1; // rand.nextInt(WEAPONS) kan verandert worden door Secret weapon.
    music.playSound("attack");
  } else if (choice==1){
    int action = rand.nextInt(2) + 1;
    if (action==1){
      System.out.println("You ran away!");
      hidden = 2;
    } else {
      System.out.println("While you were trying to ran away, you felt down and lost some health!");
      userLife -= 15;
  }
} else if (choice==2){
  System.out.println("Healing....");
  music.playSound("heal");
  userLife += rand.nextInt(25) + 1;
  if (userLife>=100) {
    userLife = 100; // levens van speler mag niet hoger dan 100.
  }
} else {
  System.out.println("You attacked the monster");
  enemyLife -= rand.nextInt(weapon) + 1; // Als user hoger dan 1 kiest, gaat altijd attack doen.
  music.playSound("attack");
}
// wacht een paar seconden voor de Enemy. Geeft sfeer aan het spel.
System.out.println("Enemy turn...");
try {
    TimeUnit.SECONDS.sleep(1);
} catch (InterruptedException e) {
}
if (hidden!=1){ // Enemy ziet speler niet en dus kan geen damage doen(moet wachten). De (1) is nodig voor random!
  System.out.println("INFO: You are not spotted yet.");
  hidden = rand.nextInt(2) + 1; // 50% kans dat je weer gezien kan worden.
  music.playSound("info");
} else {
  userLife -= rand.nextInt(20) + 1; // Enemy gaat damage doen. Ziet speler.
}
// health niet lager dan 0 laten zien!
if (userLife<=0){
  userLife = 0;
} else if (enemyLife<=0){
  enemyLife = 0;
}
// Laat status zien(levens).
System.out.println("Status: Your health: "+userLife+" Enemy health: "+enemyLife);
}
    public boolean userDead()
    {
      if(userLife<=0){
        return true;
      } else {
        return false;
      }
    }
    public boolean enemyDead()
    {
      if(enemyLife<=0){
        return true;
      } else {
        return false;
      }
    }
  }
