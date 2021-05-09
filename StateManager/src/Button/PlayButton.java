package Button;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class PlayButton extends MenuButton{
	
	private static Font buttonFont = new Font("TimesRoman", Font.ITALIC, 24);
	public BufferedImage[] buttons = new BufferedImage[2];

	public PlayButton(String buttonName, int width, int height, int xPosition, int yPosition) {
		super(buttonName, width, height, xPosition, yPosition, buttonFont);
		this.buttons = super.buttons;
		
	}
	
	
	
	



	
}
