import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

public class CC_SoundboardJPanel extends JPanel
implements ActionListener
{
	// global controls
	JButton button1, button2, button3;
	
	// constructor
	public CC_SoundboardJPanel() 
	{
		// layout
		this.setLayout(new BorderLayout());
		
		// panels
		JPanel buttonsPanel = new JPanel();
		JPanel titlePanel = new JPanel();
		
		// font
		Font smallFont = new Font("Arial", Font.PLAIN, 22);
		Font largeFont = new Font("Arial", Font.PLAIN, 48);
		
		// title
		JLabel titleLabel = new JLabel("SOUNDBOARD");
		titleLabel.setFont(largeFont);
		titlePanel.add(titleLabel);
		
		// buttons section
		button1 = new JButton("Goggles");
		button2 = new JButton("Shield");
		button3 = new JButton("Incredibilis");
		
		button1.setFont(smallFont);
		button2.setFont(smallFont);
		button3.setFont(smallFont);
		
		/*
		 * assemble all JPanels into a single JPanel
		 */
		buttonsPanel.setLayout(new GridLayout(3, 1));
		
		buttonsPanel.add(button1);
		buttonsPanel.add(button2);
		buttonsPanel.add(button3);
		
		// finally, implement the ActionListener handlers for all controls that can be clicked
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(buttonsPanel, BorderLayout.CENTER);
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
	
	// ActionListener methods
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == button1) 
		{
			playSound(System.getProperty("user.dir") + "\\CC_SoundboardFiles\\CC_goggles.wav");
		}
		if (e.getSource() == button2) 
		{
			playSound(System.getProperty("user.dir") + "\\CC_SoundboardFiles\\CC_shield.wav");
		}
		if (e.getSource() == button3) 
		{
			playSound(System.getProperty("user.dir") + "\\CC_SoundboardFiles\\CC_incredibilis.wav");
		}
	}
}