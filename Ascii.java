import java.util.Scanner;
public class Ascii
{
  public static void main(String[] args)
  {
Scanner scan = new Scanner(System.in);
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int e = 0;
    // user input
    a = scan.nextInt();
    b = scan.nextInt();
    c = scan.nextInt();
    d = scan.nextInt();
    e = scan.nextInt();
    int[] num = {a, b, c, d, e};
    String str =null;
    for(int i: num){
        str = Character.toString((char)i);
        System.out.println(str);
      }

  }
}
// gemaakt door Simon Boerrigter
