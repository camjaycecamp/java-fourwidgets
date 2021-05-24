import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.net.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class CC_RotatingCowJPanel extends JPanel
{
	// global variables
	JPanel gifPanel;
	JLabel gifLabel;
	
	// constructor
	public CC_RotatingCowJPanel()
	{
		this.setLayout(new BorderLayout());
		
		URL url;
		try 
		{
			url = new URL("https://media.tenor.com/images/de5baa5883f340e36d84e5251175f677/tenor.gif");
			Icon gif = new ImageIcon(url);
			gifLabel = new JLabel(gif);
			this.add(gifLabel, BorderLayout.CENTER);
			System.out.println(System.getProperty("user.dir") + "\\CC_RotatingCow.wav");
			playSound(System.getProperty("user.dir") + "\\CC_RotatingCow.wav");
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public void playSound(String soundName) 
	{
		try 
		{
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
}
