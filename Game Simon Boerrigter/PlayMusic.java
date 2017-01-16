import java.net.URL;
import javax.sound.sampled.*;
public class PlayMusic {
  public void playSound(String soundname) {
    try{
      URL url = (URL) this.getClass().getResource("Music/"+soundname+".wav");
      AudioInputStream input = AudioSystem.getAudioInputStream(url);
      DataLine.Info info = new DataLine.Info(Clip.class, input.getFormat());
      Clip clip = (Clip) AudioSystem.getLine(info);
      clip.open(input);
      clip.start();
      int ms = ((int) clip.getMicrosecondLength())/1000;
      Thread.sleep(ms);
    }catch (Exception e) {
      System.out.println(e.toString());
    }
  }

}
