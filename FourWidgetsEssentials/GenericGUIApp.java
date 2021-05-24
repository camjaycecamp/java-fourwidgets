/*
 * cameron campbell
 * advanced java
 * occc spring 2021
 * four widgets + generic gui app
 */

import java.awt.*;
import javax.swing.*;

public class GenericGUIApp extends JFrame
{
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	
	public static void main(String[] args) 
	{
		GenericGUIApp g = new GenericGUIApp();
	}
	
	public GenericGUIApp() 
	{
		super("My Generic GUI App");
	     setDefaultCloseOperation(EXIT_ON_CLOSE);
	     setLayout(new GridLayout(1,1));
	     JPanel jp = new CC_RotatingCowJPanel();
	     add(jp);
	     setSize(WIDTH, HEIGHT);
	     setResizable(false);
	     setVisible(true);
	}
}
