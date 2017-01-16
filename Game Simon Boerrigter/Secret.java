import java.util.Scanner;
import java.util.Random;
public class Secret
{
  private int getIt = 15;
  public void weapons()
  {
    Random rand = new Random();
    getIt -= 1; // Kans voor secret weapon word grooter na elke turn.
    getIt = rand.nextInt(getIt) + 1;
  }
    public boolean verkrijgen(){
      if(getIt==1){
        return true;
      } else {
        return false;
      }
    }
  }
