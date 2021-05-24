import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class CC_MouseMotionJPanel extends JPanel
implements MouseMotionListener, MouseListener
{
	// controls and variables are globally initialized
	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;
	JLabel x_coord, y_coord;
	JButton leftButton, middleButton, rightButton;
	Color c;
	
	// constructor
	public CC_MouseMotionJPanel() 
	{
		// settings are created first
		setLayout(new BorderLayout());
		
		// create the layout for the program using panels
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		northPanel.setLayout(new FlowLayout());
		southPanel.setLayout(new FlowLayout());
		
		// labels for x and y coords go in north panel
		x_coord = new JLabel("X:");
		y_coord = new JLabel("Y:");
		
		northPanel.add(x_coord);
		northPanel.add(y_coord);
		
		// buttons for mouse go in south panel
		leftButton = new JButton("Left");
		middleButton = new JButton("Middle");
		rightButton = new JButton("Right");
		
		southPanel.add(leftButton);
		southPanel.add(middleButton);
		southPanel.add(rightButton);
		c = leftButton.getBackground();
		
		// drop the panels into the app
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		// implement MouseMotionListener while also considering each button
		addMouseMotionListener(this);
		leftButton.addMouseMotionListener(this);
		middleButton.addMouseMotionListener(this);
		rightButton.addMouseMotionListener(this);
		
		// implement MouseListener
		leftButton.addMouseListener(this);
		middleButton.addMouseListener(this);
		rightButton.addMouseListener(this);
	}
	
	// MouseMotionListener methods
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) 
	{
		x_coord.setText("X: " + e.getX());
		y_coord.setText("Y: " + e.getY());
		
		if(e.getX() < 291 && e.getY() < 280) 
		{
			leftButton.setBackground(Color.BLACK);
			middleButton.setBackground(Color.BLACK);
			rightButton.setBackground(Color.BLACK);
		}
		if(e.getX() > 291 && e.getY() < 280) 
		{
			leftButton.setBackground(Color.GREEN);
			middleButton.setBackground(Color.GREEN);
			rightButton.setBackground(Color.GREEN);
		}
		if(e.getX() > 291 && e.getY() > 280 && (e.getSource() != leftButton)
				&& (e.getSource() != middleButton) && (e.getSource() != rightButton)) 
		{
			leftButton.setBackground(Color.MAGENTA);
			middleButton.setBackground(Color.MAGENTA);
			rightButton.setBackground(Color.MAGENTA);
		}
		if(e.getX() < 291 && e.getY() > 280 && (e.getSource() != leftButton)
				&& (e.getSource() != middleButton) && (e.getSource() != rightButton)) 
		{
			leftButton.setBackground(Color.YELLOW);
			middleButton.setBackground(Color.YELLOW);
			rightButton.setBackground(Color.YELLOW);
		}
		if (e.getSource() == leftButton)
		{
	      leftButton.setBackground(Color.RED);
		} 
		
	    if (e.getSource() == middleButton)
	    {
	      middleButton.setBackground(Color.RED);
	    } 
	    
	    if (e.getSource() == rightButton)
	    {
	      rightButton.setBackground(Color.RED);
	    }
	}
	
	// MouseListener methods
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e)
	{
		if (e.getSource() == leftButton)
		{
	      leftButton.setBackground(c);
		} 
		
	    if (e.getSource() == middleButton)
	    {
	      middleButton.setBackground(c);
	    } 
	    
	    if (e.getSource() == rightButton)
	    {
	      rightButton.setBackground(c);
	    } 
	}
	public void mousePressed(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
	      leftButton.setBackground(Color.BLUE);
	    }
		
	    if (e.getButton() == MouseEvent.BUTTON2)
	    {
	      middleButton.setBackground(Color.BLUE);
	    }
	    
	    if (e.getButton() == MouseEvent.BUTTON3)
	    {
	      rightButton.setBackground(Color.BLUE);
	    }
	}
	public void mouseReleased(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
	      leftButton.setBackground(c);
	    }
		
	    if (e.getButton() == MouseEvent.BUTTON2)
	    {
	      middleButton.setBackground(c);
	    }
	    
	    if (e.getButton() == MouseEvent.BUTTON3)
	    {
	      rightButton.setBackground(c);
	    }
	}
}