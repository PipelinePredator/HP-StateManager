package Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MainMenuButton extends MenuButton{
 
	
	
	private static Font buttonFont = new Font("Arial", Font.BOLD, 24);
	public BufferedImage[] buttons = new BufferedImage[2];
	



	public MainMenuButton(String buttonName, int width, int height, int xPosition, int yPosition) {
		super(buttonName, width, height, xPosition, yPosition, buttonFont);
		buttons = super.buttons;
	}
	
	
	
}
