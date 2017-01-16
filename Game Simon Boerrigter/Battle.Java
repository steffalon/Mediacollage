import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Battle
{
  private int userLife = 100; // levens van speler.
  private int enemyLife = 100; // levens van enemy.
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
//CHALLANGE 1!:
//Er missen hier wat println(print line)
//Geef hier instructies wat de speler kan kiezen
//Kijk naar de code beneden wat er gebeurt als user 0, 1 of 2 gebruikt
//bijvoorbeeld: System.out.println("1 = Gooien");







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
  music.playSound("attack");
  enemyLife -= rand.nextInt(weapon) + 1; // Als user hoger dan 1 kiest, gaat altijd attack doen.
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

//challange 2
//Je hebt vast wel gemerkt dat ik if, else en else if heb gebruikt.
//If is vertaalt in het nederlands "als"
//voorbeeld:
//  if (choice==2){
//  System.out.println("Healing....");
//  music.playSound("heal");
//  userLife += rand.nextInt(25) + 1;
//  }
//
//Betekend: Als de user input 2 gebrukt, {
//zeg dat je gaat healen
//speel een geluid af.
//heal met een random getal naar boven
//}
//
//Challange 2 is dat je de levens van de player en de enemy niet in een min getal komt.
//is kleiner dan zeg je zo in java: <=
//Maak een if statement: Als userLife kleiner is dan 0, userLife is 0.
//Maak daarna een elif statement: Als enemyLife kleiner is dan 0, enemyLife is 0.
//Bestudeer goed wat voor scrijf stijl je moet gebruiken. zoals { } ; ()





// Laat status zien(levens).
System.out.println("Status: Your health: "+userLife+" Enemy health: "+enemyLife);
}
//challange 3
//Onder zie je 2 boleans. Betekend kan waar of niet waar zijn. True of false.
//de naam zegt het al [userDead].
//Maak met een if statement: als userLife <= dan 0, return true. anders(else) return false.
//Doe het zelfde bij enemyDead.
    public boolean userDead()
    {

    }
    public boolean enemyDead()
    {

    }
  }
