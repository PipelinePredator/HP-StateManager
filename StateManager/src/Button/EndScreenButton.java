package Button;

import java.awt.Font;
import java.awt.image.BufferedImage;

import FrameClasses.MouseManager;

public class EndScreenButton extends MenuButton {
	
	private static Font buttonFont = new Font("Arial", Font.BOLD, 40);
	public BufferedImage[] buttons = new BufferedImage[2];
	
	public EndScreenButton(String buttonName, int width, int height, int xPosition, int yPosition,  MouseManager mouseManager) {
		super(buttonName, width, height, xPosition, yPosition, buttonFont, mouseManager);
		buttons = super.buttons;
		// TODO Auto-generated constructor stub
	}
	
	
}
