import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CC_AlbumJPanel extends JPanel
implements ActionListener
{
	// global variables
	JLabel imageLabel1, imageLabel2, imageLabel3;
	JPanel buttonPanel, imagePanel1, imagePanel2, imagePanel3, cardPanel;
	ButtonGroup buttonGroup;
	JRadioButton button1, button2, button3;
	CardLayout cl = new CardLayout();
	
	String url1 = "https://static.wikia.nocookie.net/villains/images/1/14/Benny_%28FNV%29.jpg/revision/latest/top-crop/width/360/height/450?cb=20110216232707";
	String url2 = "https://upload.wikimedia.org/wikipedia/en/thumb/d/dd/Tharealsplintercell.jpg/220px-Tharealsplintercell.jpg";
	String url3 = "https://upload.wikimedia.org/wikipedia/en/thumb/8/80/Halo_-_Combat_Evolved_%28XBox_version_-_box_art%29.jpg/220px-Halo_-_Combat_Evolved_%28XBox_version_-_box_art%29.jpg";
	
	// constructor
	public CC_AlbumJPanel() 
	{
		// layout
		this.setLayout(new BorderLayout());
		
		
		// font
		Font font = new Font("Arial", Font.PLAIN, 18);
		
		// setting up image label
		imagePanel1 = new JPanel();
		imagePanel2 = new JPanel();
		imagePanel3 = new JPanel();
		cardPanel = new JPanel(cl);
		URL newURL;
		try 
		{
			newURL = new URL(url1);
			Icon image1 = new ImageIcon(newURL);
			imageLabel1 = new JLabel(image1);
			imagePanel1.add(imageLabel1);
			
			newURL = new URL(url2);
			Icon image2 = new ImageIcon(newURL);
			imageLabel2 = new JLabel(image2);
			imagePanel2.add(imageLabel2);
			
			newURL = new URL(url3);
			Icon image3 = new ImageIcon(newURL);
			imageLabel3 = new JLabel(image3);
			imagePanel3.add(imageLabel3);
			
			cardPanel.add(imageLabel1, "1");
			cardPanel.add(imageLabel2, "2");
			cardPanel.add(imageLabel3, "3");
		} 
		catch (MalformedURLException e0) 
		{
			e0.printStackTrace();
			System.exit(0);
		}
		this.add(cardPanel, BorderLayout.NORTH);
		
		// setting up radio buttons and button group
		button1 = new JRadioButton("Button 1");
		button2 = new JRadioButton("Button 2");
		button3 = new JRadioButton("Button 3");
		
		button1.setFont(font);
		button2.setFont(font);
		button3.setFont(font);
		
		buttonGroup = new ButtonGroup();
		
		buttonGroup.add(button1);
		buttonGroup.add(button2);
		buttonGroup.add(button3);
		button1.setSelected(true);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	}
	
	
	// ActionListener methods
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (button1.isSelected()) 
		{
			cl.show(cardPanel, "1");
		}
		if (button2.isSelected()) 
		{
			cl.show(cardPanel, "2");
		}
		if (button3.isSelected()) 
		{
			cl.show(cardPanel, "3");
		}
	}
}
